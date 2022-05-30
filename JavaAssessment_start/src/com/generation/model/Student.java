package com.generation.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class Student
    extends Person
    implements Evaluation
{

    float PASS_MIN_GRADE = 3.0f;
    private List<Course> enrolledCourses;

    public Student( String id, String name, String email, Date birthDate ) {
        super( id, name, email, birthDate );
        enrolledCourses = new ArrayList<>();
    }

    public void enrollToCourse( Course course ) {this.enrolledCourses.add(new Course(course.getCode(),course.getName(),course.getCredits(),course.getModule()));}

    @Override
    public List<Course> findPassedCourses()
    {
        List<Course> passedCourses = new ArrayList<>();

        for (Course course: enrolledCourses) {
            if (course.getGrade() >= PASS_MIN_GRADE){
                passedCourses.add(course);
            }
        }

        return passedCourses;
    }

    public Course findCourseById( String courseId )
    {
        for (Course course: enrolledCourses) {
            if (courseId.equals(course.getCode())) {
                return course;
            }
        }
       return null;
    }

    @Override
    public List<Course> getEnrolledCourses()
    {
        if (enrolledCourses.isEmpty()){
            return null;
        }
        else {
            return enrolledCourses;
        }
    }

    @Override
    public String toString()
    {
        return "Student {" + super.toString() + "}";
    }

    public String enrollCoursesToString() {
        System.out.println("Enrolled Courses:");
        if (enrolledCourses.isEmpty()){
            return "No enrolled courses available" ;
        }
        else {
            String result = "";
            for (Course c : enrolledCourses) {
                result += "course:" + c.toString()+"\n";
            }
            return result;
        }
    }

    public String enrollCoursesWithGradeToString() {
        System.out.println("Enrolled Courses:");
        if (enrolledCourses.isEmpty()){
            return "No enrolled courses available\n" ;
        }
        else {
            String result = "";
            for (Course c : enrolledCourses) {
                result += String.format("course:%s Grade: %.1f%n",c.toString(),c.getGrade());
            }
            return result;
        }
    }
}
