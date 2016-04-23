package controllers;

import play.Logger;
import play.data.DynamicForm;
import play.data.Form;
import play.mvc.*;
import models.*;

import java.sql.SQLException;
import java.util.ArrayList;

public class SignUp extends Controller{

    public static Result index() {
        return ok(views.html.signup.render());
    }
    public static Result Submit() throws SQLException
    {
//      DynamicForm formData = Form.form().bindFromRequest();
      DynamicForm.Dynamic formData = Form.form().bindFromRequest().get();
      Logger.debug("hello this is debugging" + formData.getData().toString());
      Logger.info("Hello from the otter slide");
      System.out.println("Hello from the otter sliiiiiiide.");
      return redirect("/app"); 
      
    }

}