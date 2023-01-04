package ec.edu.espe.inclass.controller;

import com.google.gson.Gson;
import ec.edu.espe.inclass.model.Teacher;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

/**
 *
 * @author Alejandro Cuadrado, Developer Bears, DCCO-ESPE
 * @author Alexander Guaman, Developer Bears, DCCO-ESPE
 * @author Sheylee Enriquez, Developer Bears, DCCO-ESPE
 * @author Stephen Drouet, Developer Bears, DCCO-ESPE
 */
public class ManagementJson {

    Teacher teacher;

    public ManagementJson(Teacher teacher) {
        this.teacher = teacher;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher1) {
        this.teacher = teacher1;
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

        int coursesSize = teacher.getCourses().size();
        for (int i = 0; i < coursesSize; i++) {

            if (i == coursesSize - 1) {
                json += teacher.getCourses().get(i).getStudentsJson();
            } else {
                json += teacher.getCourses().get(i).getStudentsJson() + ",";
            }

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
        int coursesSize = teacher.getCourses().size();
        int studentsSize;
        for (int i = 0; i < coursesSize; i++) {
            studentsSize = teacher.getCourses().get(i).getStudents().size();
            for (int j = 0; j < studentsSize; j++) {
                if (i == coursesSize - 1 && j == studentsSize - 1) {
                    json += teacher.getCourses().get(i).getStudents().get(j).saveAttendanceRecordJson();
                } else {
                    json += teacher.getCourses().get(i).getStudents().get(j).saveAttendanceRecordJson() + ",";
                }
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

        int coursesSize = teacher.getCourses().size();
        int studentsSize;
        for (int i = 0; i < coursesSize; i++) {
            studentsSize = teacher.getCourses().get(i).getStudents().size();
            for (int j = 0; j < studentsSize; j++) {
                if (i == coursesSize - 1 && j == studentsSize - 1) {
                    json += teacher.getCourses().get(i).getStudents().get(j).saveGradeRecordJson();
                } else {
                    json += teacher.getCourses().get(i).getStudents().get(j).saveGradeRecordJson() + ",";
                }
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

    private void loadTeacher() {
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
        teacher = newTeacher;
    }

    private String loadCourses() {
        String jsonFile = "";

        try ( Scanner scFile = new Scanner(new File("./courses.json"))) {
            while (scFile.hasNextLine()) {
                jsonFile += scFile.nextLine();
            }

            System.out.println("----------File was loaded----------");
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Error: File not open or found");
        }

        return jsonFile;
    }

    private String loadStudents() {
        String jsonFile = "";

        try ( Scanner scFile = new Scanner(new File("./students.json"))) {
            while (scFile.hasNextLine()) {
                jsonFile += scFile.nextLine();
            }

            System.out.println("----------File was loaded----------");
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Error: File not open or found");
        }

        return jsonFile;
    }

    public void loadInClassInfo() {
        loadCourses();
        loadStudents();
        loadTutorships();
        loadAttendanceRecord();
        loadGradeRecord();
        loadTeacher();
    }

    private String loadTutorships() {

        String jsonFile = "";

        try ( Scanner scFile = new Scanner(new File("./tutorships.json"))) {
            while (scFile.hasNextLine()) {
                jsonFile += scFile.nextLine();
            }

            System.out.println("----------File was loaded----------");
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Error: File not open or found");
        }

        return jsonFile;
    }

    private String loadAttendanceRecord() {
        String jsonFile = "";

        try ( Scanner scFile = new Scanner(new File("./attendanceRecord.json"))) {
            while (scFile.hasNextLine()) {
                jsonFile += scFile.nextLine();
            }

            System.out.println("----------File was loaded----------");
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Error: File not open or found");
        }

        return jsonFile;
    }

    private String loadGradeRecord() {
        String jsonFile = "";

        try ( Scanner scFile = new Scanner(new File("./gradeRecord.json"))) {
            while (scFile.hasNextLine()) {
                jsonFile += scFile.nextLine();
            }

            System.out.println("----------File was loaded----------");
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Error: File not open or found");
        }

        return jsonFile;
    }
}
