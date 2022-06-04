package com.example.rates.controller;

import com.example.rates.domain.CurrencyConversion;
import com.example.rates.domain.CurrencyExchange;
import com.example.rates.service.CurrencyConversionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/currency")
public class CurrencyController {

    private static final Logger log = LoggerFactory.getLogger(CurrencyController.class);

    @Autowired
    CurrencyConversionService conversionService;

    @RequestMapping("/lastest")
    public ResponseEntity<CurrencyExchange>


}
