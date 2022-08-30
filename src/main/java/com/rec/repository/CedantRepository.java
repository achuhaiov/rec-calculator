package com.rec.repository;

import com.rec.entity.Cedant;
import com.rec.entity.Country;
import com.rec.entity.GroupsCedant;
import com.rec.entity.Region;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CedantRepository {
    private final MongoTemplate mongoTemplate;

    public CedantRepository(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public Cedant findById(String id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(id));
        return mongoTemplate.findOne(query, Cedant.class);
    }

    public List<ObjectId> findIds(String regionName, String countryName, String groupName) {
        List<Region> regions = null;
        if (StringUtils.hasLength(regionName)) {
            Query query = new Query();
            query.addCriteria(Criteria.where("name").is(regionName));
            regions = mongoTemplate.find(query, Region.class);
        }

        List<Country> countries = null;
        if (StringUtils.hasLength(countryName)) {
            Query query = new Query();
            query.addCriteria(Criteria.where("name").is(countryName));
            countries = mongoTemplate.find(query, Country.class);
        }

        List<GroupsCedant> groupsCedants = null;
        if (StringUtils.hasLength(groupName)) {
            Query query = new Query();
            query.addCriteria(Criteria.where("name").is(groupName));
            groupsCedants = mongoTemplate.find(query, GroupsCedant.class);
        }

        Query finalQuery = new Query();
        if (countries != null) {
            List<ObjectId> countriesId = countries.stream().map(Country::getId).collect(Collectors.toList());
            finalQuery.addCriteria(Criteria.where("countries_id").in(countriesId));
        }

        if (regions != null) {
            List<ObjectId> regionIds = regions.stream().map(Region::getId).collect(Collectors.toList());
            finalQuery.addCriteria(Criteria.where("region_id").in(regionIds));
        }

        if (groupsCedants != null) {
            List<ObjectId> groupsCedantsIds = groupsCedants.stream().map(GroupsCedant::getId).collect(Collectors.toList());
            finalQuery.addCriteria(Criteria.where("groups_cedants_id").in(groupsCedantsIds));
        }

        List<Cedant> result = mongoTemplate.find(finalQuery, Cedant.class);
        return result.size() > 0 ? result.stream()
                .map(Cedant::getId)
                .collect(Collectors.toList())
                : Collections.emptyList();
    }
}
