package uni;

import java.util.ArrayList;

public class Major {
    public int id;
    public static ArrayList<Major> majorList = new ArrayList<>();
    public String name;
    public final int capacity;
    public int numberOfStudents = 0;
    private static int counter = 1;

    public Major(String name, int capacity) {
        this.id = counter++;
        this.name = name;
        this.capacity = capacity;
        majorList.add(this);
    }

    public static Major findById(int id) {
        for (Major major : majorList) {
            if (major.id == id) {
                return major;
            }
        }
        return null;
    }

    public void addStudent() {
        if (numberOfStudents < capacity) {
            numberOfStudents++;
        } else {
            System.out.println("Major capacity reached.");
        }
    }
}
