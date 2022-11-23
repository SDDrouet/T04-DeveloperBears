package ec.edu.espe.inclass.model;

import java.util.ArrayList;

/**
 *
 * @author Alejandro Cuadrado, Developer Bears, DCCO-ESPE
 * @author Alexander Guaman, Developer Bears, DCCO-ESPE
 * @author Sheylee Enriquez, Developer Bears, DCCO-ESPE
 * @author Stephen Drouet, Developer Bears, DCCO-ESPE
 */
public class Grade {

    private ArrayList<Double> gradeValues;
    private float totalGradePercent;

    public Grade() {
        gradeValues = new ArrayList<>();
        totalGradePercent = 0;
    }

    public Grade(ArrayList<Double> gradeValues, float totalGradePercent) {
        this.gradeValues = gradeValues;
        this.totalGradePercent = totalGradePercent;
    }

    /**
     * @return the gradeValues
     */
    public ArrayList<Double> getGradeValues() {
        return gradeValues;
    }

    /**
     * @param gradeValues the gradeValues to set
     */
    public void setGradeValues(ArrayList<Double> gradeValues) {
        this.gradeValues = gradeValues;
    }

    /**
     * @return the totalGradePercent
     */
    public float getTotalGradePercent() {
        return totalGradePercent;
    }

    /**
     * @param totalGradePercent the totalGradePercent to set
     */
    public void setTotalGradePercent(float totalGradePercent) {
        this.totalGradePercent = totalGradePercent;
    }

}
