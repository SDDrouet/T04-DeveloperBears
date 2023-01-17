package ec.edu.espe.inclass.controller;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import ec.edu.espe.inclass.model.Grade;
import ec.edu.espe.inclass.model.Student;
import java.util.ArrayList;

/**
 *
 * @author Alejandro Cuadrado, Developer Bears, DCCO-ESPE
 * @author Alexander Guaman, Developer Bears, DCCO-ESPE
 * @author Sheylee Enriquez, Developer Bears, DCCO-ESPE
 * @author Stephen Drouet, Developer Bears, DCCO-ESPE
 */
public class StudentController {

    public static String studentToJsonForDB(Student student, int courseNrc) {
        String json;
        Gson gson = new Gson();
        JsonParser parser = new JsonParser();

        json = gson.toJson(student);
        JsonElement jsonElement = parser.parse(json);
        JsonObject rootObject = jsonElement.getAsJsonObject();

        rootObject.addProperty("nrc", courseNrc);

        json = rootObject.toString();

        return json;
    }

    public static ArrayList loadStudents(ArrayList<String> jsons) {
        ArrayList<Student> students;
        students = new ArrayList<>();

        for (String json : jsons) {
            students.add(jsonToStudent(json));
        }

        return students;
    }

    public static Student jsonToStudent(String json) {
        Student student;
        Gson gson;
        gson = new Gson();
        String name = "";
        String espeId = "";
        student = new Student(name, espeId);

        student = gson.fromJson(json, student.getClass());

        return student;
    }

    public static int findStudent(ArrayList<Student> students, String id) {
        int index = -1;

        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getEspeId().equals(id)) {
                index = i;
                return index;
            }
        }

        return index;
    }

    public static float calculateAssistancePersetn(Student student) {
        float assistancePersent;
        int assistances = 0;

        student.getAttendanceRecord().setTotalClassNumber(student.getAttendanceRecord().getAttendance().size());
        for (Boolean dayAssistance : student.getAttendanceRecord().getAttendance()) {
            if (dayAssistance) {
                assistances++;
            }
        }

        assistancePersent = (float) assistances / (float) student.getAttendanceRecord().getTotalClassNumber();

        assistancePersent = Math.round(assistancePersent * 10000) / 100;

        return assistancePersent;
    }

    public static ArrayList<Float> getGradesUnit(Student student) {
        ArrayList<Float> studentsGrades;
        studentsGrades = new ArrayList<>();
        Grade homeworksGrades;
        Grade workshopsGrades;
        Grade testGrades;
        Grade examGrades;

        float unit1Grade;
        float unit2Grade;
        float unit3Grade;
        float average;

        homeworksGrades = student.getGradeRecord().getUnits().get(0).getHomeworks();
        workshopsGrades = student.getGradeRecord().getUnits().get(0).getWorkshops();
        testGrades = student.getGradeRecord().getUnits().get(0).getTests();
        examGrades = student.getGradeRecord().getUnits().get(0).getExam();
        unit1Grade = homeworksGrades.calculateGrade() + workshopsGrades.calculateGrade() + testGrades.calculateGrade() + examGrades.calculateGrade();

        homeworksGrades = student.getGradeRecord().getUnits().get(1).getHomeworks();
        workshopsGrades = student.getGradeRecord().getUnits().get(1).getWorkshops();
        testGrades = student.getGradeRecord().getUnits().get(1).getTests();
        examGrades = student.getGradeRecord().getUnits().get(1).getExam();
        unit2Grade = homeworksGrades.calculateGrade() + workshopsGrades.calculateGrade() + testGrades.calculateGrade() + examGrades.calculateGrade();

        homeworksGrades = student.getGradeRecord().getUnits().get(2).getHomeworks();
        workshopsGrades = student.getGradeRecord().getUnits().get(2).getWorkshops();
        testGrades = student.getGradeRecord().getUnits().get(2).getTests();
        examGrades = student.getGradeRecord().getUnits().get(2).getExam();
        unit3Grade = homeworksGrades.calculateGrade() + workshopsGrades.calculateGrade() + testGrades.calculateGrade() + examGrades.calculateGrade();

        average = (unit1Grade + unit2Grade + unit3Grade) / 3;
        studentsGrades.add(unit1Grade);
        studentsGrades.add(unit2Grade);
        studentsGrades.add(unit3Grade);
        studentsGrades.add(average);

        return studentsGrades;
    }
    
    public static boolean verifyAttendancePesent(float assistancePersent) {
        boolean isAproved = true;
        
        if (assistancePersent < 70) {
            isAproved = false;
        }
        
        return isAproved;
    }

}
