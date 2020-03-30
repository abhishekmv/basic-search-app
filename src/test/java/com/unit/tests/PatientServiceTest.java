package com.unit.tests;

import static org.junit.Assert.assertSame;

import java.util.List;

import org.junit.Test;

import com.qpidhealth.qpid.search.controller.PatientController;
import com.qpidhealth.qpid.search.model.Patient;

public class PatientServiceTest {

    @Test
    public void searchAllPatientsTest() {
        PatientController service = new PatientController();
        List<Patient> record = service.searchPatients("");
        assertSame("All the 3 records should be returned", record.size(), 3);
    }

    @Test
    public void searchAllPatientsNullTest() {
        PatientController service = new PatientController();
        List<Patient> record = service.searchPatients(null);
        assertSame("Should give all the results", record.size(), 3);
    }

    @Test
    public void searchOnePatientsTest() {
        PatientController service = new PatientController();
        List<Patient> record = service.searchPatients("joe");
        assertSame("Only one records should be returned", record.size(), 1);
        assertSame("Only one records should be returned", record.get(0).getName(),
                   "Joe TestPerson");
    }

    @Test
    public void searchNoMatchPatientsTest() {
        PatientController service = new PatientController();
        List<Patient> record = service.searchPatients("blah");
        assertSame("Only no records should be returned", record.size(), 0);
    }

}
