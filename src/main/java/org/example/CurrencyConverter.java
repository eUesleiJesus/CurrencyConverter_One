import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class CurrencyConverter {

    private static String fromCurrency;
    private static String toCurrency;

    private static final String API_KEY = "71ef133c08aae15f995c85ef";
    private static final String API_URL = "https://api.exchangerate-api.com/v6/latest/";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double amount = getConversionDetails(scanner);
        try {
            double exchangeRate = getExchangeRate(fromCurrency, toCurrency);
            double convertedAmount = amount * exchangeRate;
            System.out.println(amount + " " + fromCurrency + " is equal to " + convertedAmount + " " + toCurrency);
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public static double getExchangeRate(String fromCurrency, String toCurrency) throws IOException {
        String url = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/" + fromCurrency;
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");

        int responseCode = con.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            StringBuilder response = new StringBuilder();
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            Gson gson = new Gson();
            JsonObject jsonObject = gson.fromJson(response.toString(), JsonObject.class);
            JsonObject rates = jsonObject.getAsJsonObject("conversion_rates");

            if (rates.has(toCurrency)) {
                return rates.get(toCurrency).getAsDouble();
            } else {
                throw new IOException("Could not find exchange rate for " + toCurrency);
            }
        } else {
            throw new IOException("API request failed with code: " + responseCode);
        }
    }

    private static double getConversionDetails(Scanner scanner) {
        System.out.print("Enter the amount: ");
        double amount = scanner.nextDouble();

        System.out.print("Enter the source currency (e.g., USD): ");
        fromCurrency = scanner.next().toUpperCase();

        System.out.print("Enter the target currency (e.g., BRL): ");
        toCurrency = scanner.next().toUpperCase();

        return amount;
    }
}