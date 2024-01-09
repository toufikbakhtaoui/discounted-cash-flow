package com.solyador.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AnnualReport {
    private String fiscalDateEnding;
    private String operatingCashFlow;
    private String paymentsForOperatingActivities;
}
