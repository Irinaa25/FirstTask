package University;

import java.util.ArrayList;
import java.util.List;
public class Student {

    private String firstName;
    private String lastName;
    private int age;
    private List<Subject> subjects;

    public Student(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.subjects = new ArrayList<>();
    }
    public Student(String firstName, String lastName, int age, List<Subject> subjects) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.subjects = subjects;
    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }
}