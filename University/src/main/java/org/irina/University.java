package org.irina;

import java.util.List;
import java.util.Set;
import java.util.HashSet;


public class University {
    private EducationalInstitution educationalInstitution;

    public University() {
        educationalInstitution = new EducationalInstitution();
    }

    private Faculty findFaculty(String s) {

        for (Faculty fac : educationalInstitution.getFaculties()) {
        if (fac.getName().equals(s)) {
            return fac;
        }
        }
        return null;
    }
    
    private Department findDepartmentInFaculty(List<Department> departments, String s) {
        for (Department dep : departments) {
            if (dep.getName().equals(s)) {
                return dep;
            }
        }
        return null;
    }
            
    private Group findGroupInDep(List<Group> groups, String s) {
        for (Group group : groups) {
            if (group.getNumber().equals(s)) {
                return group;
            }
        }
        return null;
    }

    public void createUniversity(List<String> universityInfo) {
        for (String info : universityInfo) {

            String[] universityByString = info.split(";");
            Faculty fac = findFaculty(universityByString[0]);
            if (fac == null) {
                fac = new Faculty(universityByString[0]);
                this.educationalInstitution.addFaculty(fac);
            }
            
            Department department = findDepartmentInFaculty(fac.getDepartments(), universityByString[1]);
            if (department == null) {
                department = new Department(universityByString[1]);
                fac.addDepartment(department);
            }
            
            Group group = findGroupInDep(department.getGroups(), universityByString[2]);

            if (group == null) {
                group = new Group(universityByString[2]);
                department.addGroup(group);
            }

            group.addStudent(new Student(universityByString[3], universityByString[4], 
            Integer.parseInt(universityByString[5])));

        }
    }

    public void transferToAnotherFaulty(String studentNameToTransfer, String facultyName, 
    String departmentName, String groupNum) {
        
        Group groupFromRemoved = null;
        Student studentTotr = null;
        for (Faculty faculty : educationalInstitution.getFaculties()) {
            for (Department department : faculty.getDepartments()) {
                for (Group group : department.getGroups()) {
                    for (Student student : group.getStudents()) {
                        if (student.getFirstName().equals(studentNameToTransfer)) {
                            studentTotr = student;
                            groupFromRemoved = group;
                        }
                    }
                }
            }
        }
        if (groupFromRemoved != null) {
        groupFromRemoved.removeStudent(studentTotr);
        for (Faculty faculty : educationalInstitution.getFaculties()) {

            if (faculty.getName().equals(facultyName)) {
                for (Department department : faculty.getDepartments()) {
                    if (department.getName().equals(departmentName)) {
                        for (Group group : department.getGroups()) {
                            if (group.getNumber().equals(groupNum)) {
                                group.addStudent(studentTotr);
                            }
                        }
                    }
                    
                }
            }
            
        }
    }

    }

    public Set<String> getFacultiesOfStudent(String firstName) {
        Set<String> result = new HashSet<>();
        for (Faculty faculty : educationalInstitution.getFaculties()) {
            for (Department department : faculty.getDepartments()) {
                for (Group group : department.getGroups()) {
                    for (Student student : group.getStudents()) {
                        if (student.getFirstName().equals(firstName)) {
                            result.add(faculty.getName());
                        }
                    }
                }
            }
        }

        return result;

    }

    public EducationalInstitution getEducationalInstitution() {
        return educationalInstitution;
    }

}
