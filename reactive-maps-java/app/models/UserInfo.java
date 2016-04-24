package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import play.db.ebean.*;

@JsonIgnoreProperties
public class UserInfo extends Model
{
    private static final long serialVersionUID = 1L;
    private String username;
    private String email;
    private String text;

    @JsonProperty("author")
    public String getUsername()
    {
        return this.username;
    }

    public String getEmail()
    {
        return this.email;
    }

    public UserInfo()
    {
        this.username = getUsername();
        this.email = getEmail();
    }

    @JsonProperty("author")
    public void setUsername(String username)
    {
        this.username = username;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }
    
    @JsonProperty("message-text")
    public String getText()
    {
        return text;
    }
    
    @JsonProperty("message-text")
    public void setText(String text)
    {
        this.text = text;
    }

}