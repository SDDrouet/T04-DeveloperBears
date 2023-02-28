package ec.edu.espe.inclass.controller;

import ec.edu.espe.inclass.model.Course;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Stephen Drouet, Developer Bears, DCC-ESPE
 */
public class CourseControllerTest {
    
    public CourseControllerTest() {
    }

    /**
     * Test of courseToJsonForDB method, of class CourseController.
     */
    @Test
    public void testCourseToJsonForDB() {
        System.out.println("courseToJsonForDB");
        Course course = null;
        String expResult = "";
        String result = CourseController.courseToJsonForDB(course);
        assertEquals(expResult, result);
    }

    /**
     * Test of loadCourses method, of class CourseController.
     */
    @Test
    public void testLoadCourses() {
        System.out.println("loadCourses");
        ArrayList<String> jsons = null;
        ArrayList expResult = null;
        ArrayList result = CourseController.loadCourses(jsons);
        assertEquals(expResult, result);
    }

    /**
     * Test of jsonToCourse method, of class CourseController.
     */
    @Test
    public void testJsonToCourse() {
        System.out.println("jsonToCourse");
        String json = "";
        Course expResult = null;
        Course result = CourseController.jsonToCourse(json);
        assertEquals(expResult, result);
    }

    /**
     * Test of findCourse method, of class CourseController.
     */
    @Test
    public void testFindCourseNull() {
        System.out.println("findCourse");
        ArrayList<Course> courses = null;
        int nrc = 0;
        int expResult = -1;
        int result = CourseController.findCourse(courses, nrc);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of findCourse method, of class CourseController.
     */
    @Test
    public void testFindCourseNrc() {
        System.out.println("findCourse");
        ArrayList<Course> courses = new ArrayList<>();
        courses.add(new Course("1", 4123));
        courses.add(new Course("2", 1496));
        courses.add(new Course("3", 1218));
        courses.add(new Course("4", 8898));
        int nrc = 1496;
        int expResult = 1;
        int result = CourseController.findCourse(courses, nrc);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of findCourse method, of class CourseController.
     */
    @Test
    public void testFindCourseNoNrc() {
        System.out.println("findCourse");
        ArrayList<Course> courses = new ArrayList<>();
        courses.add(new Course("1", 4123));
        courses.add(new Course("2", 1496));
        courses.add(new Course("3", 1218));
        courses.add(new Course("4", 8898));
        int nrc = -8498;
        int expResult = -1;
        int result = CourseController.findCourse(courses, nrc);
        assertEquals(expResult, result);
    }

    /**
     * Test of removeCourse method, of class CourseController.
     */
    @Test
    public void testRemoveCourse() {
        System.out.println("removeCourse");
        int courseNumber = -20;
        int expResult = 0;
        int result = CourseController.removeCourse(courseNumber);
        assertEquals(expResult, result);
    }
    
}
