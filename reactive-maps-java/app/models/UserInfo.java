package models;

import java.util.ArrayList;

public class UserInfo
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