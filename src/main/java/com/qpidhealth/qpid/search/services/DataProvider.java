package com.qpidhealth.qpid.search.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

import com.qpidhealth.qpid.search.controller.PatientController;
import com.qpidhealth.qpid.search.model.Patient;

/**
 * A class to provide data based on the search query
 *
 */
public class DataProvider {

    /**
     * A method to provide all the patient results if no search word is provided
     * 
     * @return
     *         A list of all patient object is returned 
     */
    public static List<Patient> getAllPatientData() {
        // Patient 1
        List<String> docs = new ArrayList<String>();
        docs.add("Patient Note:::6/20/2010:::" + resource("Mary_1"));
        docs.add("Patient Note:::6/20/2010:::" + resource("Mary_2"));
        Patient p1 = new Patient(1000000L, "Mary TestPerson", docs);

        // Patient 2
        List<String> docs2 = new ArrayList<String>();
        docs2.add("Clinical Note:::4/6/2010:::" + resource("Joe_1"));
        docs2.add("Summary:::7/2/2010:::" + resource("Joe_2"));
        Patient p2 = new Patient(1000001L, "Joe TestPerson", docs2);

        // Patient 3
        List<String> docs3 = new ArrayList<String>();
        docs3.add("Patient Note:::8/3/2012:::" + resource("Sam_1"));
        Patient p3 = new Patient(1000002L, "Sam TestPerson", docs3);

        List<Patient> results = new ArrayList<Patient>();
        results.add(p1);
        results.add(p2);
        results.add(p3);
        return results;
    }

    /**
     * A method to provide all the patient details that match the search word only
     * 
     * @param query
     *          A String value
     * @return
     *          A list of patient details/object is returned that match the search word
     */
    public static List<Patient> getFilteredPatientData(String query) {

        List<Patient> results = new ArrayList<Patient>();

        // Patient 1
        List<String> docs = new ArrayList<String>();
        docs.add("Patient Note:::6/20/2010:::" + resource("Mary_1"));
        docs.add("Patient Note:::6/20/2010:::" + resource("Mary_2"));
        Patient p1 = new Patient(1000000L, "Mary TestPerson", docs);

        if (isMatch(p1, query)) {
            results.add(p1);
        }

        // Patient 2
        List<String> docs2 = new ArrayList<String>();
        docs2.add("Clinical Note:::4/6/2010:::" + resource("Joe_1"));
        docs2.add("Summary:::7/2/2010:::" + resource("Joe_2"));
        Patient p2 = new Patient(1000001L, "Joe TestPerson", docs2);

        if (isMatch(p2, query)) {
            results.add(p2);
        }

        // Patient 3
        List<String> docs3 = new ArrayList<String>();
        docs3.add("Patient Note:::8/3/2012:::" + resource("Sam_1"));
        Patient p3 = new Patient(1000002L, "Sam TestPerson", docs3);

        if (isMatch(p3, query)) {
            results.add(p3);
        }

        return results;
    }

    private static String resource(String fileName) {
        ClassLoader classLoader = PatientController.class.getClassLoader();
        try {
            return IOUtils
                    .toString(classLoader.getResourceAsStream("documents/" + fileName + ".txt"));
        } catch (IOException e) {
            e.printStackTrace();
            return "Failed to retrieve resource " + fileName;
        }
    }

    private static boolean isMatch(Patient p, String query) {
        if (StringUtils.containsIgnoreCase(p.getName(), query)) {
            return true;
        }

        Iterator<String> it = p.getDocuments().iterator();
        while (it.hasNext()) {
            if (StringUtils.containsIgnoreCase(it.next(), query)) {
                return true;
            }
        }
        return false;
    }
}
