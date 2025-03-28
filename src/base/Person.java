package base;

import java.util.ArrayList;

public class Person {
    public int id;
    public static ArrayList<Person> personList = new ArrayList<>();
    public String name;
    public String nationalID;
    private static int counter = 1;

    public Person(String name, String nationalID) {
        this.id = counter++;
        this.name = name;
        this.nationalID = nationalID;
        personList.add(this);
    }

    public static Person findByID(int id) {
        for (Person person : personList) {
            if (person.id == id) {
                return person;
            }
        }
        return null;
    }

    public int getId() {
        return this.id;
    }
}