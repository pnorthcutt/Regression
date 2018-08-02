package com.suprtek.regressiontracker;

import com.suprtek.regressiontracker.dataobjects.Regression;

import java.util.Collection;

/**
 * Created by pnorthcutt on 7/25/2018.
 */
public interface IRegressionTracker {
    public Collection<Regression> getAll();
    public Regression getByID(int id);
    public String delete(int id);
    public String add(Regression payload);
    public String modify(String id,Regression payload);

}
