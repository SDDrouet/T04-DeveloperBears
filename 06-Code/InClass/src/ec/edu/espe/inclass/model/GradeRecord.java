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

    public GradeRecord() {
        units = new ArrayList<>();
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
    
    public void addUnit() {
        units.add(new Unit());
    }

    
    public float calculateFinalGrade() {
        float finalGrade;
        float sum = 0;
        int numberOfUnits = units.size();
        
        for (Unit unit : units) {            
            sum += unit.calculateUnitGrade();
        }
        
        finalGrade = sum / numberOfUnits;
        
        return finalGrade;
    }

}
