package au.com.waddle.demo;


import org.springframework.context.ApplicationEvent;

/*
 * Converted this class to an ApplicationEvent based on the requirement to also publish these events.
 */
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
