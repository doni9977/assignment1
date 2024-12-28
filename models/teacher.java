package models;

public class teacher extends person {
    String subject;
    public int yearsOfExperience;
    int salary;


    public teacher(String name, String surname, int age, boolean gender, String subject, int yearsOfExperience, int salary) {
        super(name, surname, age, gender);
        this.subject = subject;
        this.yearsOfExperience = yearsOfExperience;
        this.salary = salary;
    }


    public void giveRaise(double percentage) {
        if (percentage > 0) {
            this.salary += (int) (this.salary * percentage / 100);
        } else {
            System.out.println("Raise percentage must be positive.");
        }
    }


    @Override
    public String toString() {
        return super.toString() + " I teach " + subject + ".";
    }
}
