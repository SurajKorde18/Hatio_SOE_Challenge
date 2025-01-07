package com.example.currencyConverter.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Map;

@FeignClient(name = "currency-layer-api", url = "https://api.currencylayer.com/")
public interface CurrencyApiClient {
	
    @GetMapping("/live")
    Map<String, Object> getLiveRates(@RequestParam(name = "access_key") String accessKey,
                                     @RequestParam(name = "currencies", required = false) String currencies,
                                     @RequestParam(name = "source", required = false) String source);
    
    @GetMapping("/convert")
    Map<String, Object> convertCurrency(@RequestParam(name = "access_key") String accessKey,
                                         @RequestParam("from") String from,
                                         @RequestParam("to") String to,
                                         @RequestParam("amount") double amount);
}
