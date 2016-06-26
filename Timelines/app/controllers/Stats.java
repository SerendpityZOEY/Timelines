package controllers;

import play.mvc.*;
import models.*;

public class Stats extends Controller{

    public static Result index() {
        return ok(views.html.stats.render());
    }
}