package ru.tkachenko.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

/**
 * Created by Dmitry Tkachenko on 23.04.18
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("Event")
public class Event implements Serializable {

    private String system;

    private String password;

    private String eventType;

    private EventParam params;
}
