
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
 
 Необходимо сделать возможность создания факультетов и принятия студентов. Вывести на каком факультете учится заданный студент
 
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

        group.addStudent(student);


        Department department = new Department("ПОиАИС");

        department.addGroup(group);


        Faculty faculty = new Faculty("ПММ");

        faculty.addDepartment(department);

        educationalInstitution.addFaculty(faculty);


        var faculties = getFacultiesOfStudent(educationalInstitution, "Иванов");
        System.out.println("Факультеты на которых учится Ивановы: ");

        for (String name : faculties) {
            System.out.print(name + ", ");
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