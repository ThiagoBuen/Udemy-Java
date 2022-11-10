package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Post {

    private Date moment;
    private String title;
    private String content;
    private Integer likes;
    private List<Comment> comments = new ArrayList<>();

    public Post() {

    };

    public Post(Date moment, String title, String content, Integer likes) {
        this.moment = moment;
        this.title  = title;
        this.content = content;
        this.likes = likes;
    }

    public void addComment (Comment comment) {
        this.comments.add(comment);
    }

    public void removeComment (Comment comment) {
        this.comments.remove(comment);
    }
}
