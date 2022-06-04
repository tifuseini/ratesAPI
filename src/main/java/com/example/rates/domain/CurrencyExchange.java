package com.example.rates.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class CurrencyExchange {

    public static final String BASE_CODE = "USD";

    private String base;

    private String date;

    private Rate[] rates;

}
