package ec.edu.espe.inclass.model;

import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Alejandro Cuadrado, Developer Bears, DCCO-ESPE
 * @author Alexander Guaman, Developer Bears, DCCO-ESPE
 * @author Sheylee Enriquez, Developer Bears, DCCO-ESPE
 * @author Stephen Drouet, Developer Bears, DCCO-ESPE
 */
public class Course {

    private String name;
    private int nrc;
    private ArrayList<Student> students;

    public Course() {
        name = "";
        nrc = 0;
        students = new ArrayList<>();
    }

    public Course(String name, int nrc) {
        this.name = name;
        this.nrc = nrc;
        this.students = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Course{" + "name=" + name + ", nrc=" + nrc + '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNrc() {
        return nrc;
    }

    public void setNrc(int nrc) {
        this.nrc = nrc;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public void addStudent() {

        Student newStudent = new Student();

        String name;
        String espeId;

        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Student name: ");
            name = sc.nextLine();
            System.out.print("Student ID: ");
            espeId = sc.nextLine();

            newStudent.setName(name);
            newStudent.setEspeId(espeId);

            students.add(newStudent);
        } catch (Exception e) {
            System.out.println("Error! You should verify the information entered :)");
        }
    }

    public String getStudentsJson() {
        Gson gson = new Gson();
        String json = gson.toJson(students);

        return json;
    }
    
}
