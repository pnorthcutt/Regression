package com.suprtek.regressiontracker.dataaccessobjects;

import com.suprtek.regressiontracker.dataobjects.Regression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by pnorthcutt on 7/26/2018.
 */
@Service
public class RegressionMongoDAO implements IRegressionData {
    private MongoTemplate mongoTemplate;
    @Autowired
    public RegressionMongoDAO(MongoTemplate repo) {
        this.mongoTemplate = repo;
    }

    @Override
    public Regression get(int id) {

        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id));
        Regression res =  mongoTemplate.findOne(query,Regression.class);
        return res;
    }

    @Override
    public List<Regression> getAll() {
        return (List<Regression>) mongoTemplate.findAll(Regression.class);
    }
}
