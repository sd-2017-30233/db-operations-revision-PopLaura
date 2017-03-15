/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sc;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author maria
 */
public class JUnitTest {
    SC test=new SC();
    boolean output;
    @Test
    public void ConnectionTest()
    {
        MySqlConnect conntest=new MySqlConnect();
        boolean output=conntest.connect();
        assertEquals(null,true, output);
    }
    //Students
    @Test
    public void AddStudentsTest() {
        output=test.addStudents();
        assertEquals(null,true,output);
    }
    
    @Test
    public void ListStudentsTest() {
        output=test.listStudents();
        assertEquals(null,true,output);
    }
    @Test
    public void DeleteStudentsTest() {
        output=test.deleteStudent();
        assertEquals(null,true,output);
    }
    @Test
    public void UpdateStudentsTest() {
        output=test.updateStudents();
        assertEquals(null,true,output);
    }
    //Courses
    @Test
    public void AddCoursesTest() {
        output=test.addCourse();
        assertEquals(null,true,output);
    }
    
    @Test
    public void ListCoursesTest() {
        output=test.listCourse();
        assertEquals(null,true,output);
    }
    @Test
    public void DeleteCoursesTest() {
        output=test.deleteCourse();
        assertEquals(null,true,output);
    }
    @Test
    public void UpdateCoursesTest() {
        output=test.updateCourse();
        assertEquals(null,true,output);
    }
    //SC
    @Test
    public void addStudentsToCourses() {
        output=test.addStudentsToCourses();
        assertEquals(null,true,output);
    }
    @Test
    public void listStudentstoCourse() {
        output=test.listStudentstoCourse();
        assertEquals(null,true,output);
    }
    

    
}
