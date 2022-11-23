package ec.edu.espe.inclass.model;

/**
 *
 * @author Alejandro Cuadrado, Developer Bears, DCCO-ESPE
 * @author Alexander Guaman, Developer Bears, DCCO-ESPE
 * @author Sheylee Enriquez, Developer Bears, DCCO-ESPE
 * @author Stephen Drouet, Developer Bears, DCCO-ESPE
 */
public class Student {

    private String name;
    private String espeId;
    private boolean isApproved;
    private AttendanceRecord attendanceRecord;
    private GradeRecord gradeRecord;

    public Student() {
        name = "";
        espeId = "";
        isApproved = false;
        attendanceRecord = new AttendanceRecord();
        gradeRecord = new GradeRecord();
    }

    public Student(String name, String espeId, boolean isApproved, AttendanceRecord attendanceRecord, GradeRecord gradeRecord) {
        this.name = name;
        this.espeId = espeId;
        this.isApproved = isApproved;
        this.attendanceRecord = attendanceRecord;
        this.gradeRecord = gradeRecord;
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
     * @return the espeId
     */
    public String getEspeId() {
        return espeId;
    }

    /**
     * @param espeId the espeId to set
     */
    public void setEspeId(String espeId) {
        this.espeId = espeId;
    }

    /**
     * @return the isApproved
     */
    public boolean isIsApproved() {
        return isApproved;
    }

    /**
     * @param isApproved the isApproved to set
     */
    public void setIsApproved(boolean isApproved) {
        this.isApproved = isApproved;
    }

    /**
     * @return the attendanceRecord
     */
    public AttendanceRecord getAttendanceRecord() {
        return attendanceRecord;
    }

    /**
     * @param attendanceRecord the attendanceRecord to set
     */
    public void setAttendanceRecord(AttendanceRecord attendanceRecord) {
        this.attendanceRecord = attendanceRecord;
    }

    /**
     * @return the gradeRecord
     */
    public GradeRecord getGradeRecord() {
        return gradeRecord;
    }

    /**
     * @param gradeRecord the gradeRecord to set
     */
    public void setGradeRecord(GradeRecord gradeRecord) {
        this.gradeRecord = gradeRecord;
    }
    
    

}
