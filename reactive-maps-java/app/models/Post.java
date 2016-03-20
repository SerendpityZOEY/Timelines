package models;

<<<<<<< HEAD
public class Post
{

    public static String getPost()
=======

import java.util.HashMap;
import java.util.ArrayList;

public class Post
{
    public String author;
    public String text;

    public Post()
    {
        author = retrieveAuthor();
        text = retrieveText();
    }

    private String retrieveAuthor()
    {
        return "Sample Author";
    }
    private String retrieveText()
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
}