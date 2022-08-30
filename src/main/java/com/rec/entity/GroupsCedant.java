package com.rec.entity;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("groups_cedants")
public class GroupsCedant {
    @Id
    private ObjectId id;
    private String name;
}
