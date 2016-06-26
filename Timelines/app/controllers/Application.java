package controllers;

import play.*;
import play.mvc.*;
import play.Logger;
import play.data.Form;
import play.data.DynamicForm;

import models.*;
import views.html.*;

public class Application extends Controller {

    // -- Authentication

    public static class Login {

        public String email_address;
        public String password;

        public String validate() {
            if(Accounts.authenticate(email_address, password) == null) {
                return "Invalid user or password";
            }
            return null;
        }

    }

    /**
     * Login page.
     */
    public static Result login() {
        return ok(
                //login.render(form(Login.class))
                views.html.signup.render()
        );
    }

    /**
     * Handle login form submission.
     */

    public static Result authenticate() {
        //Form<Login> loginForm = form(Login.class).bindFromRequest();
        DynamicForm.Dynamic formData = Form.form().bindFromRequest().get();
        Logger.info("hello this is debugging" + formData.getData().toString());
        return redirect("/app/profile");
        /*
        if(loginForm.hasErrors()) {
            return badRequest(login.render(loginForm));
        } else {
            session("user_name", loginForm.get().user_name);
            return redirect(
                    "/app"
            );
        }
        */
    }

    /**
     * Logout and clean the session.
     */

    public static Result logout() {
        session().clear();
        flash("success", "You've been logged out");
        return redirect(
                "/app"
        );
    }
}

