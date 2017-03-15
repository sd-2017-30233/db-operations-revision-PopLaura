/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sc;
import java.sql.*;
import java.io.*;
import java.lang.Integer;
import java.lang.Double;
import java.util.Scanner;
import java.sql.Connection;
import static java.sql.DriverManager.println;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
/**
 *
 * @author maria
 */
public class SC {

    /**
     * @param args the command line arguments
     */
    //citire din consola
    Scanner reader = new Scanner(System.in);
        
    //mySQL
    MySqlConnect conn = MySqlConnect.getInstance();
    PreparedStatement pst = null;
    ResultSet rs = null;
    int res;
    //Afisare meniu
    public void meniu()
    {
       System.out.println("\n\nSelectati una dintre optiuni");
       System.out.println("1-Adaugati un student");
       System.out.println("2-Afisati studentii");
       System.out.println("3-Stergeti un studenta");
       System.out.println("4-Actualizati un studenta");
       System.out.println("5-Adaugati un curs");
       System.out.println("6-Afisati cursurile");
       System.out.println("7-Stergeti un curs");
       System.out.println("8-Actualizati un curs");
       System.out.println("9-Adaugati un student la curs");
       System.out.println("10-Afisati studentii care participa la un anumit curs");
       System.out.println("X-pentru iesire");
       System.out.println("Alegerea:");
            
    }
    //---------------------------------Studenti--------------------------------------------------------
    //1-Adaugati un student
    public boolean addStudents()
    {
       String name = null;
       String birth_date=null;
       String address=null;
       System.out.print("Dati numele studentului:");
       while(reader.hasNextLine())
       {
            name=reader.nextLine();
       }
       System.out.print("Dati data de nastere a studentului:");
       while(reader.hasNextLine())
       {
            birth_date=reader.nextLine();
       }
       System.out.print("Dati adresa studentului:");
       while(reader.hasNextLine())
       {
            address=reader.nextLine();
       }
       try {
           String Sql = "INSERT INTO 	students (nume, birth, address) VALUES ('" +name+ "', '"+birth_date+"', '"+address+"')"; 
           res = conn.update(Sql);
           return true;
                
            }
       catch(Exception ex) {
            System.out.print("Eroare");
            return false;
             //JOptionPane.showMessageDialog(null, ex);
            } 
    }
    //2-Afisati studentii
    public boolean listStudents()
    {
        try{
            String Sql="Select * from students";
            rs=conn.get(Sql);
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            System.out.println("Id       Nume       Data Nasterii        Adresa");
            while (rs.next()) {
                for(int i = 1; i < columnsNumber+1; i++)
                System.out.print(rs.getString(i) + "           ");
                System.out.println();
                     }
            return true;
            }
        catch(Exception ex) {
            System.out.print("Eroare");
            return false;
             //JOptionPane.showMessageDialog(null, ex);
                    }
    }
    //3-Stergeti un studenta
    public boolean deleteStudent()
    {
        String id=null;
        System.out.println("Dati id-ul studentului pe care vreti sa il stergeti");
        while(reader.hasNextLine())
       {
            id=reader.nextLine();
       }
        try{
            String Sql;
            Sql="DELETE FROM `sc` WHERE `sc`.`id_student` = '"+id+"'";
            res = conn.update(Sql);
            Sql="DELETE FROM `students` WHERE `students`.`id_student` = '"+id+"'";
            res = conn.update(Sql);
            return true;
            }
        catch(Exception ex) {
            System.out.print("Eroare");
            return false;
             //JOptionPane.showMessageDialog(null, ex);
                    }
    }
    //4-Actualizati un studenta
    public boolean updateStudents()
    {
        String id=null;
        String name=null;
        String birth_date=null;
        String address=null;
        System.out.println("Dati id-ul studentului pe care vreti sa il actualizati");
        while(reader.hasNextLine())
       {
            id=reader.nextLine();
       }
        
        System.out.print("Dati numele studentului:");
        while(reader.hasNextLine())
       {
            name=reader.nextLine();
       }
        
        System.out.print("Dati data de nastere a studentului:");
        while(reader.hasNextLine())
       {
            birth_date=reader.nextLine();
       }
        
        System.out.print("Dati adresa studentului:");
        while(reader.hasNextLine())
       {
            address=reader.nextLine();
       }
        try
        {
            String Sql="UPDATE students SET nume='"+name+"',birth='"+birth_date+"',address='"+address+"' WHERE id_student='"+id+"';";
            res = conn.update(Sql);
            return true;
            
        }
        catch(Exception ex) {
            System.out.print("Eroare");
            return false;
             //JOptionPane.showMessageDialog(null, ex);
                    }
        
    }
    //---------------------------------Cursuri--------------------------------------------------------
    //5-Adaugati un curs
    public boolean addCourse()
    {
       String name=null;
       String teacher=null;
       String study_year=null;
       System.out.print("Dati numele cursului:");
       while(reader.hasNextLine())
       {
            name=reader.nextLine();
       }
       System.out.print("Dati numele profesorului care tine cursul:");
       while(reader.hasNextLine())
       {
            teacher=reader.nextLine();
       }
       System.out.print("Dati anul:");
       while(reader.hasNextLine())
       {
            study_year=reader.nextLine();
       }
       try {
           String Sql = "INSERT INTO course (nume, teacher, study_year) VALUES ('" +name+ "', '"+teacher+"', '"+study_year+"')"; 
           res = conn.update(Sql);
           return true;
            }
       catch(Exception ex) {
            System.out.print("Eroare");
            return false;
             //JOptionPane.showMessageDialog(null, ex);
            } 
    }
    //6-Afisati cursurile
    public boolean listCourse()
    {
        try{
            
            String Sql="Select * from course";
            rs=conn.get(Sql);
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            System.out.println("Id       Nume       Profesor        An");
            while (rs.next()) {
                for(int i = 1; i < columnsNumber+1; i++)
                    System.out.print(rs.getString(i) + "           ");
                System.out.println();
                    }
            return true;
            }
        catch(Exception ex) {
            System.out.print("Eroare");
            return false;
             //JOptionPane.showMessageDialog(null, ex);
                    }
    }
    //7-Stergeti un curs
    public boolean deleteCourse()
    {
        String id=null;
        System.out.println("Dati id-ul cursului pe care vreti sa il stergeti");
        while(reader.hasNextLine())
       {
            id=reader.nextLine();
       }
        try{
            String Sql;
            Sql="DELETE FROM `sc` WHERE `sc`.`id_course` = '"+id+"'";
            res = conn.update(Sql);
            Sql="DELETE FROM `course` WHERE `course`.`id_course` = '"+id+"'";
            res = conn.update(Sql);
            return true;
            }
        catch(Exception ex) {
            System.out.print("Eroare");
             return false;
             //JOptionPane.showMessageDialog(null, ex);
                    }
    }
    //8-Actualizati un curs
    public boolean updateCourse()
    {
        String id=null;
        String name=null;
        String teacher=null;
        String study_year=null;
        System.out.println("Dati id-ul cursului pe care vreti sa il actualizati");
        while(reader.hasNextLine())
       {
            id=reader.nextLine();
       }
        System.out.print("Dati numele cursului:");
        while(reader.hasNextLine())
       {
            name=reader.nextLine();
       }
        System.out.print("Dati numele profesorului care tine cursul:");
        while(reader.hasNextLine())
       {
            teacher=reader.nextLine();
       }
        System.out.print("Dati anul:");
        while(reader.hasNextLine())
       {
            study_year=reader.nextLine();
       }
        try
        {
            String Sql="UPDATE course SET nume='"+name+"',teacher='"+teacher+"',study_year='"+study_year+"' WHERE id_course='"+id+"';";
            res = conn.update(Sql);
            return true;
            
        }
        catch(Exception ex) {
            System.out.print("Eroare");
             return false;   
             //JOptionPane.showMessageDialog(null, ex);
                    }
    }
    //---------------------------------SC--------------------------------------------------------
    //9-Adaugati un student la curs
    public boolean addStudentsToCourses()
    {
        String id_student=null;
        String id_course=null;
        System.out.println("Dati id-ul studentului pe care vreti sa il adaugati la curs");
        while(reader.hasNextLine())
       {
            id_student=reader.nextLine();
       }
        System.out.println("Dati id-ul cursului la care vreti sa fie adaugat studentul");
        while(reader.hasNextLine())
       {
            id_course=reader.nextLine();
       }
        try
        {
            String Sql="INSERT INTO sc (id_student, id_course) VALUES ('" +id_student+ "', '"+id_course+"')";
            res=conn.update(Sql);
            return true;
            
        }
        catch(Exception ex)
                {
                    System.out.print("Eroare");
                    return false;
                }
    }
    //10-Afisati studentii care participa la un anumit curs
    public boolean listStudentstoCourse()
    {
        System.out.println("Dati id-ul cursului la care vreti sa fie afisati studentii:");
        String id=null;
        while(reader.hasNextLine())
       {
            id=reader.nextLine();
       }
        try
        {
            String Sql="SELECT s.nume FROM students s, sc WHERE s.id_student=sc.id_student AND sc.id_course='"+id+"'";
            rs=conn.get(Sql);
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            System.out.println("Nume");
            while (rs.next()) {
                for(int i = 1; i < columnsNumber+1; i++)
                    System.out.print(rs.getString(i) + "           ");
                System.out.println();
                    }
            return true;
        }
        catch(Exception ex)
                {
                    System.out.print("Eroare");
                    return false;
                }
    }
    public static void main(String[] args) {
        
        Scanner reader = new Scanner(System.in);
        //meniu
        String choice="1";
        SC app=new SC();
  
        while(!choice.equals("x"))
        { 
            app.meniu();
            choice=reader.nextLine(); 
            //---------------------------------Studenti--------------------------------------------------------
            //1-Adaugati un student
            if(choice.equals("1"))
            {
                app.addStudents();
                app.listStudents();
            }
            
            //2-Afisati studentii
            if(choice.equals("2"))
            {
                app.listStudents();
            }
            
            //3-Stergeti un studenta
            if(choice.equals("3"))
            {
                app.deleteStudent();
                app.listStudents();
            }
            //4-Actualizati un studenta
            if(choice.equals("4"))
            {
                app.updateStudents();
                app.listStudents();
            }
            //---------------------------------Cursuri--------------------------------------------------------
            //5-Adaugati un curs
            if(choice.equals("5"))
            {
                app.addCourse();
                app.listCourse();
            }
            //6-Afisati cursurile
            if(choice.equals("6"))
            {
                app.listCourse();
            }
            //7-Stergeti un curs
            if(choice.equals("7"))
            {
                app.deleteCourse();
                app.listCourse();
            }
            //8-Actualizati un curs
            if(choice.equals("8"))
            {
                app.updateCourse();
                app.listCourse();
            }
            //---------------------------------SC--------------------------------------------------------
            //9-Adaugati un student la curs
            if(choice.equals("9"))
            {
                app.addStudentsToCourses();
            }
            //10-Afisati studentii care participa la un anumit curs
            if(choice.equals("10"))
            {
                app.listStudentstoCourse();
            }
        }
    }
    
}
