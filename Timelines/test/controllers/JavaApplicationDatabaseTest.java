package controllers;

import models.Task;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import play.test.FakeApplication;
import play.test.Helpers;

import com.avaje.ebean.Ebean;

public class JavaApplicationDatabaseTest {
  public static FakeApplication app;

  @BeforeClass
  public static void startApp() {
    app = Helpers.fakeApplication(Helpers.inMemoryDatabase());
    Helpers.start(app);
  }

  @Test
  public void testJavaApplicationDatabase() {
    Task fuck = new Task();
    fuck.id = 123L;
        // fuck.name = "idk";
        // fuck.save();
    // Ebean.save(fuck);
  }

  @AfterClass
  public static void stopApp() {
    Helpers.stop(app);
  }

}