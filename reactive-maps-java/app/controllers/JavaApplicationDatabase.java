package controllers;

//import javax.inject.Inject;

import play.db.*;
import play.mvc.*;

import java.sql.Connection;

public class JavaApplicationDatabase extends Controller {
  Connection cxn;

  public JavaApplicationDatabase() {
    this.cxn = DB.getConnection();
  }

  public Connection getCxn() {
    return cxn;
  }

  public void setCxn(Connection cxn) {
    this.cxn = cxn;
  }

}