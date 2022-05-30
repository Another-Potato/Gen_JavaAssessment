package com.generation.java;

import com.generation.model.Course;
import com.generation.model.Student;
import com.generation.service.CourseService;
import com.generation.service.StudentService;
import com.generation.utils.PrinterHelper;

import java.text.ParseException;
import java.util.Scanner;

public class Main
{
    public static void main( String[] args ) {

        StudentGen studentGenProgram = new StudentGen();

        try{
            studentGenProgram.runStudentGen();
        }
        catch (Exception e){
            System.out.println(e);
        }

    }
}
