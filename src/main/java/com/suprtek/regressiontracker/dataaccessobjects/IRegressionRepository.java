package com.suprtek.regressiontracker.dataaccessobjects;

import com.suprtek.regressiontracker.dataobjects.Regression;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.Repository;

import java.util.List;

/**
 * Created by pnorthcutt on 7/30/2018.
 */
public interface IRegressionRepository extends MongoRepository<Regression,Integer> {

}
