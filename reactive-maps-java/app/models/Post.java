package models;

import java.util.ArrayList;

public class Post
{
    public String author;
    public String text;

    public String getAuthor(){
        return "Jane Doe";
    }

    public String getText(){
        return "This is a sample post.";
    }

    public Post(String author, String text){
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