package com.actionagainsthunger.equiptracking.domain.builders;

import com.actionagainsthunger.equiptracking.domain.location.*;
/*
    Class for test purpose only. Can't move anywhere because it is use by both androidTest (instrumented) and unit test
*/
public class ABase {
    private String id = "NAIROBI";
    private Country country = new ACountry().Build();

    public Base Build(){
        return new Base(id, country);
    }
}
