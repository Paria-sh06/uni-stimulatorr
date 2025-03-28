package uni;

import java.util.ArrayList;

public class Professor {
    public int id;
    public static ArrayList<Professor> professorList = new ArrayList<>();
    public int personID;
    public int majorID;

    public Professor(int personID, int majorID) {
        this.id = professorList.size() + 1; // Assign a unique ID
        this.personID = personID;
        this.majorID = majorID;
        professorList.add(this);
    }

    public static Professor findById(int ID) {
        for (Professor professor : professorList) {
            if (professor.id == ID) { // Corrected variable name
                return professor;
            }
        }
        return null;
    }
}
