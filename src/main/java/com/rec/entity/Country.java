package com.rec.entity;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("countries")
public class Country {
    @Id
    private ObjectId id;
    private String code;
    private String name;
}
