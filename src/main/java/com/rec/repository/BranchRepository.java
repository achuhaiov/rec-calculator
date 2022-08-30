package com.rec.repository;

import com.rec.entity.Branch;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class BranchRepository {
    private final MongoTemplate mongoTemplate;

    public BranchRepository(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public List<ObjectId> findIds(String branchType) {
        List<Branch> branches;
        if (StringUtils.hasLength(branchType)) {
            Query query = new Query();
            query.addCriteria(Criteria.where("type").is(branchType.toLowerCase()));
            branches = mongoTemplate.find(query, Branch.class);
        } else {
            branches = mongoTemplate.findAll(Branch.class);
        }
        return branches.stream().map(Branch::getId).collect(Collectors.toList());
    }

}
