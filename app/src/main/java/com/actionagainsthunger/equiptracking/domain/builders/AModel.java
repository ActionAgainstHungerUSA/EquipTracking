package com.actionagainsthunger.equiptracking.domain.builders;

import com.actionagainsthunger.equiptracking.domain.Brand;
import com.actionagainsthunger.equiptracking.domain.Model;

/*
    Class for test purpose only. Can't move anywhere because it is use by both androidTest (instrumented) and unit test
*/
public class AModel {
    private String id = "SATELLITE C-IPT";
    private Brand brand = new ABrand().Build();

    public Model Build(){
        return new Model(id,brand);
    }
}
