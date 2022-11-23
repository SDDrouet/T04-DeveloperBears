package ec.edu.espe.inclass.model;

import java.util.ArrayList;

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
    private int studentNumber;
    private ArrayList<Student> students;
    private Tutorship tutorship;

    public Course() {
        name = "";
        nrc = 0;
        studentNumber = 0;
        students = new ArrayList<>();
        tutorship = new Tutorship();
    }

    public Course(String name, int nrc, int studentNumber, ArrayList<Student> students, int totalClassNumber, Tutorship tutorship) {
        this.name = name;
        this.nrc = nrc;
        this.studentNumber = studentNumber;
        this.students = students;
        this.tutorship = tutorship;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the nrc
     */
    public int getNrc() {
        return nrc;
    }

    /**
     * @param nrc the nrc to set
     */
    public void setNrc(int nrc) {
        this.nrc = nrc;
    }

    /**
     * @return the studentNumber
     */
    public int getStudentNumber() {
        return studentNumber;
    }

    /**
     * @param studentNumber the studentNumber to set
     */
    public void setStudentNumber(int studentNumber) {
        this.studentNumber = studentNumber;
    }

    /**
     * @return the students
     */
    public ArrayList<Student> getStudents() {
        return students;
    }

    /**
     * @param students the students to set
     */
    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    /**
     * @return the tutorship
     */
    public Tutorship getTutorship() {
        return tutorship;
    }

    /**
     * @param tutorship the tutorship to set
     */
    public void setTutorship(Tutorship tutorship) {
        this.tutorship = tutorship;
    }
    
    

}
