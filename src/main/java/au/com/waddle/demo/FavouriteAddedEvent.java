package au.com.waddle.demo;


import org.springframework.context.ApplicationEvent;

public class FavouriteAddedEvent extends ApplicationEvent {
    private String postId;

    public FavouriteAddedEvent(Object source, String postId) {
        super(source);
        this.postId = postId;
    }

    public String getPostId() {
        return postId;
    }
}
