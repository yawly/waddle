package au.com.waddle.demo.controller;

import au.com.waddle.demo.FavouriteAddedEvent;
import au.com.waddle.demo.Post;
import au.com.waddle.demo.repository.PostRepository;
import au.com.waddle.demo.second.TrackFavouritesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by yawly on 17/1/19.
 */
@Controller
public class PostsController {

    private Logger logger = LoggerFactory.getLogger(PostsController.class);

    @Autowired
    private PostRepository repository;

    @Autowired
    private TrackFavouritesService trackFavouritesService;

    @GetMapping("/posts")
    @CrossOrigin(origins = "http://localhost:8081")
    @ResponseBody
    public Map<String, ?> getPosts() {

        ArrayList<Post> posts = new ArrayList<>();
        Map<String, Object> response = new HashMap<>();

        for (Post post : repository.findAll()) {
            posts.add(post);
        }

        response.put("items", posts);

        return response;
    }

    @PostMapping("/post/{postId}")
    @CrossOrigin(origins = "http://localhost:8081")
    @ResponseBody
    public Map<String, ?> markFavourite(@PathVariable(value="postId") String postId) {
        // Notes:
        // Assuming that there is no need to toggle favourites on or off
        // This would require an authenticated service (or a mechanism to pass an user identifier)
        // This particular feature would be testing the ability to write into the repository

        HashMap<String, Object> response = new HashMap<String, Object>();

        // Catch error and return an error response instead of the Spring Boot default message
        // Didn't want to create another object to abstract the 'this' part as this would require
        // another layer on top of the service provided.
        trackFavouritesService.favouriteAdded(new FavouriteAddedEvent(this, postId));

        response.put("status", true);

        return response;
    }

}