package controllers;

import play.mvc.*;
import models.*;
import java.util.ArrayList;

public class Profile extends Controller{

    public static Result user_profile(){

        ArrayList<UserInfo> userinfo = new ArrayList<UserInfo>();
        UserInfo info = new UserInfo();
        userinfo.add(info);
        userinfo.add(info);
        userinfo.add(info);

        return ok(views.html.profile.render(userinfo));
    }
}