package controllers;

import play.Logger;
import play.data.DynamicForm;
import play.data.Form;
import play.mvc.*;
import models.*;

import java.sql.SQLException;
import java.util.ArrayList;
import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;
import java.sql.*;

public class SignUp extends Controller{

    public static Result index() {
        //Form<UserInfo> formData = Form.form();
        //Form<StudentFormData> formData = Form.form(StudentFormData.class).fill(studentData);

        return ok(views.html.signup.render());
    }

//    public static Result Submit() throws SQLException
//    {
////      DynamicForm formData = Form.form().bindFromRequest();
//      DynamicForm.Dynamic formData = Form.form().bindFromRequest().get();
//      Logger.debug("hello this is debugging" + formData.getData().toString());
//      Logger.info("Hello from the otter slide");
//      System.out.println("Hello from the otter sliiiiiiide.");
//      return redirect("/app"); 
//      
//    }


    public static Result Submit() throws SQLException
    {
        //DynamicForm formData = Form.form().bindFromRequest();
        DynamicForm.Dynamic formData = Form.form().bindFromRequest().get();
        Logger.debug("hello this is debugging" + formData.getData().toString());
        Logger.info("Hello from the otter slide");
        System.out.println("Hello from the otter sliiiiiiide.");
        //return redirect(controllers.Timelines.index().toString());
        /*
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