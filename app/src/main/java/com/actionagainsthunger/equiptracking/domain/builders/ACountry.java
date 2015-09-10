package com.actionagainsthunger.equiptracking.domain.builders;

import com.actionagainsthunger.equiptracking.domain.location.Country;

/*
    Class for test purpose only. Can't move anywhere because it is use by both androidTest (instrumented) and unit test
*/
public class ACountry {
    private String id = "KNY";

    public Country Build(){
        return new Country(id);
    }
}
