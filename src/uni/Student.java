package uni;

import java.util.ArrayList;
import uni.Major;

public class Student {
    private static int counter = 1;
    public int id;
    public static ArrayList<Student> studentList = new ArrayList<>();
    public int personID;
    public final int entranceyear;
    public int majorID;
    public String studentID;

    public Student(int personID, int entranceyear, int majorID) {
        this.id = counter++;
        this.personID = personID;
        this.entranceyear = entranceyear;
        this.majorID = majorID;
        Major major = Major.findById(this.majorID);
        if (major != null) {
            major.addStudent();
        }
        setStudentCode();
        studentList.add(this);
    }

    public static Student findById(int id) {
        for (Student student : studentList) {
            if (student.id == id) {
                return student;
            }
        }
        return null;
    }

    public void setStudentCode() {
        Major major = Major.findById(this.majorID);
        if (major != null) {
            if(id < 10){
                if(major.id < 10){
                    this.studentID = (entranceyear - 1000) + String.format("%02d%02d", major.id, id);
                }
                else{
                    this.studentID = (entranceyear - 1000) + String.format("%d%02d", major.id, id);
                }
            }
            else{
                if(major.id < 10){
                    this.studentID = (entranceyear - 1000) + String.format("%02d%d", major.id, id);
                }
                else{
                    this.studentID = (entranceyear - 1000) + String.format("%d%d", major.id, id);
                }

            }
        } else {
            System.out.println("Major not found for this student ID ");
        }
    }
}