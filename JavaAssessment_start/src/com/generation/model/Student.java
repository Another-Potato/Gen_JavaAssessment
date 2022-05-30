package com.generation.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Student extends Person implements Evaluation {
    private List<Course> enrolledCourses;

    public Student( String id, String name, String email, Date birthDate ) {
        super( id, name, email, birthDate );
        enrolledCourses = new ArrayList<>();
    }

    public void enrollToCourse( Course course ) {
        for (Course c : enrolledCourses) {
            if(c.getId() == course.getId()){
                return;
            }
        }
        enrolledCourses.add(new Course(course.getId(),course.getName(),course.getCredits(),course.getModule()));
    }

    @Override
    public List<Course> findPassedCourses()
    {
        List<Course> passedCourses = new ArrayList<>();

        for (Course course: enrolledCourses) {
            if (course.getGrade() >= Course.PASS_MIN_GRADE){
                passedCourses.add(course);
            }
        }

        return passedCourses;
    }

    public Course findCourseById( String courseId )
    {
        for (Course course: enrolledCourses) {
            if (courseId.equals(course.getId())) {
                return course;
            }
        }
       return null;
    }

    @Override
    public List<Course> getEnrolledCourses()
    {
        if (enrolledCourses.isEmpty()){return null;}
        else {return enrolledCourses;}
    }

    @Override
    public String toString()
    {
        return "Student {" + super.toString() + "}";
    }

    public String enrolledCoursesToString() {
        String result = "Enrolled Courses:";
        if (enrolledCourses.isEmpty()){
            result += "\nNo enrolled courses available" ;
        }
        else {
            for (Course c : enrolledCourses) {
                result += String.format("%ncourse:%s Grade: %.1f",c.toString(),c.getGrade());
            }
        }
        return result;
    }

    public String enrolledCoursesToStringHideGrade() {
        String result = "Enrolled Courses:";
        if (enrolledCourses.isEmpty()){
            result += "\nNo enrolled courses available" ;
        }
        else {
            for (Course c : enrolledCourses) {
                result += "\n" + "course:" + c.toString();
            }
        }
        return result;
    }
}
