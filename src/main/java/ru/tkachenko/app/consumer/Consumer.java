package ru.tkachenko.app.consumer;

import lombok.extern.log4j.Log4j2;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.tkachenko.app.model.Event;
import ru.tkachenko.app.service.RedisService;

/**
 * Created by Dmitry Tkachenko on 23.04.18
 */
@Component
@Log4j2
public class Consumer {

    private final RedisService redisService;

    public Consumer(final RedisService redisService) {
        this.redisService = redisService;
    }

    @Scheduled(fixedDelay = 3000)
    public void recievedMessage() {
        Event fromRedis = redisService.getAndRemoveValue("GZ");
        log.info("====================Read Event from Redis: {}====================", fromRedis);
    }
}
