package models;

import java.io.IOException;
import java.util.List;

import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import controllers.Post;
import play.Logger;
import play.db.ebean.*;
import static utils.CookieUtils.*;

@JsonIgnoreProperties
public class UserInfo extends Model
{
    private static final long serialVersionUID = 1L;
    @Id
    private String username;
    private String nickname;
    private String email;
    private String text;
    private List<PostModel> posts;
    private static final String NICKNAME_DEFAULT = "Zoeymeister";

    @JsonProperty("nickname")
    public String getNickname()
    {
        if (nickname == null)
            try
            {
                List<UserInfo> profileInfo = cookieToList(UserInfo.class,
                        Post.request().cookie(PROFILE_COOKIE));
                this.nickname = (profileInfo == null || profileInfo.isEmpty()) ? NICKNAME_DEFAULT
                        : profileInfo.get(0).getNickname();
                Logger.debug(profileInfo.toString());
            } catch (IOException e)
            {
                Logger.warn("Unable to read cookie; using default");
            }

        return (nickname == null) ? NICKNAME_DEFAULT : nickname;
    }

    public List<PostModel> getPosts()
    {
        if (posts == null)
            try
            {
                posts = cookieToList(PostModel.class,
                        Post.request().cookie(COOKIE_NAME));
            } catch (IOException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        return posts;
    }

    public void setPosts(List<PostModel> posts)
    {
        this.posts = posts;
    }

    @JsonProperty("nickname")
    public void setNickname(String nickname)
    {
        this.nickname = nickname;
    }

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