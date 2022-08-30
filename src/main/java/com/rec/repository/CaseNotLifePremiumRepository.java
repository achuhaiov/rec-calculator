package com.rec.repository;

import com.rec.entity.CaseNotLifePremium;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CaseNotLifePremiumRepository {
    private static final String COLLECTION_NAME = "case_not_life_premium";

    private final MongoTemplate mongoTemplate;

    public CaseNotLifePremiumRepository(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public List<CaseNotLifePremium> findByCedantsAndBranchesAndSlips(List<ObjectId> cedantIds,
                                                                     List<ObjectId> branchIds,
                                                                     List<ObjectId> slipesIds) {
        Criteria cedantsIdFilter = Criteria.where("cedants_id").in(cedantIds);
        Criteria slipsIdFilter = Criteria.where("branches_id").in(branchIds);
        Criteria brancheIdFilter = Criteria.where("slipes_prime_id").in(slipesIds);

        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.match(cedantsIdFilter),
                Aggregation.match(brancheIdFilter),
                Aggregation.match(slipsIdFilter),
                Aggregation.group("slipes_prime_id").sum("premium_ht").as("sum_premium_ht")
                        .last("branches_id").as("branches_id")
                        .last("branch").as("branch")
                        .last("cedants_id").as("cedants_id")
                        .last("slipes_prime_id").as("slipes_prime_id"));

        return mongoTemplate.aggregate(aggregation, COLLECTION_NAME, CaseNotLifePremium.class).getMappedResults();
    }

}
