package com.generation.java;

import com.generation.model.Course;
import com.generation.model.Student;
import com.generation.service.CourseService;
import com.generation.service.StudentService;
import com.generation.utils.PrinterHelper;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class StudentGen {

    private StudentService studentService;
    private CourseService courseService;
    private Scanner scanner;

    public StudentGen() {
        studentService = new StudentService();
        courseService = new CourseService();
        scanner = new Scanner(System.in);
        System.out.println(scanner);
    }

    public void runStudentGen() {

        String option = "";
        do {
            PrinterHelper.showMainMenu();
            try{
                option = scanner.next();
                scanner.nextLine();
                switch ( option ) {
                    case "1":
                        registerStudent();
                        break;
                    case "2":
                        findStudent();
                        break;
                    case "3":
                        gradeStudent();
                        break;
                    case "4":
                        enrollCourse();
                        break;
                    case "5":
                        showStudentsSummary();
                        break;
                    case "6":
                        showCoursesSummary();
                        break;
                    case "7":
                        showPassedCourses( studentService, scanner );
                        break;
                    case "8":
                        System.out.println("Exit Selected. Closing StudentGen~");
                        return;
                    default:
                        System.out.println("Invalid Selection. Please enter a number between 1 to 8.");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Error: " + e );
            }
        } while (!option.equals("8"));
    }

    private void registerStudent() {
        String name;
        String id;
        String email;
        Date birthDate = null;
        DateFormat formatter = new SimpleDateFormat( "MM/dd/yyyy" );

        PrinterHelper.createStudentMenu(1);
        name = scanner.nextLine();
        PrinterHelper.createStudentMenu(2);
        id = scanner.next();
        scanner.nextLine();
        PrinterHelper.createStudentMenu(3);
        email = scanner.next();
        scanner.nextLine();
        while (birthDate == null){
            try{
                PrinterHelper.createStudentMenu(4);
                birthDate = formatter.parse( scanner.next() );
            } catch (Exception e) {
                System.out.println("Invalid date format. Make sure you type date using the following format: MM/dd/yyyy");
            }
        }
        scanner.nextLine();
        PrinterHelper.createStudentMenu(5);
        System.out.println("Student Successfully Registered!");
        System.out.println(studentService.registerStudent(id,name,email,birthDate));
    }

    private void findStudent()
    {
        String searchId;
        Student student;

        System.out.println( "Enter student ID: " );
        searchId = scanner.next();
        scanner.nextLine();
        student = studentService.findStudent(searchId);
        if ( student != null ) {
            System.out.println( "Student Found: " );
            System.out.println( student );
        }
        else {
            System.out.println("Student not found");
        }
    }

    private void gradeStudent()
    {
        Student student;
        Course course;
        float grade;

        System.out.println( "Enter student ID: " );
        student = studentService.findStudent(scanner.next());
        scanner.nextLine();
        if ( student != null ) {
            System.out.println(student);
            System.out.println(student.enrolledCoursesToStringHideGrade());
        }
        else {
            System.out.println("Student not found");
            return;
        }

        System.out.println( "Insert course ID to be graded:" );
        course = student.findCourseById(scanner.next());
        scanner.nextLine();
        if (course == null) {
            System.out.println("No applicable course found");
            return;
        }

        System.out.println( "Insert course grade for: " + course.getName() );
        try{
            grade = Float.parseFloat(scanner.next());
        }
        catch (Exception e){
            System.out.println("Invalid grade value");
            return;
        }
        if (!course.setGrade(grade)){
            System.out.println("Invalid grade value. Only grades between 1 to 6 accepted");
        }
        scanner.nextLine();
    }




    private void enrollCourse()
    {
        Student student;
        Course course;

        System.out.println( "Insert student ID" );
        student = studentService.findStudent( scanner.next() );
        scanner.nextLine();
        if ( student != null ) {
            System.out.println( student );
        }
        else {
            System.out.println( "Invalid Student ID" );
            return;
        }

        System.out.println( "Insert course ID" );
        course = courseService.getCourse( scanner.next() );
        scanner.nextLine();
        if ( course != null ) {
            System.out.println( course );
        }
        else {
            System.out.println( "Invalid Course ID" );
            return;
        }
        student.enrollToCourse(course);
        System.out.println( "Student with ID: " + student.getId() + " enrolled successfully to " + course.getId() );

    }

    private void showStudentsSummary()
    {
        if (!studentService.showSummary()) {
            System.out.println("No Student Yet");
        }
    }

    private void showCoursesSummary()
    {
        courseService.showSummary();
    }

    private static void showPassedCourses(StudentService studentService, Scanner scanner )
    {
        System.out.println( "Enter student ID: " );
        Student student = studentService.findStudent( scanner.next() );
        scanner.nextLine();
        if ( student != null )
        {
            if (!student.findPassedCourses().isEmpty()) {
                System.out.println(student.findPassedCourses());
            }
            else {
                System.out.println( "No passed courses available" );
            }
        }
        else
        {
            System.out.println( "Student not found" );
        }
    }

}
