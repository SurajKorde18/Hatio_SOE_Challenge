# Hatio_SOE_Challenge
# Currency Converter API Integration

## Objective
A Spring Boot application that integrates with a public API to provide real-time currency conversion functionality.

## Features
1. Fetch exchange rates for a given base currency.
2. Convert an amount from one currency to another.
3. Error handling for invalid currency codes and unavailable external APIs.

## Endpoints
1. **GET /api/rates?base=USD**
   - Fetch exchange rates for the given base currency. Default is USD.

2. **POST /api/convert**
   - Convert an amount from one currency to another.
   - Request Body:
     ```json
     {
       "from": "USD",
       "to": "EUR",
       "amount": 100
     }
     ```
   - Response:
     ```json
     {
       "from": "USD",
       "to": "EUR",
       "amount": 100,
       "convertedAmount": 94.5
     }
     ```

## Running the Application
1. Clone the repository:
   ```bash
   git clone <repository-url>
   cd currency-converter
