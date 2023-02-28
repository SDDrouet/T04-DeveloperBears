package ec.edu.espe.inclass.controller;
import java.awt.Component;
import javax.swing.JTable;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author alejo
 */
public class PdfManagerTest {
    
    public PdfManagerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of createGradeRecord method, of class PdfManager.
     */
    @Test
    public void testCreateGradeRecord() {
        System.out.println("createGradeRecord");
        Component parent = null;
        JTable table = null;
        PdfManager.createGradeRecord(parent, table);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createAttendaceRecord method, of class PdfManager.
     */
    @Test
    public void testCreateAttendaceRecord() {
        System.out.println("createAttendaceRecord");
        Component parent = null;
        JTable table = null;
        PdfManager.createAttendaceRecord(parent, table);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createTutorshipRecord method, of class PdfManager.
     */
    @Test
    public void testCreateTutorshipRecord() {
        System.out.println("createTutorshipRecord");
        Component parent = null;
        JTable table = null;
        PdfManager.createTutorshipRecord(parent, table);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
