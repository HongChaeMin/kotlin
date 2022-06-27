package com.example.kotlinserver.repository

import com.example.kotlinserver.domain.Author
import com.example.kotlinserver.domain.Gender
import com.example.kotlinserver.domain.book.Book
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AuthorRepositoryTests(
    @Autowired val authorRepository: AuthorRepository
) {

    val books: ArrayList<Book> = arrayListOf()

    @BeforeEach
    fun initBooks() {
        for (i in 1 .. 10) {
            val book = Book(title = "title${i}", price = 10000 + i)
            books.add(book)
        }
    }

    @AfterEach
    fun clear() {
        authorRepository.deleteAll()
    }

    @Test
    fun `author json save test`() {
        val author = Author(name = "name", gender = Gender.FEMALE, age = 20, books = books)
        authorRepository.save(author)
    }

    @Test
    fun `author json find test`() {
        for (author in authorRepository.findAll()) {
            println("author.id : ${author.id}")
            println("author.name : ${author.name}")
            println("author.gender : ${author.gender}")
            println("author.age : ${author.age}")
            for (book in author.books) {
                println("author${author.id} write book : $book")
            }
        }

        // 우왕
        // author.id : 1
        // author.name : name
        // author.gender : FEMALE
        // author.age : 20
        // author1 write book : Book(id=15fc7416-666b-4251-b28c-d97ca627e10f, title=title1, price=10001)
        // author1 write book : Book(id=14d010b5-73bc-4d97-8bee-d2ef10b0396e, title=title2, price=10002)
        // author1 write book : Book(id=ba7e044c-e5f7-4770-8cd1-60a0b6994558, title=title3, price=10003)
        // author1 write book : Book(id=69874ad5-2893-48bf-95b8-670ffc389f9c, title=title4, price=10004)
        // author1 write book : Book(id=45d560e8-5a72-4e2a-87bc-0d747e23b3cd, title=title5, price=10005)
        // author1 write book : Book(id=f932debb-2508-4916-a1ae-f7334dbe218c, title=title6, price=10006)
        // author1 write book : Book(id=b9d74f9d-12ab-499d-999f-af9af856c2e0, title=title7, price=10007)
        // author1 write book : Book(id=64595ca6-216d-4dcd-a225-a0bb92acfcdb, title=title8, price=10008)
        // author1 write book : Book(id=fcbcae95-a2d9-4918-9402-933eb8420682, title=title9, price=10009)
        // author1 write book : Book(id=62437608-ec0a-4fd8-893b-94ae19db12f0, title=title10, price=10010)
    }

}