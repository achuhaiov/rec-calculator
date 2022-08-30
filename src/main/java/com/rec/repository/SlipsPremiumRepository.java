package com.rec.repository;

import com.rec.entity.SlipsPremium;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class SlipsPremiumRepository {
    private final MongoTemplate mongoTemplate;

    public SlipsPremiumRepository(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public List<ObjectId> findIds(String confirmationStatus) {
        List<SlipsPremium> slipsPremiums;
        if (StringUtils.hasLength(confirmationStatus)) {
            Query query = new Query();
            query.addCriteria(Criteria.where("confirmation_status").is(confirmationStatus));
            slipsPremiums = mongoTemplate.find(query, SlipsPremium.class);
        } else {
            slipsPremiums = mongoTemplate.findAll(SlipsPremium.class);
        }

        return slipsPremiums.stream().map(SlipsPremium::getId).collect(Collectors.toList());
    }

    public SlipsPremium findById(String id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(id));
        return mongoTemplate.findOne(query, SlipsPremium.class);
    }

}
