package models;

import java.util.ArrayList;
import java.util.*;
import javax.persistence.*;

import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;


public class Post extends Model
{
    public String author;
    public String text;

    public String getAuthor()
    {

        // Have to manually close this at some point
//        Connection connection = DB.getConnection();

        return "Jane Doe";
    }

    public String getText(){
        return "This is a sample post.";
    }

    public Post(){
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