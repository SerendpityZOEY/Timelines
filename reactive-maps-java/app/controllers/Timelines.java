package controllers;


import play.mvc.*;
import models.*;

import java.sql.SQLException;
import java.util.ArrayList;

public class Timelines extends Controller {

    /**
     * The index page.
     * @throws SQLException
     */
    public static Result index() throws SQLException
    {
        ArrayList<PostModel> posts = new ArrayList<PostModel>();
        PostModel p = new PostModel();
        posts.add(p);
        posts.add(p);
        posts.add(p);

        return ok(views.html.index.render(posts));
    }

    public static Result postIndex() throws SQLException
    {
        ArrayList<Post> posts = new ArrayList<Post>();

        System.out.println("aaaaaaaaaaaaaaaa");
        return ok(views.html.index.render(posts));
    }

}