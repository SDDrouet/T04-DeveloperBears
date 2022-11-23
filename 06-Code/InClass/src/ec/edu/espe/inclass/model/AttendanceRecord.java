package ec.edu.espe.inclass.model;

import java.util.ArrayList;

/**
 *
 * @author Alejandro Cuadrado, Developer Bears, DCCO-ESPE
 * @author Alexander Guaman, Developer Bears, DCCO-ESPE
 * @author Sheylee Enriquez, Developer Bears, DCCO-ESPE
 * @author Stephen Drouet, Developer Bears, DCCO-ESPE
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

    /**
     * @return the attendanceNumber
     */
    public int getAttendanceNumber() {
        return attendanceNumber;
    }

    /**
     * @param attendanceNumber the attendanceNumber to set
     */
    public void setAttendanceNumber(int attendanceNumber) {
        this.attendanceNumber = attendanceNumber;
    }

    /**
     * @return the totalClassNumber
     */
    public int getTotalClassNumber() {
        return totalClassNumber;
    }

    /**
     * @param totalClassNumber the totalClassNumber to set
     */
    public void setTotalClassNumber(int totalClassNumber) {
        this.totalClassNumber = totalClassNumber;
    }
    

}
