package controllers;

import play.Logger;
import play.data.DynamicForm;
import play.data.Form;
import play.mvc.*;
import static utils.CookieUtils.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class Post extends Controller
{
    @SuppressWarnings("rawtypes")
    public static Result Submit() throws IOException
    {
        DynamicForm.Dynamic formData = Form.form().bindFromRequest().get();
        // Save post data in a cookie instead of database, for now
        final List<Map> posts = cookieToList(Map.class,
                request().cookie(COOKIE_NAME));
        Map<String, Object> post = new HashMap<>();
        post.put("author", "ZoeyIsCool06");
        post.put("message-text", formData.getData().get("message-text")
                .toString());
        post.put("tag-text", formData.getData().get("tag-text").toString());
        posts.add(post);
        Logger.debug(posts.toString());
        response().setCookie(COOKIE_NAME, MAPPER.writeValueAsString(posts));
        return redirect("/app");
    }
}
