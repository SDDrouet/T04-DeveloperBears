package ec.edu.espe.inclass.model;

/**
 *
 * @author Alejandro Cuadrado, Developer Bears, DCCO-ESPE
 * @author Alexander Guaman, Developer Bears, DCCO-ESPE
 * @author Sheylee Enriquez, Developer Bears, DCCO-ESPE
 * @author Stephen Drouet, Developer Bears, DCCO-ESPE
 */
public class Unit {

    private Grade workshops;
    private Grade homeworks;
    private Grade tests;
    private Grade exam;
    private float unitGrade;

    public Unit() {
        workshops = new Grade();
        homeworks = new Grade();
        tests = new Grade();
        exam = new Grade();
        unitGrade = 0;
    }

    public Unit(Grade workshops, Grade homeworks, Grade tests, Grade exam, float unitGrade) {
        this.workshops = workshops;
        this.homeworks = homeworks;
        this.tests = tests;
        this.exam = exam;
        this.unitGrade = unitGrade;
    }

    /**
     * @return the workshops
     */
    public Grade getWorkshops() {
        return workshops;
    }

    /**
     * @param workshops the workshops to set
     */
    public void setWorkshops(Grade workshops) {
        this.workshops = workshops;
    }

    /**
     * @return the homeworks
     */
    public Grade getHomeworks() {
        return homeworks;
    }

    /**
     * @param homeworks the homeworks to set
     */
    public void setHomeworks(Grade homeworks) {
        this.homeworks = homeworks;
    }

    /**
     * @return the tests
     */
    public Grade getTests() {
        return tests;
    }

    /**
     * @param tests the tests to set
     */
    public void setTests(Grade tests) {
        this.tests = tests;
    }

    /**
     * @return the exam
     */
    public Grade getExam() {
        return exam;
    }

    /**
     * @param exam the exam to set
     */
    public void setExam(Grade exam) {
        this.exam = exam;
    }

    /**
     * @return the unitGrade
     */
    public float getUnitGrade() {
        return unitGrade;
    }

    /**
     * @param unitGrade the unitGrade to set
     */
    public void setUnitGrade(float unitGrade) {
        this.unitGrade = unitGrade;
    }

}
