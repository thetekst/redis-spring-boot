package ru.tkachenko.app.producer;

import lombok.extern.log4j.Log4j2;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.tkachenko.app.model.Event;
import ru.tkachenko.app.model.EventParam;
import ru.tkachenko.app.model.enums.CurrencyEnum;
import ru.tkachenko.app.service.RedisService;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

/**
 * Created by Dmitry Tkachenko on 23.04.18
 */
@Component
@Log4j2
public class Producer {

    private final RedisService redisService;

    public Producer(final RedisService redisService) {
        this.redisService = redisService;
    }

    @Scheduled(fixedDelay = 10000, initialDelay = 10000)
    public void send() {
        log.info("====================Sending message...====================");
        final EventParam eventParam = new EventParam("test.rp@mail.ru", LocalDateTime.now(),
                "8a905ae3d8c39dd5fbe26e16e6a05048", new BigDecimal("100.00"), CurrencyEnum.RUB, "sd");
        final Event event = new Event("GZ", "123456", "PAYMENT", eventParam);
        redisService.setValue(event.getSystem(), event, 4, TimeUnit.SECONDS);
    }
}
