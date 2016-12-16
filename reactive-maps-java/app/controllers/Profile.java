package controllers;

import play.Logger;
import play.data.DynamicForm;
import play.data.Form;
import play.mvc.*;
import models.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static utils.CookieUtils.*;

public class Profile extends Controller
{

    public static Result user_profile()
    {
        UserInfo userinfo = new UserInfo();
        return ok(views.html.profile.render(userinfo));
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static Result edit() throws IOException
    {
        DynamicForm.Dynamic formData = Form.form().bindFromRequest().get();
        // Save post data in a cookie instead of database, for now
        List<Map> profileList = cookieToList(Map.class,
                request().cookie(PROFILE_COOKIE));
        if(profileList == null) profileList = new ArrayList<Map>();
        Map<String, Object> profileInfo = (profileList
                .isEmpty()) ? new HashMap<>() : profileList.get(0);
        profileInfo.put("nickname", formData.getData().get("nickname")
                .toString());
        profileList.clear();
        profileList.add(profileInfo);
        Logger.debug(profileInfo.toString());
        response().setCookie(PROFILE_COOKIE,
                MAPPER.writeValueAsString(profileList));
        return redirect("/app/profile");
    }
}