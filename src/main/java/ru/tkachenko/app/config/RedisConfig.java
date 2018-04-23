package ru.tkachenko.app.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import ru.tkachenko.app.model.Event;

/**
 * Created by Dmitry Tkachenko on 23.04.18
 */
@Configuration
public class RedisConfig {

    private final ObjectMapper mapper;

    public RedisConfig(final ObjectMapper mapper) {
        this.mapper = mapper;
    }

    @Bean
    JedisConnectionFactory jedisConnectionFactory() {
        return new JedisConnectionFactory();
    }

    @Bean
    RedisTemplate<String, Event> redisTemplate() {
        final Jackson2JsonRedisSerializer<Event> serializer = new Jackson2JsonRedisSerializer<>(Event.class);
        serializer.setObjectMapper(mapper);

        final RedisTemplate<String, Event> template = new RedisTemplate<>();
        template.setConnectionFactory(jedisConnectionFactory());
        template.setValueSerializer(serializer);

        return template;
    }
}
