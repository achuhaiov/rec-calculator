package com.rec.entity;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("regoin")
public class Region {
    @Id
    private ObjectId id;
    private String code;
    private String name;
}
