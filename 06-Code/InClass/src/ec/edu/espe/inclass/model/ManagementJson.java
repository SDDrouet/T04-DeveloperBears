/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.inclass.model;

import com.google.gson.Gson;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

/**
 *
 * @author Sheylee Enriquez, Developer Bears, DCCO-ESPE
 */
public class ManagementJson {

    Teacher teacher;

    public ManagementJson(Teacher teacher) {
        this.teacher = teacher;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public void saveTeacher() {
        Gson gson = new Gson();
        String json;

        json = gson.toJson(teacher);
        File file = new File("./teacher.json");

        try ( FileWriter fw = new FileWriter(file);) {
            fw.write(json);
            System.out.println("----------File was saved----------");
        } catch (Exception e) {
            System.out.println("Error: File not open or found");
        }
        System.out.println(teacher.getCourses().get(0));
    }

    private void saveCourses() {
        String json;
        json = teacher.getCoursesJson();
        File file = new File("./courses.json");
        try ( FileWriter fw = new FileWriter(file);) {
            fw.write(json);
            System.out.println("----------File was saved----------");
        } catch (Exception e) {
            System.out.println("Error: File not open or found");
        }
    }

    private void saveStudents() {
        String json = "[";
        for (Course course : teacher.getCourses()) {
            json += course.getStudentsJson() + ",";
        }
        json += "]";
        File file = new File("./students.json");
        try ( FileWriter fw = new FileWriter(file);) {
            fw.write(json);
            System.out.println("----------File was saved----------");
        } catch (Exception e) {
            System.out.println("Error: File not open or found");
        }
    }

    private void saveTutorships() {
        String json;
        json = teacher.saveTutorshipsJson();
        File file = new File("./tutorships.json");
        try ( FileWriter fw = new FileWriter(file);) {
            fw.write(json);
            System.out.println("----------File was saved----------");
        } catch (Exception e) {
            System.out.println("Error: File not open or found");
        }
    }

    public void saveInClassInfo() {
        saveGradeRecord();
        saveAttendanceRecord();
        saveStudents();
        saveCourses();
        saveTutorships();
        saveTeacher();

    }

    private void saveAttendanceRecord() {
        String json = "[";
        for (Course course : teacher.getCourses()) {
            for (Student student : course.getStudents()) {
                json += student.saveAttendanceRecordJson() + ",";
            }
        }

        json += "]";

        File file = new File("./attendanceRecord.json");
        try ( FileWriter fw = new FileWriter(file);) {
            fw.write(json);
            System.out.println("----------File was saved----------");
        } catch (Exception e) {
            System.out.println("Error: File not open or found");
        }
    }

    private void saveGradeRecord() {
        String json = "[";
        for (Course course : teacher.getCourses()) {
            for (Student student : course.getStudents()) {
                json += student.saveGradeRecordJson() + ",";
            }
        }

        json += "]";

        File file = new File("./gradeRecord.json");
        try ( FileWriter fw = new FileWriter(file);) {
            fw.write(json);
            System.out.println("----------File was saved----------");
        } catch (Exception e) {
            System.out.println("Error: File not open or found");
        }
    }

    private Teacher loadTeacher() {
        Gson gson = new Gson();

        Teacher newTeacher = new Teacher();
        String jsonFile = "";

        try ( Scanner scFile = new Scanner(new File("./teacher.json"))) {
            while (scFile.hasNextLine()) {
                jsonFile += scFile.nextLine();
            }

            newTeacher = gson.fromJson(jsonFile, Teacher.class);

            System.out.println("----------File was loaded----------");
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Error: File not open or found");
        }

        return newTeacher;
    }

    private Course loadCourses() {
        Gson gson = new Gson();

        Course newCourse = new Course();
        String jsonFile = "";

        try ( Scanner scFile = new Scanner(new File("./courses.json"))) {
            while (scFile.hasNextLine()) {
                jsonFile += scFile.nextLine();
            }

            newCourse = gson.fromJson(jsonFile, Course.class);

            System.out.println("----------File was loaded----------");
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Error: File not open or found");
        }

        return newCourse;
    }

    private Student loadStudents() {
        Gson gson = new Gson();

        Student newStudent = new Student();
        String jsonFile = "";

        try ( Scanner scFile = new Scanner(new File("./students.json"))) {
            while (scFile.hasNextLine()) {
                jsonFile += scFile.nextLine();
            }

            newStudent = gson.fromJson(jsonFile, Student.class);

            System.out.println("----------File was loaded----------");
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Error: File not open or found");
        }

        return newStudent;
    }

    public Teacher loadInClassInfo(){
        loadCourses();
        loadStudents();
        loadTutorships();
        loadAttendanceRecord();
        loadGradeRecord();
        return loadTeacher();
    }
    
    private Tutorship loadTutorships() {
        Gson gson = new Gson();

        Tutorship newTutorship = new Tutorship();
        String jsonFile = "";

        try ( Scanner scFile = new Scanner(new File("./tutorships.json"))) {
            while (scFile.hasNextLine()) {
                jsonFile += scFile.nextLine();
            }

            newTutorship = gson.fromJson(jsonFile, Tutorship.class);

            System.out.println("----------File was loaded----------");
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Error: File not open or found");
        }

        return newTutorship;
    }

    private AttendanceRecord loadAttendanceRecord() {
        Gson gson = new Gson();

        AttendanceRecord newAttendanceRecord = new AttendanceRecord();
        String jsonFile = "";

        try ( Scanner scFile = new Scanner(new File("./attendanceRecord.json"))) {
            while (scFile.hasNextLine()) {
                jsonFile += scFile.nextLine();
            }

            newAttendanceRecord = gson.fromJson(jsonFile, AttendanceRecord.class);

            System.out.println("----------File was loaded----------");
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Error: File not open or found");
        }

        return newAttendanceRecord;
    }

    private GradeRecord loadGradeRecord() {
        Gson gson = new Gson();

        GradeRecord newGradeRecord = new GradeRecord();
        String jsonFile = "";

        try ( Scanner scFile = new Scanner(new File("./gradeRecord.json"))) {
            while (scFile.hasNextLine()) {
                jsonFile += scFile.nextLine();
            }

            newGradeRecord = gson.fromJson(jsonFile, GradeRecord.class);

            System.out.println("----------File was loaded----------");
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Error: File not open or found");
        }

        return newGradeRecord;
    }
}
