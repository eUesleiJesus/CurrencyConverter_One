# CurrencyConverter_One
 challenger

## Currency Converter

This Java program fetches real-time exchange rates from the exchangerate-api.com API and converts a given amount from one currency to another.

**Features:**

- Retrieves exchange rates using the exchangerate-api.com API.
- Handles user input for the amount, source currency, and target currency.
- Calculates and displays the converted amount.

**How to Use:**

1. **Obtain an API Key:** Sign up for a free account at [https://www.exchangerate-api.com/](https://www.exchangerate-api.com/) to get your API key.
2. **Replace Placeholder:** Replace `"71ef133c08aae15f995c85ef"` with your actual API key in the `API_KEY` constant.
3. **Compile and Run:** Compile and run the Java code.
4. **Enter Details:** The program will prompt you to enter:
    - The amount to convert.
    - The source currency code (e.g., USD, EUR, GBP).
    - The target currency code (e.g., JPY, CAD, CHF).
5. **View Result:** The program will display the converted amount.

**Dependencies:**

- Gson library for JSON parsing: Add the Gson dependency to your project.

**Example Usage:**

```
Enter the amount: 100
Enter the source currency (e.g., USD): EUR
Enter the target currency (e.g., BRL): USD
100.0 EUR is equal to 113.97 USD
```

**Notes:**

- Ensure that the currency codes you enter are valid.
- Exchange rates are subject to change, so the results may vary over time.
- Refer to the exchangerate-api.com documentation for more information about their API and usage guidelines.



Let me know if you have any questions or need further assistance!