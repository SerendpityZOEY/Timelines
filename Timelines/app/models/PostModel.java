package models;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import play.db.ebean.*;
import controllers.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import controllers.Post;

@Entity
@Table(name = "post")
@JsonIgnoreProperties
public class PostModel extends Model
{
    private static final long serialVersionUID = 1L;

    @ManyToOne
    private String author;
    private String text;

    @JsonProperty("author")
    public void setAuthor(String author)
    {
        this.author = author;
    }

    @JsonProperty("message-text")
    public void setText(String text)
    {
        this.text = text;
    }

    @JsonProperty("author")
    public String getAuthor() throws SQLException
    {
        return this.author;
    }

    @JsonProperty("message-text")
    public String getText() throws SQLException
    {
        return this.text;

        // return "This is a sample post.";
        // JavaApplicationDatabase db = new JavaApplicationDatabase();
        // Connection cxn = db.getCxn();
        //
        // Statement s = cxn.createStatement();
        // s.execute("select content from post");
        // ResultSet r = s.getResultSet();
        // boolean row = r.next();
        // String results = r.getString("content");
        // System.out.println(results.toString());
        // return results;

    }

    public PostModel() throws SQLException
    {
        this.author = getAuthor();
        this.text = getText();
    }

}