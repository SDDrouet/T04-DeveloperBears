package ec.edu.espe.inclass.model;

/**
 *
 * @author Alexander Guaman, Developer Bears, DCCO-ESPE
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
    }

    public Student(String name, String espeId, boolean isApproved, AttendanceRecord attendanceRecord, GradeRecord gradeRecord) {
        this.name = name;
        this.espeId = espeId;
        this.isApproved = isApproved;
        this.attendanceRecord = attendanceRecord;
        this.gradeRecord = gradeRecord;
    }

}
