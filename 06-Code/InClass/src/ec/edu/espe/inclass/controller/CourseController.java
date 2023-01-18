package ec.edu.espe.inclass.controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import static ec.edu.espe.inclass.controller.DataPersistence.dBManager;
import static ec.edu.espe.inclass.controller.DataPersistence.teacher;
import ec.edu.espe.inclass.model.Course;
import java.util.ArrayList;

/**
 *
 * @author Alejandro Cuadrado, Developer Bears, DCCO-ESPE
 * @author Alexander Guaman, Developer Bears, DCCO-ESPE
 * @author Sheylee Enriquez, Developer Bears, DCCO-ESPE
 * @author Stephen Drouet, Developer Bears, DCCO-ESPE
 */
public class CourseController {

    public static String courseToJsonForDB(Course course) {
        String json;
        JsonObject rootObject = new JsonObject();

        rootObject.addProperty("name", course.getName());
        rootObject.addProperty("nrc", course.getNrc());

        json = rootObject.toString();

        return json;
    }

    public static ArrayList loadCourses(ArrayList<String> jsons) {
        ArrayList<Course> courses;
        courses = new ArrayList<>();

        for (String json : jsons) {
            courses.add(jsonToCourse(json));
        }

        return courses;
    }

    public static Course jsonToCourse(String json) {
        Course course;
        Gson gson;
        gson = new Gson();
        course = new Course();

        course = gson.fromJson(json, course.getClass());

        return course;
    }

    public static int findCourse(ArrayList<Course> courses, int nrc) {
        int index = -1;

        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getNrc() == nrc) {
                index = i;
                return index;
            }
        }

        return index;
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

}
