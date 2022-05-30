package com.generation.service;

import com.generation.model.Course;
import com.generation.model.Student;

import java.util.*;

public class StudentService
{
    private final Map<String, Student> students = new HashMap<>();

    public void subscribeStudent( Student student ) {this.students.put(student.getId(),student);}

    public Student findStudent( String studentId ) {return students.get(studentId);}

    public boolean showSummary()
    {
        if (students.isEmpty()){return false;}
        else{
            for (Student student: students.values()) {
                System.out.println(student);
                System.out.print(student.enrollCoursesWithGradeToString());
            }
            return true;
        }
    }

    public void enrollToCourse( String studentId, Course course )
    {
        findStudent(studentId).enrollToCourse(course);
    }
}
