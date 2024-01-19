package com.solyador.service;

import com.solyador.config.ApplicationProperties;
import com.solyador.model.CashFlowDataResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
@RequiredArgsConstructor
public class CashFlowService {

    private final ApplicationProperties applicationProperties;
    private final RestTemplate restTemplate;

    public CashFlowDataResponse getCashFlow(String symbol) {
        try {
            var uri = applicationProperties.getAlphaUrl() + "/query?function=CASH_FLOW&symbol=" + symbol + "&apikey=" + applicationProperties.getApiKey();
            return restTemplate.getForObject(uri, CashFlowDataResponse.class);

        } catch (Exception e) {
            log.error("error while trying to get cash flow");
            return null;
        }
    }
}
