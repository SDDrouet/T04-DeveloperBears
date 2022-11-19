package ec.edu.espe.inclass.model;

import java.util.ArrayList;

/**
 *
 * @author Alexander Guaman, Developer Bears, DCCO-ESPE
 */
public class Course {

    private String name;
    private int nrc;
    private int studentNumber;
    private ArrayList<Student> students;
    private Tutorship tutorship;

    public Course() {
        name = "";
        nrc = 0;
        studentNumber = 0;
        students = new ArrayList<Student>();
        tutorship = new Tutorship();
    }

    public Course(String name, int nrc, int studentNumber, ArrayList<Student> students, int totalClassNumber, Tutorship tutorship) {
        this.name = name;
        this.nrc = nrc;
        this.studentNumber = studentNumber;
        this.students = students;
        this.tutorship = tutorship;
    }

}
