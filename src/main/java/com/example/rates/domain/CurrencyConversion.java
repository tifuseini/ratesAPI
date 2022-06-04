package com.example.rates.domain;

import lombok.Data;

@Data
public class CurrencyConversion {
    
    private String base;

    private String code;

    private float amount;

    private float total;

}
