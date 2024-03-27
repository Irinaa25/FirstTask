
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import University.*;


/**
 * Условие: В учебном заведении есть несколько факультетов, каждый факультет имеет несколько кафедр, а каждая кафедра содержит несколько групп студентов. Каждый студент имеет несколько предметов, которые он изучает. Необходимо создать программу на Java для управления студентами и их учебным процессом.

Требования:
1. Создать классы Student (студент), Subject (предмет), Group (группа), Department (кафедра), Faculty (факультет) и EducationalInstitution (учебное заведение).
2. Класс Student должен содержать информацию о студенте (имя, фамилия, возраст, идентификационный номер) и список предметов, которые он изучает.
3. Класс Subject должен содержать информацию о предмете (название, преподаватель).
4. Класс Group должен содержать информацию о группе студентов и методы для добавления и удаления студентов из группы.
5. Класс Department должен содержать информацию о кафедре (название, заведующий кафедрой) и список групп студентов на этой кафедре.
6. Класс Faculty должен содержать информацию о факультете (название) и список кафедр на этом факультете.
7. Класс EducationalInstitution должен содержать список факультетов и методы для добавления новых факультетов, кафедр, групп и студентов.
 
 1. Необходимо сделать возможность создания факультетов и принятия студентов. Вывести на каком факультете учится заданный студент
 2. Перевод студента с одного факультета на другой.
 */
public class Main {
    
    public static void main(String[] args) {
        

        EducationalInstitution educationalInstitution = new EducationalInstitution();


        List<Subject> subjects = new ArrayList<>();
        subjects.add(new Subject("Право", "Иванов"));
        subjects.add(new Subject("Информатика", "Петрова"));
        subjects.add(new Subject("Математика", "Иванова"));


        Student student = new Student("Иванов", "Иван", 22, subjects);

        Group group = new Group("91");
        Group group1 = new Group("1");

        group.addStudent(student);


        Department department = new Department("ПОиАИС");
        Department department1 = new Department("1");

        department.addGroup(group);
        department1.addGroup(group1);

        Faculty faculty = new Faculty("ПММ");
        Faculty faculty1 = new Faculty("ФКН");

        faculty.addDepartment(department);
        faculty1.addDepartment(department1);
        educationalInstitution.addFaculty(faculty);
        educationalInstitution.addFaculty(faculty1);

        var faculties = getFacultiesOfStudent(educationalInstitution, "Иванов");
        System.out.println("Факультеты на которых учится Ивановы: ");

        for (String name : faculties) {
            System.out.print(name + ", ");
        }
        System.out.println("");
        transferToAnotherFaulty(educationalInstitution, student, "ФКН", "1", "1");
    
        faculties = getFacultiesOfStudent(educationalInstitution, "Иванов");
        System.out.println("Факультеты на которых учится Ивановы: ");

        for (String name : faculties) {
            System.out.print(name + ", ");
        }
    
    }

    private static void transferToAnotherFaulty(EducationalInstitution educationalInstitution, Student studentToTransfer, String facultyName, String departmentName, String groupNum) {
        
        Group groupFromRemoved = null;
        for (Faculty faculty : educationalInstitution.getFaculties()) {
            for (Department department : faculty.getDepartments()) {
                for (Group group : department.getGroups()) {
                    for (Student student : group.getStudents()) {
                        if (student.equals(studentToTransfer)) {
                            groupFromRemoved = group;
                        }
                    }
                }
            }
        }
        if (groupFromRemoved != null) {
        groupFromRemoved.removeStudent(studentToTransfer);
        for (Faculty faculty : educationalInstitution.getFaculties()) {

            if (faculty.getName().equals(facultyName)) {
                for (Department department : faculty.getDepartments()) {
                    if (department.getName().equals(departmentName)) {
                        for (Group group : department.getGroups()) {
                            if (group.getNumber().equals(groupNum)) {
                                group.addStudent(studentToTransfer);
                            }
                        }
                    }
                    
                }
            }
            
        }
    }

    }


    public static Set<String> getFacultiesOfStudent(EducationalInstitution educationalInstitution, String firstName) {
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



}