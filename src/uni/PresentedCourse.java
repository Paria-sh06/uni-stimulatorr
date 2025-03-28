package uni;

import java.util.ArrayList;

public class PresentedCourse {
    public int id;
    public static ArrayList<PresentedCourse> presentedCourseList = new ArrayList<>();
    public int courseID;
    public int professorID;
    public int capacity;
    public ArrayList<Integer> studentIds;
    private static int counter = 1;

    public PresentedCourse(int courseID, int professorID, int maxCapacity) {
        this.id = counter++;
        this.courseID = courseID;
        this.professorID = professorID;
        this.capacity = maxCapacity;
        this.studentIds = new ArrayList<>(maxCapacity);
        presentedCourseList.add(this);
    }

    public static PresentedCourse findById(int ID) {
        for (PresentedCourse presentedCourse : presentedCourseList) {
            if (presentedCourse.id == ID) {
                return presentedCourse;
            }
        }
        return null;
    }

    public void addStudent(int studentID) {
        if (studentIds.contains(studentID)) {
            System.out.println("Student is already enrolled in this course.");
            return;
        }
        if (studentIds.size() < capacity) {
            studentIds.add(studentID);
        } else {
            System.out.println("Course capacity reached.");
        }
    }
}