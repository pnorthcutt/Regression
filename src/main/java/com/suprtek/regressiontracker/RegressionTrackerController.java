package com.suprtek.regressiontracker;

import com.suprtek.regressiontracker.dataobjects.Regression;
import com.suprtek.regressiontracker.serviceobjects.RegressionSO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * Created by pnorthcutt on 7/26/2018.
 */
@RestController@RequestMapping("/regression/{id}")
@Service
public class RegressionTrackerController implements IRegressionTracker {

    private RegressionSO serviceObject;

    @Autowired
    public void setServiceObject(RegressionSO so){
        this.serviceObject = so;
    }


    @Override
    @GetMapping
    public Collection<Regression> getAll() {
        Collection<Regression> allRegressions = new ArrayList<>();
        Regression regression = new Regression();
        allRegressions.add(regression);
        return serviceObject.getAll();
    }

    @Override
    @GetMapping("{id}")
    public Regression getByID(@PathVariable int id) {
        return serviceObject.getRegressionInfo(id);

    }

    @Override
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        String msg = "{msg:'success'}";
        return msg;
    }

    @Override
    @PostMapping("/{id}")
    public String add(@RequestBody Regression payload) {
        String msg = "{msg:'success1'}";
        return msg;
    }

    @Override
    @PostMapping("/modify/{id}")
    public String modify(@PathVariable String id, @RequestBody Regression payload) {
        String msg = "{msg:'success2'}";
        return msg;
    }
}
