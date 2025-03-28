import base.Person;
import uni.*;

public class Main {
    public static void main(String[] args) {
        Major mathematics = new Major("Mathematics", 50);
        Major cs = new Major("Computer Science", 30);

        Person person1 = new Person("Paria", "1");
        Person person2 = new Person("Bahar", "2");
        Person person3 = new Person("Tania", "3");
        Person person4 = new Person("Dr.Najafi", "4");
        Person person5 = new Person("Dr.Rostami", "5");

        Student student1 = new Student(person1.id, 1403, cs.id);
        Student student2 = new Student(person2.id, 1402, cs.id);
        Student student3 = new Student(person3.id, 1401, mathematics.id);

        System.out.println("Students:");
        for (Student student : Student.studentList) {
            Person studentPerson = Person.findByID(student.personID);
            if (studentPerson != null) {
                System.out.println("Name: " + studentPerson.name + ", Student ID: " + student.studentID);
            }
        }

        Professor professor1 = new Professor(person4.id, cs.id);
        Professor professor2 = new Professor(person5.id, mathematics.id);

        System.out.println("Professors:");
        for(Professor professor : Professor.professorList){
            Person professorPerson = Person.findByID(professor.personID);
            if(professorPerson != null){
                System.out.println("Name: " + professorPerson.name + ", Professor ID: " + professor.personID);
            }
        }

        Course course1 = new Course("Java programming", 3);
        Course course2 = new Course("Physics", 2);
        Course course3 = new Course("Algebra", 1);

        PresentedCourse presentedCourse1 = new PresentedCourse(course1.id, professor1.id, 2);
        PresentedCourse presentedCourse2 = new PresentedCourse(course2.id, professor1.id, 3);
        PresentedCourse presentedCourse3 = new PresentedCourse(course3.id, professor2.id, 1);

        presentedCourse1.addStudent(student1.id);
        presentedCourse2.addStudent(student1.id);
        presentedCourse1.addStudent(student2.id);
        presentedCourse2.addStudent(student2.id);
        presentedCourse2.addStudent(student3.id);
        presentedCourse3.addStudent(student3.id);

        Transcript transcript_st1 = new Transcript(student1.id);
        Transcript transcript_st2 = new Transcript(student2.id);
        Transcript transcript_st3 = new Transcript(student3.id);

        transcript_st1.setGrade(presentedCourse1.id, 18.5);
        transcript_st1.setGrade(presentedCourse2.id, 17.0);

        transcript_st2.setGrade(presentedCourse1.id, 15.0);
        transcript_st2.setGrade(presentedCourse2.id, 16.5);

        transcript_st3.setGrade(presentedCourse3.id, 19.0);
        transcript_st3.setGrade(presentedCourse2.id, 20.0);

        transcript_st1.printTranscript();
        transcript_st2.printTranscript();
        transcript_st3.printTranscript();

        double GPA1 = transcript_st1.getGPA();
        double GPA2 = transcript_st2.getGPA();
        double GPA3 = transcript_st3.getGPA();

        System.out.println("Name: " + person1.name + " - GPA: " + GPA1);
        System.out.println("Name: " + person2.name + " - GPA: " + GPA2);
        System.out.println("Name: " + person3.name + " - GPA: " + GPA3);
    }
}