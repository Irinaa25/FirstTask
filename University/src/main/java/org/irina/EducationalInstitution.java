package org.irina;
import java.util.ArrayList;
import java.util.List;
public class EducationalInstitution {
    private List<Faculty> faculties;

    public EducationalInstitution() {
        this.faculties = new ArrayList<>();
    }

    public void addFaculty(Faculty faculty) {
        faculties.add(faculty);
    }

    public void removeFaculty(Faculty faculty) {
        faculties.remove(faculty);
    }

    public List<Faculty> getFaculties() {
        return faculties;
    }

    public void setFaculties(List<Faculty> faculties) {
        this.faculties = faculties;
    }
}
