package com.qpidhealth.qpid.search.controller;

import javax.ejb.Lock;
import javax.ejb.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.qpidhealth.qpid.search.model.Patient;
import com.qpidhealth.qpid.search.services.DataProvider;

import java.util.List;
import static javax.ejb.LockType.READ;


@Path("/patients")
@Singleton
@Lock(READ)
public class PatientController {

    /**
     * A method to get results based on word search
     * 
     * @param query
     *          A string value
     * @return
     *          A list of patient object which matches the search query
     */
    @GET
    @Path("/search")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Patient> searchPatients(@QueryParam("query") String query) {

        List<Patient> records = (query == null || query.trim().isEmpty()
                || query.equals("undefined"))
                        ? DataProvider.getAllPatientData()
                        : DataProvider.getFilteredPatientData(query);

        return records;
    }
}
