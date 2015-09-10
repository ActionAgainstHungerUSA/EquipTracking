package com.actionagainsthunger.equiptracking.domain.builders;

import com.actionagainsthunger.equiptracking.domain.administration.Organization;

/*
    Class for test purpose only. Can't move anywhere because it is use by both androidTest (instrumented) and unit test
*/
public class AnOrganization {
    private String id = "H3D";

    public Organization Build(){
        return new Organization(id);
    }
}
