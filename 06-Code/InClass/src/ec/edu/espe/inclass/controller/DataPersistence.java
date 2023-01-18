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

    public static int removeCourse(int courseNumber) {

        try {
            dBManager.deleteDocument("Courses", "nrc", teacher.getCourses().get(courseNumber).getNrc());
            teacher.getCourses().remove(courseNumber);
            System.out.println("The course was remove successfully");
            return 1;
        } catch (Exception e) {
            System.out.println("The course was not remove");
            return 0;
        }
    }

    public static int removeStudent(String espeId, int studenNumber, int nrc, int courseNumber) {

        try {
            dBManager.deleteStudentDocument(espeId, nrc);
            teacher.getCourses().get(courseNumber).getStudents().remove(studenNumber);
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    public static int loginTeacher(String espeId, String password) {

        if (espeId.equals(teacher.getEspeId()) && password.equals(teacher.getPassword())) {
            return 1;
        } else {
            return 0;
        }

    }

    public static int findCourse(int courseToFind) {
        ArrayList<Course> courses;
        courses = teacher.getCourses();
        boolean exists = false;

        int courseNumber = 0;
        try {
            while (exists == false) {

                if (courses.get(courseNumber).getNrc() == courseToFind) {
                    exists = true;
                } else {
                    courseNumber++;
                }
            }
        } catch (Exception e) {

        }

        if (exists == true) {
            return 1;
        } else {
            return 0;
        }

    }

    public static int addCourse(String name, int nrc) {

        Course newCourse;
        int validated;

        try {

            newCourse = new Course(name, nrc);

            teacher.getCourses().add(newCourse);
            validated = 1;

        } catch (Exception e) {
            validated = 0;
        }

        return validated;
    }

}
