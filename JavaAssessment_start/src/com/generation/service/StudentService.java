package com.generation.service;

import com.generation.model.Course;
import com.generation.model.Student;

import java.util.*;

public class StudentService
{
    private final Map<String, Student> students;

    public StudentService() {
        students = new HashMap<>();
    }

    public Student registerStudent(String id, String name, String email, Date birthDate ) {
        Student newStudent = new Student(id,name,email,birthDate);
        students.put(id, newStudent);
        return newStudent;
    }

    public Student findStudent( String studentId ) {
        if (students.containsKey(studentId)) {
            return students.get(studentId);
        }
        return null;
    }



    public boolean showSummary() {
        if (students.isEmpty()){return false;}
        else{
            for (Student student: students.values()) {
                System.out.println(student);
                System.out.println(student.enrolledCoursesToString());
            }
            return true;
        }
    }
}
