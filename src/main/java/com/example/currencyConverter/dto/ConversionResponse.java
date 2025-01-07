package com.example.currencyConverter.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ConversionResponse {

	private String from;
    private String to;
    private double amount;
    private double convertedAmount;
}
