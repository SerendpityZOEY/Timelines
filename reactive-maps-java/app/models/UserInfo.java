package models;

import java.util.ArrayList;

import play.db.ebean.*;
import play.data.validation.Constraints.*;

import javax.persistence.*;

import java.sql.Array;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserInfo extends Model
{
    public String username;
    public String email;

    public String getUsername(){
        return "Jane Doe";
    }

    public String getEmail(){
        return "test@gmail.com";
    }

    public UserInfo(){
        this.username = getUsername();
        this.email = getEmail();
    }

}