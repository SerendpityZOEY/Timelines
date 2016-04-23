package controllers;

import play.Logger;
import play.data.DynamicForm;
import play.data.Form;
import play.mvc.*;
import models.*;

import java.sql.SQLException;
import java.util.ArrayList;

public class Post extends Controller
{
    public static Result Submit() throws SQLException
    {
        // DynamicForm formData = Form.form().bindFromRequest();
        DynamicForm.Dynamic formData = Form.form().bindFromRequest().get();
        Logger.debug("Post post form data: " + formData.getData().toString());
        return redirect("/app");
    }

}
