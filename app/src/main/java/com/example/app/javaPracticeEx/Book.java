package com.example.app.javaPracticeEx;

public class Book implements IdProvider, NameProvider{
    private final int id;
    private final String name;

    public final static String myBook = "new book";

    public Book(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static Book create() {
        return new Book(0, Book.myBook);
    }

    @Override
    public int getId() {
        return 444;
    }

    @Override
    public String getName() {
        return myBook;
    }
}


