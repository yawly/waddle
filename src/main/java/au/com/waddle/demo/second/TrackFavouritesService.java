package au.com.waddle.demo.second;

import au.com.waddle.demo.FavouriteAddedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionalEventListener;

import javax.transaction.Transactional;

@Service
public class TrackFavouritesService {

    @Autowired
    private ApplicationEventPublisher publisher;

    private Logger logger = LoggerFactory.getLogger(TrackFavouritesService.class);

    @Async
    @TransactionalEventListener
    @Transactional
    public void favouriteAdded(FavouriteAddedEvent event) {
        System.out.println("Favourite added " + event.getPostId());

        // Assuming a favourite entity is saved here. But the test is to handle the published event below in another
        // module.

        // Synchronous call
        publisher.publishEvent(event);
    }
}
