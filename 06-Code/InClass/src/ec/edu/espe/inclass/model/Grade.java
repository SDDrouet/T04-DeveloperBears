package ec.edu.espe.inclass.model;

import java.util.ArrayList;

/**
 *
 * @author Alexander Guaman, Developer Bears, DCCO-ESPE
 */
public class Grade {

    private ArrayList<Double> gradeValues;
    private float totalGradePercent;

    public Grade() {
        gradeValues = new ArrayList<Double>();
        totalGradePercent = 0;
    }

    public Grade(ArrayList<Double> gradeValues, float totalGradePercent) {
        this.gradeValues = gradeValues;
        this.totalGradePercent = totalGradePercent;
    }

}
