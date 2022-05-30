package com.generation.model;

public class Course
{
    private final String id;
    private final String name;
    private final int credits;
    private final Module module;
    private float grade;
    public static final float PASS_MIN_GRADE = 3.0f;

    public Course( String id, String name, int credits, Module module )
    {
        this.id = id;
        this.name = name;
        this.credits = credits;
        this.module = module;
        this.grade = 0;
    }

    public String getId() {return id;}
    public String getName() {return name;}
    public int getCredits() {return credits;}
    public Module getModule() {return module;}
    public float getGrade() {return grade;}

    public boolean setGrade(float grade) {
        if (grade >= 1 && grade <= 6) {
            this.grade = grade;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Course{" + "code='" + id + '\'' + ", name='" + name + '\'' + ", credits=" + credits + ", module="
            + module + '}';
    }
}
