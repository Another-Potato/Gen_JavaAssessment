package com.generation.java;

import com.generation.model.Course;
import com.generation.model.Student;
import com.generation.service.CourseService;
import com.generation.service.StudentService;
import com.generation.utils.PrinterHelper;

import java.text.ParseException;
import java.util.Scanner;

public class StudentGen {

    private StudentService studentService;
    private CourseService courseService;
    private Scanner scanner;

    public StudentGen() {
        studentService = new StudentService();
        courseService = new CourseService();
        scanner = new Scanner(System.in);
    }

    // Copied codes below

    public void runStudentGen()
            throws ParseException
    {

        int option;
        do
        {
            PrinterHelper.showMainMenu();
            option = scanner.nextInt();
            switch ( option )
            {
                case 1:
                    registerStudent( studentService, scanner );
                    break;
                case 2:
                    findStudent( studentService, scanner );
                    break;
                case 3:
                    gradeStudent( studentService, scanner );
                    break;
                case 4:
                    enrollCourse( studentService, courseService, scanner );
                    break;
                case 5:
                    showStudentsSummary( studentService, scanner );
                    break;
                case 6:
                    showCoursesSummary( courseService, scanner );
                    break;
                case 7:
                    showPassedCourses( studentService, scanner );
                    break;
            }
        }
        while ( option != 8 );
    }

    private static void registerStudent( StudentService studentService, Scanner scanner ) throws ParseException {
        Student student = PrinterHelper.createStudentMenu( scanner );
        studentService.subscribeStudent( student );
    }

    private static void findStudent( StudentService studentService, Scanner scanner )
    {
        Student student = getStudentInformation( studentService, scanner );
        if ( student != null )
        {
            System.out.println( "Student Found: " );
            System.out.println( student );
        }
    }

    private static void gradeStudent( StudentService studentService, Scanner scanner )
    {

        Student student = getStudentInformation( studentService, scanner );

        //Added Code Below
        Course course;
        float grade = 0;

        System.out.print(student.enrollCoursesToString());
        System.out.println( "Insert course ID to be graded:" );
        course = student.findCourseById(scanner.next());
        if (course == null) {
            System.out.println("Student not enrolled in searched course.");
            return;
        }
        System.out.println( "Insert course grade for: " + course.getName() );
        try{
            grade = Float.parseFloat(scanner.next());
            course.setGrade(grade);
        }
        catch (Exception e){
            System.out.println("Invalid grade detected. Grade not set.");
            return;
        }
    }




    private static void enrollCourse( StudentService studentService, CourseService courseService,
                                      Scanner scanner )
    {
        System.out.println( "Insert student ID" );
        String studentId = scanner.next();
        Student student = studentService.findStudent( studentId );
        if ( student == null )
        {
            System.out.println( "Invalid Student ID" );
            return;
        }
        System.out.println( student );
        System.out.println( "Insert course ID" );
        String courseId = scanner.next();
        Course course = courseService.getCourse( courseId );
        if ( course == null )
        {
            System.out.println( "Invalid Course ID" );
            return;
        }
        System.out.println( course );
        studentService.enrollToCourse( studentId, course );
        System.out.println( "Student with ID: " + studentId + " enrolled successfully to " + courseId );

    }

    private static void showCoursesSummary( CourseService courseService, Scanner scanner )
    {
        courseService.showSummary();
    }

    private static void showStudentsSummary( StudentService studentService, Scanner scanner )
    {
        if (!studentService.showSummary())
        {
            System.out.println("No Student Yet");
        }
    }



    private static Student getStudentInformation( StudentService studentService, Scanner scanner )
    {
        System.out.println( "Enter student ID: " );
        String studentId = scanner.next();
        Student student = studentService.findStudent( studentId );
        if ( student == null )
        {
            System.out.println( "Student not found" );
        }
        return student;
    }





    private static void showPassedCourses(StudentService studentService, Scanner scanner )
    {
        System.out.println( "Enter student ID: " );
        String studentId = scanner.next();
        Student student = studentService.findStudent( studentId );
        if ( student == null )
        {
            System.out.println( "Student not found" );
        }
        else
        {
            if (student.findPassedCourses().size() == 0)
            {
                System.out.println( "No passed courses available" );
            }
            else
            {
                System.out.println(student.findPassedCourses());
            }
        }
    }


}
