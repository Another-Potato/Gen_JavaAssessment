package com.generation.model;

public class Course
{
    private final String code;
    private final String name;
    private final int credits;
    private final Module module;

    //Added grade to course
    private float grade;

    public Course( String code, String name, int credits, Module module )
    {
        this.code = code;
        this.name = name;
        this.credits = credits;
        this.module = module;
        //Added default grade for Course
        this.grade = 0;
    }

    public String getCode()
    {
        return code;
    }

    public String getName()
    {
        return name;
    }

    public int getCredits()
    {
        return credits;
    }

    public Module getModule()
    {
        return module;
    }

    //Added getter and setters for Grade
    public float getGrade() {return grade;}
    public void setGrade(float grade) {
        if (grade >= 1 && grade <= 6) {
            this.grade = grade;
        }
        else {
            System.out.println("Grade value out of bounds. Grade not set.");
        }
    }

    @Override
    public String toString()
    {
        return "Course{" + "code='" + code + '\'' + ", name='" + name + '\'' + ", credits=" + credits + ", module="
            + module + '}';
    }
}
