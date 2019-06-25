package com.example.whiteawayshotelandresort;

public class Singleton {

    /**
     * Eager Instantiation
     */
    private static Customer_Details customerDetails = new Customer_Details();

    // private constructor to force use of
    // getInstance() to create Singleton object
    private Singleton(){}

    public static Customer_Details getInstance(){

        return customerDetails;
    }
}
