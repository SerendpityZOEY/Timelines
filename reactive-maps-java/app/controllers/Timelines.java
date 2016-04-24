package controllers;

import play.Logger;
import play.data.DynamicForm;
import play.data.Form;
import play.mvc.*;
import models.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class Timelines extends Controller {

    /**
     * The index page.
     * @throws SQLException
     * @throws IOException 
     * @throws JsonMappingException 
     * @throws JsonParseException 
     */
    public static Result index() throws SQLException, JsonParseException, JsonMappingException, IOException
    {
//        ArrayList<PostModel> posts = new ArrayList<PostModel>();
//        PostModel p = new PostModel();
//        posts.add(p);
//        posts.add(p);
//        posts.add(p);
        
        ArrayList<PostModel> posts = (ArrayList<PostModel>) Post.cookieToList(
                "Posts", PostModel.class);

        return ok(views.html.index.render(posts));
    }

    public static Result Submit() throws SQLException
    {
        ArrayList<PostModel> posts = new ArrayList<PostModel>();
        //DynamicForm formData = Form.form().bindFromRequest();
        DynamicForm.Dynamic formData = Form.form().bindFromRequest().get();
        Logger.info("hello this is debugging" + formData.getData().toString());
        Logger.info("Heeeeeeeeeeeeey");
        /*
        Logger.debug("hello this is debugging" + formData.getData().toString());
        Logger.info("Hello from the otter slide");
        System.out.println("Hello from the otter sliiiiiiide.");
        //return redirect(controllers.Timelines.index().toString());
        JavaApplicationDatabase db = new JavaApplicationDatabase();

        Connection conn = db.getCxn();

        Statement stmt = conn.createStatement();


        //stmt.executeUpdate("create table userInfo (id int, name CHAR(15) );");

        stmt.executeUpdate("INSERT INTO user(id, userName, firstName, lastName, email)VALUES(12, '123456789', '123456789', '123456789', '123456789')");

        ResultSet rs = stmt.executeQuery("SELECT * FROM user");

        boolean row = rs.next();
        String results = rs.getString("userName");
        System.out.println(">>>>>>>>>>>"+results.toString());

        rs.close();
        stmt.close();
        conn.close();
*/
        return redirect("/app");
    }

}