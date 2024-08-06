import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;



//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static List<Student> studentList = new ArrayList<>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        System.out.println("Enter the number of students:");

        int n = scanner.nextInt();

        scanner.nextLine();


        for (int i = 1; i <= n; i++) {

            input(scanner);

        }


        System.out.println("Student list before removal:");

        output();


        System.out.print("Enter the student code to remove: ");

        String codeToRemove = scanner.nextLine().trim();

        removeByCode(codeToRemove);


        System.out.println("Student list after removal:");

        output();


        sortByGradeDesc();

        System.out.println("Student list after sorting by grade in descending order:");

        output();


        System.out.print("Enter the student code or name to search: ");

        String keyword = scanner.nextLine().trim();

        Student foundStudent = findByCodeOrName(keyword);

        if (foundStudent != null) {

            System.out.println("Student found:");

            System.out.println(foundStudent);


        } else {
            System.out.println("Student not found.");
        }


        System.out.print("Enter the minimum grade to filter students: ");

        float minGrade = scanner.nextFloat();

        scanner.nextLine();

        List<Student> filteredStudents = filterByGrade(minGrade);

        System.out.println("Student list with grade >= " + minGrade + ":");

        for (Student student : filteredStudents) {

            System.out.println(student);

        }
    }


    public static void input(Scanner scanner) {

        System.out.println("Enter student information:");

        System.out.print("Enter student name: ");

        String name = scanner.nextLine().trim();

        System.out.print("Enter age: ");

        int age = scanner.nextInt();

        scanner.nextLine();


        System.out.print("Enter email: ");

        String email = scanner.nextLine().trim();

        System.out.print("Enter phone number: ");

        String phone = scanner.nextLine().trim();

        System.out.print("Enter student code: ");

        String code = scanner.nextLine().trim();

        System.out.print("Enter gender (1: Male, 2: Female, 3: Other): ");

        int gender = scanner.nextInt();


        System.out.print("Enter grade: ");

        float grade = scanner.nextFloat();

        scanner.nextLine();

        Student student = new Student(
                name,
                age,
                email,
                phone,
                code,
                gender,
                grade);

        studentList.add(student);
    }


    public static void output() {

        if (studentList.isEmpty()) {

            System.out.println("Student list is empty.");

        } else {

            for (Student student : studentList) {

                System.out.println(student);

            }
        }
    }


    public static void removeByCode(String code) {

        String trimmedCode = code.trim();

        boolean removed = studentList.removeIf(student -> student.getCode().equalsIgnoreCase(trimmedCode));

        if (removed) {

            System.out.println("Student with code " + trimmedCode + " has been removed.");

        } else {

            System.out.println("No student found with code " + trimmedCode + ".");

        }
    }


    public static void sortByGradeDesc() {

        studentList.sort(Comparator.comparing(Student::getGrade).reversed());
    }


    public static Student findByCodeOrName(String keyword) {

        return studentList.stream()

                .filter(student -> student.getCode().equalsIgnoreCase(keyword) ||

                        student.getName().equalsIgnoreCase(keyword))

                .findFirst()

                .orElse(null);

    }


    public static List<Student> filterByGrade(float x) {

        return studentList.stream()

                .filter(student -> student.getGrade() >= x)

                .collect(Collectors.toList());

    }
}