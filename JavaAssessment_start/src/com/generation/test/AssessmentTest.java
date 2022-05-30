package com.generation.test;


import com.generation.model.Student;
import com.generation.service.CourseService;
import com.generation.service.StudentService;
import org.junit.Before;
import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class AssessmentTest {

    private StudentService studentServiceInstance;
    private CourseService courseServiceInstance;

    @Before
    public void setup() {
        studentServiceInstance = new StudentService();
        courseServiceInstance = new CourseService();
    }

    @Test
    public void test1() {
        DateFormat formatter = new SimpleDateFormat( "MM/dd/yyyy" );

        String name = "Jean";
        String id = "111";
        String email = "jean@gmail.com";
        String birthDateString = "01/01/2001";


        Date birthDate;
        try {
            birthDate = formatter.parse( birthDateString );
        } catch (Exception e) {
            System.out.println(e);
            return;
        }

        Student sampleStudent = new Student( id, name, email, birthDate );
    }

}
