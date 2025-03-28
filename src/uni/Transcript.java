package uni;

import java.util.HashMap;
import base.Person;
import uni.Student;

public class Transcript {
    public int studentID;
    public HashMap<Integer, Double> transcript;

    public Transcript(int studentID) {
        this.studentID = studentID;
        this.transcript = new HashMap<>();
    }

    public void setGrade(int presentedCourseID, double grade) {
        PresentedCourse course = PresentedCourse.findById(presentedCourseID);
        if (course == null) {
            System.out.println("Course not found.");
            return;
        }
        if (course.studentIds.contains(studentID)) {
            transcript.put(presentedCourseID, grade);
        }
    }

    public void printTranscript() {
        Student student = Student.findById(studentID);
        if (student != null) {
            System.out.println("Name: " + Person.findByID(student.personID).name + ", Student ID: " + student.studentID);
            for (int courseID : transcript.keySet()) {
                PresentedCourse course = PresentedCourse.findById(courseID);
                if (course != null) {
                    Course courseDetails = Course.findById(course.courseID);
                    String courseTitle = courseDetails.title;
                    System.out.println("Course: " + courseTitle + " (Course ID: " + courseID + "), Grade: " + transcript.get(courseID));
                }
            }
        } else {
            System.out.println("Student not found!");
        }
    }

    public double getGPA() {
        if (transcript.isEmpty()) {
            return 0.0;
        }
        double totalGrades = 0;
        int totalUnits = 0;

        for (int courseID : transcript.keySet()) {
            PresentedCourse presentedCourse = PresentedCourse.findById(courseID);
            if (presentedCourse != null) {
                Course course = Course.findById(presentedCourse.courseID);
                if (course != null) {
                    int units = course.units;
                    totalGrades += transcript.get(courseID) * units;
                    totalUnits += units;
                }
            }
        }

        if (totalUnits == 0) System.out.println("The number of total units is zero.");;
        return totalGrades / totalUnits;
    }
}