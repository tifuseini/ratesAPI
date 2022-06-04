package com.example.rates.domain;

import lombok.Data;

@Data
public class CurrencyExchange {

    public static final String BASE_CODE = "USD";

    private String base;

    private String date;

    private Rate[] rates;

}
