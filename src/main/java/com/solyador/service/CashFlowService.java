package com.solyador.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
@Slf4j
public class CashFlowService {

    private static final String API_KEY = "ZG4AL4Q0N9XBO";
    private final RestTemplate restTemplate;

    public CashFlowService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void getCashFlow(String symbol) {
        try {
            var uri = "https://www.alphavantage.co/query?function=CASH_FLOW&symbol=Œ" + symbol + "&apikey=" + API_KEY;
            var response = restTemplate.getForObject(uri, Object.class);
            /*URL url = new URL();
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuilder response = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();
            connection.disconnect();
*/
            log.debug("Cash Flow Data:\n" + response);

        } catch (Exception e) {
            log.error("error while trying to get cash flow");
        }
    }
}
