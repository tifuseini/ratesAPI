package com.example.rates.controller;

import com.example.rates.domain.CurrencyConversion;
import com.example.rates.domain.CurrencyExchange;
import com.example.rates.service.CurrencyConversionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/currency")
public class CurrencyController {

    private static final Logger log = LoggerFactory.getLogger(CurrencyController.class);

    @Autowired
    CurrencyConversionService conversionService;

    @RequestMapping("/lastest")
    public ResponseEntity<CurrencyExchange> getLatest(@RequestParam(name="base",defaultValue=CurrencyExchange.BASE_CODE)String base) throws Exception{
        log.info("Number 1");
        return new ResponseEntity<CurrencyExchange>(new CurrencyExchange(base,
                new SimpleDateFormat("yyyy-MM-dd").format(new Date()),
                conversionService.calculateByCode(base,new Date())),HttpStatus.OK);
    }

    @RequestMapping("/{date}")
    public ResponseEntity<CurrencyExchange> getByDate(@PathVariable("date") @DateTimeFormat(pattern="yyyy-MM-dd") Date date, @RequestParam(name="base",defaultValue=CurrencyExchange.BASE_CODE)String base) throws Exception{
        return new ResponseEntity<CurrencyExchange>(new CurrencyExchange(base,
                new SimpleDateFormat("yyyy-MM-dd").format(date),
                conversionService.calculateByCode(base,date)),HttpStatus.OK);
    }


}
