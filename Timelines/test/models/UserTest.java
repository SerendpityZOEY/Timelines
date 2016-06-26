package models;
import org.junit.Test;

import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.running;

import static org.fest.assertions.Assertions.assertThat;

import models.User;
  
  

  public class UserTest {

      @Test
      public void create() {
          running(fakeApplication(), new Runnable() {
              @Override
              public void run() {
//                  User user = new User();
//                  user.setName("TestNameFromInput");
//                  user.save();
//                  assertThat(user.id).isNotNull();
              }
          });
      }

  }

