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
        logger.debug("Favourited Post postId=" + event.getPostId());

        // Assuming a favourite entity is saved here. But the test is to handle the published event below in another
        // module.

        // According to the documentation this is a synchronous call. Could be an issue if multiple threads are running
        // and publishing this event.
        publisher.publishEvent(event);
    }
}
