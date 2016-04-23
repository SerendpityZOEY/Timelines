package controllers;
import play.mvc.*;
import play.mvc.Http.RequestBody;
import models.*;
import views.*;
import views.html.testinput;

//import play.libs.ws.*;
import play.libs.F.Function;
import play.libs.F.Promise;

import java.util.ArrayList;

public class Application extends Controller {
  
  public static Result index() {
    RequestBody body = request().body();
    return ok("Got body: " + body);
  }
  
  public static void login(String userCode,String password){        
    User loginUser = null;
    if(loginUser == null){
//        flash.put("username",userCode);
//        flash.error("Invalid Credentials");
        index();
    }
    else{
//        Cache.set(session.getId(),loginUser,"20mn");
//        Home.Home();
        index();
    }
}
  
//  public static Result postIndex(){
//    WSRequestHolder holder = WS.url("http://example.com");
//    WSRequestHolder complexHolder = holder.setHeader("headerKey", "headerValue")
//        .setTimeout(1000)
//        .setQueryParameter("paramKey", "paramValue");
//    
//  }
  

}
