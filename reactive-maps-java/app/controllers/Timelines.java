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
        ArrayList<Post> posts = new ArrayList<Post>();
        Post p = new Post();
        posts.add(p);
        posts.add(p);
        posts.add(p);

        /*
//        return ok(views.html.index.render());
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
*/
        return ok(views.html.index.render(posts));
    }


}