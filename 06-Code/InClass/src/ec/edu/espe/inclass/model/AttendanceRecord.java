package ec.edu.espe.inclass.model;

import java.util.ArrayList;

/**
 *
 * @author Alexander Guaman, Developer Bears, DCCO-ESPE
 */
public class AttendanceRecord {

    private int attendanceNumber;
    private int totalClassNumber;

    public AttendanceRecord() {
        attendanceNumber = 0;
        totalClassNumber = 0;
    }

    public AttendanceRecord(int attendanceNumber, int totalClassNumber) {
        this.attendanceNumber = attendanceNumber;
        this.totalClassNumber = totalClassNumber;
    }

}
