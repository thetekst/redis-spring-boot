package ru.tkachenko.app.service;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import ru.tkachenko.app.model.Event;

import java.util.concurrent.TimeUnit;

/**
 * Created by Dmitry Tkachenko on 23.04.18
 */
@Service
public class RedisService {

    private final RedisTemplate<String, Event> template;

    public RedisService(final RedisTemplate<String, Event> template) {
        this.template = template;
    }

    public Event getValue(final String key) {
        return template.opsForValue().get(key);
    }

    public Event getAndRemoveValue(final String key) {
        final Event event = template.opsForValue().get(key);
        template.delete(key);
        return event;
    }

    public void setValue(final String key, final Event value) {
        template.opsForValue().set(key, value);
    }

    public void setValue(final String key, final Event value, final long timeout, final TimeUnit unit) {
        template.opsForValue().set(key, value, timeout, unit);
    }
}
