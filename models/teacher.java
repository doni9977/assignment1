package models;

public class teacher extends person {
    private String subject;
    private int yearsOfExperience;
    private int salary;

    public teacher(String name, String surname, int age, boolean gender, String subject, int yearsOfExperience, int salary) {
        super(name, surname, age, gender);
        this.subject = subject;
        this.yearsOfExperience = yearsOfExperience;
        this.salary = salary;
    }

    public String getSubject() {
        return subject;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public int getSalary() {
        return salary;
    }

    public void giveRaise(double percentage) {
        if (percentage > 0) {
            this.salary += (int) (this.salary *(percentage/100));
        }
    }

    @Override
    public String toString() {
        return super.toString() + " I teach " + subject + ".";
    }
}
