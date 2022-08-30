package com.rec.entity;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document("slips_premium")
public class SlipsPremium {
    @Id
    private ObjectId id;
    @Field("confirmation_status")
    private String confirmationStatus;
    @Field("published_date")
    private String publishedDate;
    private String reference;
    @Field("validation_status")
    private String validationStatus;
}

