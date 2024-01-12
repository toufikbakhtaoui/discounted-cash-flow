package com.solyador.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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
            var uri = "https://www.alphavantage.co/query?function=CASH_FLOW&symbol=" + symbol + "&apikey=" + API_KEY;
            var response = restTemplate.getForObject(uri, Object.class);
            log.debug("Cash Flow Data: " + response);

        } catch (Exception e) {
            log.error("error while trying to get cash flow");
        }
    }
}
