package ec.edu.espe.inclass.model;

import java.util.ArrayList;

/**
 *
 * @author Alexander Guaman, Developer Bears, DCCO-ESPE
 */
public class GradeRecord {

    private ArrayList<Unit> units;
    private float finalGrade;

    public GradeRecord() {
        units = new ArrayList<Unit>();
        finalGrade = 0;
    }

    public GradeRecord(ArrayList<Unit> units, float finalGrade) {
        this.units = units;
        this.finalGrade = finalGrade;
    }

}
