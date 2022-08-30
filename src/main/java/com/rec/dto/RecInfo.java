package com.rec.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class RecInfo {
    private String references;
    private String country;
    private String cedants;
    private String validationStatus;
    private String confirmationStatus;
    private String publicationDate;
    private String branch;
    private BigDecimal calculatedREC;
}
