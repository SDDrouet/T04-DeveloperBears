package ec.edu.espe.inclass.controller;

import ec.edu.espe.inclass.model.Course;
import ec.edu.espe.inclass.model.Student;
import ec.edu.espe.inclass.model.Teacher;
import ec.edu.espe.inclass.model.Tutorship;
import java.util.ArrayList;
import utils.DBManager;

/**
 *
 * @author Alejandro Cuadrado, Developer Bears, DCCO-ESPE
 * @author Alexander Guaman, Developer Bears, DCCO-ESPE
 * @author Sheylee Enriquez, Developer Bears, DCCO-ESPE
 * @author Stephen Drouet, Developer Bears, DCCO-ESPE
 */
public class DataPersistence {

    public static Teacher teacher;
    public static DBManager dBManager;
    public static int position = 0;

    public static void connectMongoDB() {
        ArrayList<Tutorship> tutorships;
        ArrayList<Course> courses;
        ArrayList<Student> students;
        String name = "";
        String espeId = "";

        dBManager = new DBManager();
        dBManager.connect("mongodb+srv://oop22:oop22@cluster0.cd2tjad.mongodb.net/test", "InClassProject");
        teacher = new Teacher(espeId, name);
        teacher = TeacherController.jsonToTeacher((String) dBManager.readCollection("Teacher").get(0));
        tutorships = TutorshipController.loadTutorships(dBManager.readCollection("Tutorships"));
        courses = CourseController.loadCourses(dBManager.readCollection("Courses"));

        for (Course course : courses) {
            students = StudentController.loadStudents(dBManager.readCollection("Students", "nrc", course.getNrc()));
            course.setStudents(students);
        }

        teacher.setTutorships(tutorships);
        teacher.setCourses(courses);
    }

    public static void updateData() {
        ArrayList<Tutorship> tutorships;
        ArrayList<Course> courses;
        ArrayList<Student> students;
        String name = "";
        String espeId = "";

        teacher = new Teacher(espeId, name);
        teacher = TeacherController.jsonToTeacher((String) dBManager.readCollection("Teacher").get(0));
        tutorships = TutorshipController.loadTutorships(dBManager.readCollection("Tutorships"));
        courses = CourseController.loadCourses(dBManager.readCollection("Courses"));

        for (Course course : courses) {
            students = StudentController.loadStudents(dBManager.readCollection("Students", "nrc", course.getNrc()));
            course.setStudents(students);
        }

        teacher.setTutorships(tutorships);
        teacher.setCourses(courses);
    }

    public static void updateStudentsInDB(Course course) {
        for (Student student : course.getStudents()) {
            dBManager.updateDocument("Students", student.getEspeId(), course.getNrc(),
                    StudentController.studentToJsonForDB(student, course.getNrc()));
        }
    }

}
