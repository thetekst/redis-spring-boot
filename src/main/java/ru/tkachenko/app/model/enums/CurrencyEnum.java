package ru.tkachenko.app.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Arrays;

/**
 * Created by Dmitry Tkachenko on 23.04.18
 */
@Getter
@AllArgsConstructor
@ToString
public enum CurrencyEnum {

    EUR("978"), RUB("643"), USD("840");

    private final String currency;

    public static CurrencyEnum getType(final String code) {
        return Arrays.stream(values()).filter(e -> code.equals(e.currency)).findFirst().orElse(null);
    }
}
