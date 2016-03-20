package controllers;


import play.mvc.*;

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

        String[] anArray = {
                models.Post.getPost()
        };
        return ok(views.html.index_jnet.render(anArray));

    }


}