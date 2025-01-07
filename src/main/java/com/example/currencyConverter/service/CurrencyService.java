package com.example.currencyConverter.service;

import org.springframework.stereotype.Service;
import com.example.currencyConverter.dto.ConversionRequest;
import com.example.currencyConverter.dto.ConversionResponse;
import com.example.currencyConverter.exception.CurrencyConversionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.Map;

@Service
public class CurrencyService {

	 @Autowired
	private CurrencyApiClient apiClient;

	@Value("${currency.api.access-key}")
	private String accessKey;

	public CurrencyService(CurrencyApiClient apiClient) {
		this.apiClient = apiClient;
	}

	public Map<String, Object> fetchLiveRates(String source, String currencies) {
		return apiClient.getLiveRates(accessKey, currencies, source);
	}

	public ConversionResponse convert(ConversionRequest request) {
		try {
			Map<String, Object> response = apiClient.convertCurrency(accessKey, request.getFrom(), request.getTo(),
					request.getAmount());
			if (response.get("success").equals(Boolean.FALSE)) {
				throw new CurrencyConversionException("Conversion failed: " + response.get("error"));
			}

			double convertedAmount = Double.parseDouble(response.get("result").toString());

			return new ConversionResponse(request.getFrom(), request.getTo(), request.getAmount(), convertedAmount);
		} catch (Exception e) {
			throw new CurrencyConversionException("Failed to convert currency: " + e.getMessage());
		}
	}

}
