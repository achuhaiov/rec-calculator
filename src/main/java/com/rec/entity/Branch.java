package com.rec.entity;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("branches")
public class Branch {
    @Id
    private ObjectId id;
    private String name;
    private String type;
}
