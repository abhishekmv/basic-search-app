package com.unit.tests;

import static org.junit.Assert.assertSame;

import java.util.List;

import org.junit.Test;

import com.qpidhealth.qpid.search.model.Patient;
import com.qpidhealth.qpid.search.services.PatientService;

public class PatientServiceTest {

	@Test
	public void searchAllPatientsTest() {
		PatientService service = new PatientService();
		List<Patient> record = service.searchPatients("");
		assertSame("All the 3 records should be returned", record.size(), 3);
	}

	@Test
	public void searchAllPatientsNullTest() {
		PatientService service = new PatientService();
		List<Patient> record = service.searchPatients(null);
		assertSame("Should give all the results", record.size(), 3);
	}

	@Test
	public void searchOnePatientsTest() {
		PatientService service = new PatientService();
		List<Patient> record = service.searchPatients("joe");
		assertSame("Only records should be returned", record.size(), 1);
		assertSame("Only records should be returned", record.get(0).getName(), "Joe TestPerson");
	}

}
