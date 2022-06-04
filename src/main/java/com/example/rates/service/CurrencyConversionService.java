package com.example.rates.service;

import com.example.rates.annotation.ToUpper;
import com.example.rates.domain.CurrencyConversion;
import com.example.rates.domain.CurrencyExchange;
import com.example.rates.domain.Rate;
import com.example.rates.repo.RateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CurrencyConversionService {

    @Autowired
    RateRepository rateRepository;

    public CurrencyConversion convertFromTo(@ToUpper String base,@ToUpper String code,Float amount) throws Exception{

        Rate baseRate = new Rate(CurrencyExchange.BASE_CODE,1.0F,new Date());
        Rate codeRate = new Rate(CurrencyExchange.BASE_CODE,1.0F,new Date());


        return

    }


}
