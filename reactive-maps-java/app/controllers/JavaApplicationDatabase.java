package controllers;

//import javax.inject.Inject;
import java.sql.Connection;

import play.mvc.*;
import play.db.*;

class JavaApplicationDatabase extends Controller {
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