package com.generation.utils;

public class PrinterHelper
{
    public static void showMainMenu()
    {
        System.out.println( "|-------------------------------|" );
        System.out.println( "| Welcome to StudentGen         |" );
        System.out.println( "|-------------------------------|" );
        System.out.println( "| Select 1 option:              |" );
        System.out.println( "| . 1 Register Student          |" );
        System.out.println( "| . 2 Find Student              |" );
        System.out.println( "| . 3 Grade Student             |" );
        System.out.println( "| . 4 Enroll Student to Course  |" );
        System.out.println( "| . 5 Show Students Summary     |" );
        System.out.println( "| . 6 Show Courses Summary      |" );
        System.out.println( "| . 7 Show Passed Courses       |" );
        System.out.println( "| . 8 Exit                      |" );
        System.out.println( "|-------------------------------|" );
    }

    public static void createStudentMenu( int part ) {

        switch (part) {
            case 1:
                System.out.println( "|-------------------------------------|" );
                System.out.println( "| . 1 Register Student                |" );
                System.out.println( "|-------------------------------------|" );
                System.out.println( "| Enter student name:                 |" );
                break;
            case 2:
                System.out.println( "| Enter student ID:                   |" );
            case 3:
                System.out.println( "| Enter student email:                |" );
                break;
            case 4:
                System.out.println( "| Enter student birth date(MM/dd/yyyy)|" );
                break;
            case 5:
                System.out.println( "|-------------------------------------|" );
                break;
            default:
                System.out.println("Error: Invalid part of student menu requested.");
        }
    }
}
