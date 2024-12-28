import models.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        School school = new School();

        File studentsFile = new File("src/students.txt");
        Scanner studentScanner = new Scanner(studentsFile);

        while (studentScanner.hasNextLine()) {
            String name = studentScanner.next();
            String surname = studentScanner.next();
            int age = studentScanner.nextInt();
            boolean gender = studentScanner.next().equalsIgnoreCase("Female");
            String gradesLine = studentScanner.nextLine().trim();

            student student = new student(name, surname, age, gender);

            if (!gradesLine.isEmpty()) {
                String[] grades = gradesLine.split(" ");
                for (String grade : grades) {
                    student.addGrade(Integer.parseInt(grade));
                }
            }
            school.addMember(student);
        }
        studentScanner.close();

        File teachersFile = new File("src/teachers.txt");
        Scanner teacherScanner = new Scanner(teachersFile);

        while (teacherScanner.hasNextLine()) {
            String name = teacherScanner.next();
            String surname = teacherScanner.next();
            int age = teacherScanner.nextInt();
            boolean gender = teacherScanner.next().equalsIgnoreCase("Female");
            String subject = teacherScanner.next();
            int yearsOfExperience = teacherScanner.nextInt();
            int salary = teacherScanner.nextInt();

            teacher teacher = new teacher(name, surname, age, gender, subject, yearsOfExperience, salary);

            if (yearsOfExperience > 10) {
                teacher.giveRaise(10);
            }

            school.addMember(teacher);
        }
        teacherScanner.close();

        school.sortMembersBySurname();

        System.out.println("School Members:");
        System.out.println(school);

        System.out.println("GPA of students:");
        for (person member : school.members) {
            if (member instanceof student) {
                student student = (student) member;
                System.out.printf("%s's GPA: %.2f%n", student.getName(), student.calculateGPA());
            }
        }

        System.out.println("\nSalaries of teachers after potential raises:");
        for (person member : school.members) {
            if (member instanceof teacher) {
                teacher teacher = (teacher) member;
                System.out.printf("%s's salary: %d%n", teacher.getName(), teacher.getSalary());
            }
        }
    }
}
