package controllers;

import play.mvc.*;
import models.*;

public class Profile extends Controller{

    public static Result user_profile(){
        return ok(views.html.profile.render("Hi"));
    }
}