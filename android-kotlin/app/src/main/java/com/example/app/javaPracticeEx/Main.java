package com.example.app.javaPracticeEx;

public class Main {
    public static void main(String[] args) {
        Book book = Book.create();
        System.out.println("bookId : " + book.getId() + ", bookName : " + book.getName());

        // java 는 안됨 interface 상속 받아서 static 메소드로 만드는거
        int bookId = book.getId();
        System.out.println(bookId);

        String bookName = book.getName();
        System.out.println(bookName);
    }
}
