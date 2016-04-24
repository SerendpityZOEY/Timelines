package controllers;

import play.mvc.*;
import models.*;

import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import controllers.Post;

public class Profile extends Controller
{

    public static Result user_profile() throws JsonParseException,
            JsonMappingException, IOException
    {

        // ArrayList<UserInfo> userinfo = new ArrayList<UserInfo>();
        // UserInfo info = new UserInfo();
        // userinfo.add(info);
        // userinfo.add(info);
        // userinfo.add(info);
        ArrayList<UserInfo> userinfo = (ArrayList<UserInfo>) Post.cookieToList(
                "Posts", UserInfo.class);

        return ok(views.html.profile.render(userinfo));
    }
}