package models;

import java.util.ArrayList;
import java.util.List;

public class student extends person {
    private static int idCounter = 1;
    private final int studentID;
    private final List<Integer> grades;

    public student(String name, String surname, int age, boolean gender) {
        super(name, surname, age, gender);
        this.studentID = idCounter++;
        this.grades = new ArrayList<>();
    }

    public void addGrade(int grade) {
        if (grade >= 0 && grade <= 100) {
            grades.add(grade);
        } else {
            System.out.println(" 0 and 100.");
        }
    }

    public double calculateGPA() {
        if (grades.isEmpty()) {
            return 0.0;
        }
        return grades.stream()
                     .mapToDouble(grade -> grade / 25.0)
                     .average()
                     .orElse(0.0);
    }

    public int getStudentID() {
        return studentID;
    }

    @Override
    public String toString() {
        return super.toString() + " I am a student with ID " + studentID + ".";
    }
}
