package models;

import java.util.ArrayList;
import java.util.List;

public class student extends person {
    static int idCounter = 1;
    int studentID;
    List<Integer> grades;


    public student(String name, String surname, int age, boolean gender) {
        super(name, surname, age, gender);
        this.studentID = idCounter++;
        this.grades = new ArrayList<>();
    }


    public void addGrade(int grade) {
        if (grade >= 0 && grade <= 100) {
            grades.add(grade);
        } else {
            System.out.println("от 0 до 100");
        }
    }


    public double calculateGPA() {
        if (grades.isEmpty()) {
            return 0.0;
        }
        double total = 0;
        for (int grade : grades) {
            total += grade;
        }
        return total / grades.size();
    }


    @Override
    public String toString() {
        return super.toString() + " I am a student with ID " + studentID + ".";
    }
}
