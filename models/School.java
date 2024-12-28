package models;

import java.util.ArrayList;
import java.util.List;

public class School {
    public final List<person> members;

    public School() {
        this.members = new ArrayList<>();
    }

    public void addMember(person person) {
        if (person != null) {
            members.add(person);
        }
    }

    public void sortMembersBySurname() {
        members.sort((p1, p2) -> p1.getSurname().compareToIgnoreCase(p2.getSurname()));
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (person person : members) {
            result.append(person.toString()).append("\n");
        }
        return result.toString();
    }
}
