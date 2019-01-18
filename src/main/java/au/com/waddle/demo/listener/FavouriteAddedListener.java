package au.com.waddle.demo.listener;

import au.com.waddle.demo.FavouriteAddedEvent;
import au.com.waddle.demo.repository.FavouriteStatsRepository;
import au.com.waddle.demo.second.FavouriteStats;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.Iterator;

/**
 * Created by yawly on 17/1/19.
 */
@Component
public class FavouriteAddedListener implements ApplicationListener<FavouriteAddedEvent> {
    private Logger logger = LoggerFactory.getLogger(FavouriteAddedListener.class);

    @Autowired
    FavouriteStatsRepository repository;

    @Override
    public void onApplicationEvent(FavouriteAddedEvent applicationEvent) {
        Iterator<FavouriteStats> iterator = repository.findAll().iterator();

        // Tracking all favourite events in a single counter
        if(iterator.hasNext()) {
            FavouriteStats stats = iterator.next();
            stats.increment();
            repository.save(stats);
            logger.debug(stats.toString());

        } else {
            FavouriteStats stats = new FavouriteStats();
            stats.increment();
            repository.save(stats);
            logger.debug(stats.toString());
        }

        logger.debug("Incremented favourite counter");
    }

}
