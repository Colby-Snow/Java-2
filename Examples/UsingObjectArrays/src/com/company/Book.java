package com.company;

public class Book {
    private String title;
    private String author;
    private double price;

    //default constructor
    Book(){
        title = "Default Title";
        author = "Default Author";
        price = 0;
    }

    //parameterized constructor/ Overloaded Constructor
    Book(String t, String a, double p){
        setTitle(t);
        setAuthor(a);
        setPrice(p);
    }

    //setters
    public void setTitle(String t) { title = t;}
    public void setAuthor(String a) { author = a;}
    public void setPrice(double p) { price = p;}

    //getters
    public String getTitle() { return title;}
    public String getAuthor() { return author;}
    public double getPrice() { return price;}

    public String displayBook(){
        return "Title: " +  getTitle() + "\n" +
                "Author: " + getAuthor() + "\n" +
                "Price: " + getPrice();
    }
}
