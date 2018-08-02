package com.suprtek.regressiontracker.dataobjects;

import org.apache.el.lang.ELArithmetic;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;

/**
 * Created by pnorthcutt on 7/26/2018.
 */
@Document(collection="regression")
public class Regression {
    @Id
    private BigInteger _Id;
    private int id;
    private String name;
    private String group;
    private String tester;
    private String steps;
    private String results;
    private String reason;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getTester() {
        return tester;
    }

    public void setTester(String tester) {
        this.tester = tester;
    }

    public String getSteps() {
        return steps;
    }

    public void setSteps(String steps) {
        this.steps = steps;
    }

    public String getResults() {
        return results;
    }

    public void setResults(String results) {
        this.results = results;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public BigInteger get_Id() {
        return _Id;
    }

    public void set_Id(BigInteger _Id) {
        this._Id = _Id;
    }
}
