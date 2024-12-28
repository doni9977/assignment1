import models.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        School school = new School();


        try {

            BufferedReader studentReader = new BufferedReader(new FileReader("src/students.txt"));
            String line;
            while ((line = studentReader.readLine()) != null) {
                String[] data = line.split(" ");
                String name = data[0];
                String surname = data[1];
                int age = Integer.parseInt(data[2]);
                boolean gender = Boolean.parseBoolean(data[3]);


                student student = new student(name, surname, age, gender);


                for (int i = 4; i < data.length; i++) {
                    student.addGrade(Integer.parseInt(data[i]));
                }


                school.addMember(student);
            }
            studentReader.close();


            BufferedReader teacherReader = new BufferedReader(new FileReader("src/teachers.txt"));
            while ((line = teacherReader.readLine()) != null) {
                String[] data = line.split(" ");
                String name = data[0];
                String surname = data[1];
                int age = Integer.parseInt(data[2]);
                boolean gender =data[3].equalsIgnoreCase("Male");
                String subject = data[4];
                int yearsOfExperience = Integer.parseInt(data[5]);
                int salary = Integer.parseInt(data[6]);


                teacher teacher = new teacher(name, surname, age, gender, subject, yearsOfExperience, salary);


                if (teacher.yearsOfExperience > 10) {
                    teacher.giveRaise(10);
                }


                school.addMember(teacher);
            }
            teacherReader.close();

        } catch (IOException e) {
            System.out.println( e.getMessage());
        }


        school.sortMembersBySurname();


        System.out.println(school.toString());
    }
}
