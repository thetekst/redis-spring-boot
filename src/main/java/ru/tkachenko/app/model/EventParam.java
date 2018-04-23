package ru.tkachenko.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;
import ru.tkachenko.app.model.enums.CurrencyEnum;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Created by Dmitry Tkachenko on 23.04.18
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@RedisHash("EventParam")
public class EventParam implements Serializable {

    private String email;

    private LocalDateTime expiryDate;

    private String hashpan;

    private BigDecimal amount;

    private CurrencyEnum currency;

    private String mcc;
}
