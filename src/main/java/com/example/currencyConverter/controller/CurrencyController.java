package com.example.currencyConverter.controller;

import com.example.currencyConverter.dto.ConversionRequest;
import com.example.currencyConverter.dto.ConversionResponse;
import com.example.currencyConverter.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class CurrencyController {
    @Autowired
    private CurrencyService service;

    //to get live rates
    @GetMapping("/rates")
    public Map<String, Object> getLiveRates(@RequestParam(required = false) String source,
                                            @RequestParam(required = false) String currencies) {
        return service.fetchLiveRates(source, currencies);
    }
    
    
   // to convert currency rates
    @PostMapping("/convert")
    public ConversionResponse convert(@RequestBody ConversionRequest request) {
        return service.convert(request);
    }
}
