package com.example.rates.controller;

import com.example.rates.domain.CurrencyConversion;
import com.example.rates.domain.CurrencyExchange;
import com.example.rates.domain.Rate;
import com.example.rates.service.CurrencyConversionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;


@RestController
@RequestMapping("/currency")
public class CurrencyController {

    private static final Logger log = LoggerFactory.getLogger(CurrencyController.class);

    @Autowired
    CurrencyConversionService conversionService;

    @GetMapping("/latest")
    public ResponseEntity<CurrencyExchange> getLatest(@RequestParam(name="base",defaultValue=CurrencyExchange.BASE_CODE)String base) throws Exception{
        log.info("Number 1");
        return new ResponseEntity<CurrencyExchange>(new CurrencyExchange(base,
                new SimpleDateFormat("yyyy-MM-dd").format(new Date()),
                conversionService.calculateByCode(base,new Date())),HttpStatus.OK);
    }

    @GetMapping("/{date}")
    public ResponseEntity<CurrencyExchange> getByDate(@PathVariable("date") @DateTimeFormat(pattern="yyyy-MM-dd") Date date, @RequestParam(name="base",defaultValue=CurrencyExchange.BASE_CODE)String base) throws Exception{
        log.info("Number 2");
        return new ResponseEntity<CurrencyExchange>(new CurrencyExchange(base,
                new SimpleDateFormat("yyyy-MM-dd").format(date),
                conversionService.calculateByCode(base,date)),HttpStatus.OK);
    }

    @GetMapping("/{amount}/{base}/to/{code}")
    public ResponseEntity<CurrencyConversion> conversion(@PathVariable("amount")Float amount,@PathVariable("base")String base,@PathVariable("code")String code) throws Exception{
        CurrencyConversion conversionResult = conversionService.convertFromTo(base, code, amount);
        log.info("Number 3");
        return new ResponseEntity<CurrencyConversion>(conversionResult,HttpStatus.OK);
    }

    @PostMapping(path="/new")
    public ResponseEntity<CurrencyExchange> addNewRates(@RequestBody CurrencyExchange currencyExchange) throws Exception{
        try{
            final Date date = new SimpleDateFormat("yyyy-MM-dd").parse(currencyExchange.getDate());
            final Rate[] rates = currencyExchange.getRates();
            conversionService.saveRates(rates,date);
        }catch(Exception ex){
            log.error(ex.getMessage());
            throw ex;
        }
        return new ResponseEntity<CurrencyExchange>(HttpStatus.CREATED);
    }


}
