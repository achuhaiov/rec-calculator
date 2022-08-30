package com.rec.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigDecimal;

@Data
@Document("case_not_life_premium")
public class CaseNotLifePremium {
    @Id
    private String id;
    private String branch;
    @Field("cedants_id")
    private String cedantsId;
    @Field("slipes_prime_id")
    private String slipesPrimeId;
    @Field("sum_premium_ht")
    private BigDecimal sumPremiumHt;
}
