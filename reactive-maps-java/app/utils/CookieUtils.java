package utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import play.Logger;
import play.mvc.Http;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import controllers.Profile;

public class CookieUtils
{
    public static final String PROFILE_COOKIE = Profile.class.getSimpleName();
    public static final String COOKIE_NAME = "Posts";
    
    public static final ObjectMapper MAPPER = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            .configure(DeserializationFeature.FAIL_ON_INVALID_SUBTYPE, false)
            .configure(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES,
                    false)
            .configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false)
            .configure(DeserializationFeature.FAIL_ON_READING_DUP_TREE_KEY,
                    false)
            .configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);

    public static <T> List<T> cookieToList(Class<T> clazz, Http.Cookie cookie)
            throws JsonParseException, JsonMappingException, IOException

    {
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
    // Accepts string and the type of object that the string contents should be
    // converted to
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
