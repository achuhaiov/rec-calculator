package com.rec.entity;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document("cedants")
public class Cedant {
    @Id
    private ObjectId id;
    @Field("countries_id")
    private String countriesId;
    private String name;
}
