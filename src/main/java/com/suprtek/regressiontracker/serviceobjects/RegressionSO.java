package com.suprtek.regressiontracker.serviceobjects;

import com.suprtek.regressiontracker.dataaccessobjects.IRegressionData;
import com.suprtek.regressiontracker.dataobjects.Regression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by pnorthcutt on 7/26/2018.
 */
@Service
public class RegressionSO {
    private IRegressionData dao;
    @Autowired
    public void setDao(IRegressionData regressionDAO){
        this.dao = regressionDAO;
    }
    public Regression getRegressionInfo(int id){
        return dao.get(id);

    }
    public List<Regression> getAll(){
        return dao.getAll();
    }
}
