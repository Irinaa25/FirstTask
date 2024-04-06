package org.irina;

import java.util.ArrayList;
import java.util.List;
public class Group {
    private String number;
    private List<Student> students;
    
    public Group(String number) {
        this.number = number;
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(Student student) {
        students.remove(student);
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }


    public void setNumber(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

}
