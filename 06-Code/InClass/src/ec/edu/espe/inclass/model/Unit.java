package ec.edu.espe.inclass.model;

/**
 *
 * @author Alexander Guaman, Developer Bears, DCCO-ESPE
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

}
