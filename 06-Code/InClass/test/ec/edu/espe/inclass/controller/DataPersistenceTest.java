package ec.edu.espe.inclass.controller;

import ec.edu.espe.inclass.model.Course;
import ec.edu.espe.inclass.model.Teacher;
import org.junit.Test;
import static org.junit.Assert.*;
import utils.DBManager;

/**
 *
 * @author Stephen Drouet, Developer Bears, DCC-ESPE
 */
public class DataPersistenceTest {
    
    public DataPersistenceTest() {
    }
    
    /**
     * Test of connectMongoDB method, of class DataPersistence.
     */
    @Test
    public void testConnectMongoDB() {
        System.out.println("connectMongoDB");
        DataPersistence instance = DataPersistence.getInstance();
        boolean expResult = true;
        boolean result = instance.connectMongoDB();
        assertEquals(expResult, result);
    }

    /**
     * Test of updateData method, of class DataPersistence.
     */
    @Test
    public void testUpdateDataOffLine() {
        System.out.println("updateData");
        DataPersistence instance = DataPersistence.getInstance();
        boolean expResult = true;
        boolean result = instance.updateData();
        assertEquals(expResult, result);
    }

    /**
     * Test of updateStudentsInDB method, of class DataPersistence.
     */
    @Test
    public void testUpdateStudentsInDBOnline() {
        System.out.println("updateStudentsInDB");      
        Course course = null;        
        DataPersistence instance = DataPersistence.getInstance();    
        instance.connectMongoDB();
        boolean expResult = true;
        boolean result = instance.updateStudentsInDB(course);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of updateStudentsInDB method, of class DataPersistence.
     */
    @Test
    public void testUpdateStudentsInDBOffline() {
        System.out.println("updateStudentsInDB");
        Course course = null;
        DataPersistence instance = DataPersistence.getInstance();
        boolean expResult = false;
        boolean result = instance.updateStudentsInDB(course);
        assertEquals(expResult, result);
    }
    
}
