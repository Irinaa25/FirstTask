package org.irina;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;

public class UniversityTest {

    private University university;

    private List<String> universityInfo;

    @BeforeEach
    public void init() {
        university = new University();
        universityInfo = new ArrayList<>();
        universityInfo.add("AMM;MOIAIS;11;AaaaaaA;Bbbbbb;20");
        universityInfo.add("FKN;POIAIS;12;Aaaaaab;Bbbbbb;21");
        universityInfo.add("FF;POIAIS;13;Aaaaaac;Bbbbbb;22");
    }

    @Test
    @Order(1)
    public void checkUniversityCreate() {
        university.createUniversity(universityInfo);

        assertNotNull(university.getEducationalInstitution());
    }

    @Test
    @Order(2)
    public void checkFacultySearch() {
        university.createUniversity(universityInfo);
       assertEquals(true, university.getFacultiesOfStudent("AaaaaaA").contains("AMM"));
    }

    @Test
    @Order(3)
    public void checkFirstName() {
       Student student = new Student("Демидова", "Ирина",22);
       assertEquals("Демидова", university.NewFunc(student));
    }

}
