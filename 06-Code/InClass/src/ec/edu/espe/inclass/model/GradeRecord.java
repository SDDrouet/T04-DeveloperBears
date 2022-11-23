package ec.edu.espe.inclass.model;

import java.util.ArrayList;

/**
 *
 * @author Alejandro Cuadrado, Developer Bears, DCCO-ESPE
 * @author Alexander Guaman, Developer Bears, DCCO-ESPE
 * @author Sheylee Enriquez, Developer Bears, DCCO-ESPE
 * @author Stephen Drouet, Developer Bears, DCCO-ESPE
 */
public class GradeRecord {

    private ArrayList<Unit> units;
    private float finalGrade;

    public GradeRecord() {
        units = new ArrayList<>();
        finalGrade = 0;
    }

    public GradeRecord(ArrayList<Unit> units, float finalGrade) {
        this.units = units;
        this.finalGrade = finalGrade;
    }

    /**
     * @return the units
     */
    public ArrayList<Unit> getUnits() {
        return units;
    }

    /**
     * @param units the units to set
     */
    public void setUnits(ArrayList<Unit> units) {
        this.units = units;
    }

    /**
     * @return the finalGrade
     */
    public float getFinalGrade() {
        return finalGrade;
    }

    /**
     * @param finalGrade the finalGrade to set
     */
    public void setFinalGrade(float finalGrade) {
        this.finalGrade = finalGrade;
    }

}
