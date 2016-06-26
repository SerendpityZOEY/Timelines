package models;

import java.util.*;

import javax.persistence.*;

import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;
import controllers.*;

import java.sql.Array;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Entity 
@Table(name="post")
public class PostModel extends Model
{
    @ManyToOne
    User user;
    PostModel post;
    String content;
    public String author;
    public String text;

    public String getAuthor() throws SQLException
    {
     
        // Have to manually close this at some point
//        Connection connection = DB.getConnection();

        return "Jane Doe";
    }

    public String getText() throws SQLException{
//        return "This is a sample post.";
      JavaApplicationDatabase db = new JavaApplicationDatabase();
      Connection cxn = db.getCxn();
      
      Statement s = cxn.createStatement();
      s.execute("select content from post");
      ResultSet r = s.getResultSet();
      boolean row = r.next();
      String results = r.getString("content");
      System.out.println(results.toString());
      return results;
    }

    public PostModel() throws SQLException{
        this.author = getAuthor();
        this.text = getText();
    }
    /*
    public String author;
    public String text;

    public Post()
    {
        author = retrieveAuthor();
        text = retrieveText();
    }

    public String retrieveAuthor()
    {
        return "Sample Author";
    }
    public String retrieveText()
    {
        return "This is a sample post";
    }

    public static ArrayList<Post> getPosts()
    {
        ArrayList<Post> pl = new ArrayList<Post>();
        Post post = new Post();
        pl.add(post);
        pl.add(post);
        pl.add(post);
        return pl;
    }
    */
}