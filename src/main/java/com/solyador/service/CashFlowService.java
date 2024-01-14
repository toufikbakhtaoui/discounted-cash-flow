package com.solyador.service;

import com.solyador.model.CashFlowDataResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class CashFlowService {

    private static final String API_KEY = "ZG4AL4Q0N9XBO";
    private static final String ALPHA_API_URL = "https://www.alphavantage.co/query?function=CASH_FLOW";
    private final RestTemplate restTemplate;

    public CashFlowService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public CashFlowDataResponse getCashFlow(String symbol) {
        try {
            var uri = ALPHA_API_URL + "&symbol=" + symbol + "&apikey=" + API_KEY;
            return restTemplate.getForObject(uri, CashFlowDataResponse.class);

        } catch (Exception e) {
            log.error("error while trying to get cash flow");
            return null;
        }
    }
}
