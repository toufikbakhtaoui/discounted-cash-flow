package com.solyador.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AnnualReport {
    private String fiscalDateEnding;
    private String operatingCashflow;
    private String paymentsForOperatingActivities;
    private String proceedsFromOperatingActivities;
    private String changeInOperatingLiabilities;
    private String capitalExpenditures;
}
