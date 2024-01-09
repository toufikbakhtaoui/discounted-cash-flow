package com.solyador.controller;

import com.solyador.service.CashFlowService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = {"/api/v1/stocks"}, produces = APPLICATION_JSON_VALUE)
public class DisCaFloApiController {

    private final CashFlowService cashFlowService;

    public DisCaFloApiController(CashFlowService cashFlowService) {
        this.cashFlowService = cashFlowService;
    }

    @GetMapping("/{stockId}")
    public ResponseEntity<String> getStock(@PathVariable("stockId") String stockId) {
        cashFlowService.getCashFlow(stockId);
        return ResponseEntity.ok("sending stock's information here");
    }
}
