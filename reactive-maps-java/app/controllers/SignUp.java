package controllers;

import play.mvc.*;
import models.*;
import java.util.ArrayList;

public class SignUp extends Controller{

    public static Result index() {
        return ok(views.html.signup.render());
    }

}