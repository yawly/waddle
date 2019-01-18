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
        logger.debug("Handling FavouriteAddedEvent");

        Iterator<FavouriteStats> iterator = repository.findAll().iterator();

        FavouriteStats stats = iterator.hasNext() ? iterator.next() : new FavouriteStats();

        stats.increment();
        repository.save(stats);

        logger.info(stats.toString());
    }

}
