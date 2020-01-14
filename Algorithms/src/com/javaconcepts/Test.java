package com.javaconcepts;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

class Test 
{ 
    // static variable 
    static int a = m1(); 
      
    // static block 
    static { 
        System.out.println("Inside static block"); 
    } 
      
    // static method 
    static int m1() { 
        System.out.println("from m1"); 
        return 20; 
    } 
      
    // static method(main !!) 
    public static void main(String[] args) 
    { 
       System.out.println("Value of a : "+a); 
       System.out.println("from main"); 
       

       SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd'T'HH:mm:ss.SSS zzz" );
       sdf.setTimeZone( TimeZone.getTimeZone( "UTC" ) );
       System.out.println( sdf.format( new Date() ) );
    } 
  
  

}
