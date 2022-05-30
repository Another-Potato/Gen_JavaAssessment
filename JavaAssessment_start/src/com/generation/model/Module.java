package com.generation.model;

public class Module
{
    private final String id;
    private final String name;
    private final String description;

    public Module( String code, String name, String description )
    {
        this.id = code;
        this.name = name;
        this.description = description;
    }

    public String getCode()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public String getDescription()
    {
        return description;
    }

    @Override
    public String toString()
    {
        return "Module{" + "name='" + name + '\'' + '}';
    }
}
