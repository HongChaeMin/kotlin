package com.example.app

class Book private constructor(val id : Int, val name : String) {
    companion object BookFactory : IdProvider, NameProvider {
        private const val myBook = "new book";

        override fun getId(): Int {
            return 444;
        }

        override fun getName(): String {
            return myBook;
        }

        fun create() = Book(0, myBook);
    }
}

interface IdProvider {
    fun getId() : Int;
}

interface NameProvider {
    fun getName() : String;
}

fun main() {
    val book = Book.create();
    println("${book.id} ${book.name}");

    val bookId = Book.getId();
    println(bookId);

    val bookName = Book.getName();
    println(bookName);
}