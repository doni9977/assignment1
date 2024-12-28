package models;

import java.util.ArrayList;
import java.util.List;

public class School {
    List<person> members;


    public School() {
        this.members = new ArrayList<>();
    }


    public void addMember(person person) {
        members.add(person);
    }


    public void sortMembersBySurname() {
        members.sort((p1, p2) -> p1.surname.compareTo(p2.surname));
    }


    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Members:\n");
        for (person member : members) {
            result.append(member.toString()).append("\n");
        }
        return result.toString();
    }
}

