package controllers;

import play.Logger;
import play.data.DynamicForm;
import play.data.Form;
import play.mvc.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@JsonIgnoreProperties
public class Post extends Controller
{
    private static final ObjectMapper MAPPER = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            .configure(DeserializationFeature.FAIL_ON_INVALID_SUBTYPE, false)
            .configure(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES,
                    false)
            .configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false)
            .configure(DeserializationFeature.FAIL_ON_READING_DUP_TREE_KEY,
                    false)
            .configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);

    ;
    private static final String COOKIE_NAME = "Posts";

    @SuppressWarnings("rawtypes")
    public static Result Submit() throws SQLException, IOException
    {
        DynamicForm.Dynamic formData = Form.form().bindFromRequest().get();
        Logger.debug("Post post form data: " + formData.getData().toString());
        // Save post data in a cookie instead of database, for now
        final List<Map> posts = cookieToList(COOKIE_NAME, Map.class);
        Map<String, Object> post = new HashMap<>();
        //TODO: Get author from session once login implemented
        post.put("author", "ZoeyIsCool06");
        post.put("message-text", formData.getData().get("message-text")
                .toString());
        post.put("tag-text", formData.getData().get("tag-text").toString());
        posts.add(post);
        Logger.debug(posts.toString());
        response().setCookie(COOKIE_NAME, MAPPER.writeValueAsString(posts));
        return redirect("/app");
    }
    // Parse specified cookie and return as list of objects
    public static <T> List<T> cookieToList(String cookieName, Class<T> clazz)
            throws JsonParseException, JsonMappingException, IOException
    {
        final Http.Cookie cookie = request().cookie(cookieName);
        final List<T> posts = (cookie == null) ? new ArrayList<>()
                : stringToList(cookie.value(), clazz);
        return posts;
    }

    /**
     * Parse json string to list of specified type
     * 
     * @param contents
     * @param clazz
     * @return
     * @throws JsonParseException
     * @throws JsonMappingException
     * @throws IOException
     */
    // Accepts string and the type of object that the string contents should be converted to
    private static <T> List<T> stringToList(String contents, Class<T> clazz)
            throws JsonParseException, JsonMappingException, IOException
    {
        Logger.debug("This is the cookie string: " + contents);
        final List<?> listObj = MAPPER.readValue(contents, List.class);
        final List<T> result = new ArrayList<>();
        listObj.forEach(record -> result.add(MAPPER.convertValue(record, clazz)));

        return result;
    }
}
