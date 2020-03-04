package com.company;

public class BookArrayExample {


    public static void main(String[] args){
        Book[] bookArray = new Book[3];
        bookArray[0] = (new Book());
        bookArray[1] = new Book("The Catcher in the Rye", "Salinger",7.99);
        bookArray[2] = new Book("Java Programming", "Farrell",125.00);

        for(int i = 0; i < bookArray.length && bookArray[i] != null; i++){
            System.out.println(bookArray[i].displayBook());
        }

    }
}
