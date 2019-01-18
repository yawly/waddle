package au.com.waddle.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Post {
    @GeneratedValue
    @Id
    private long id;

    private int score;
    private String title;
    private String url;

    protected Post() {}

    public Post(int score, String title, String url) {
        this.score = score;
        this.title = title;
        this.url = url;
    }

    public int getScore() {
        return score;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public Long getId() {
        return id;
    }

}
