package com.suprtek.regressiontracker.dataaccessobjects;

import com.suprtek.regressiontracker.dataobjects.Regression;

import java.util.List;

/**
 * Created by pnorthcutt on 7/26/2018.
 */
public interface IRegressionData {
    public Regression get(int id);
    public List<Regression> getAll();
}
