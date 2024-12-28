package models;

public class person {
    private String name;
    private String surname;
    private int age;
    private boolean gender;

    public person(String name, String surname, int age, boolean gender) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public boolean isFemale() {
        return gender;
    }

    public String getGenderAsString() {
        return gender ? "Female" : "Male";
    }

    @Override
    public String toString() {
        return "Hi, I am " + name + " " + surname + ", a " + age + "-year-old " + getGenderAsString();
    }
}
