package controllers;


import play.mvc.*;
import models.*;
import java.util.ArrayList;

public class Timelines extends Controller {

    /**
     * The index page.
     */
    public static Result index()
    {
//        return ok(views.html.index_jnet.render());
//
//        int[] anArray = {
//                100, 200, 300,
//                400, 500, 600,
//                700, 800, 900, 1000
//        };
        Post p = new Post();
        ArrayList<Post> posts = p.getPosts();

//        String[] anArray = {
//                models.Post.getPost()
//        };

        return ok(views.html.index_jnet.render(posts));
    }


}