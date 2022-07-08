package com.example.kotlinserver.domain.author

import com.example.kotlinserver.domain.member.Gender
import com.example.kotlinserver.domain.util.BaseEntity
import com.example.kotlinserver.dto.author.AuthorDTO
import com.example.kotlinserver.dto.author.BookDTO
import com.vladmihalcea.hibernate.type.json.JsonType
import org.hibernate.annotations.Type
import org.hibernate.annotations.TypeDef
import org.mapstruct.Mapper
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
@TypeDef(name = "json", typeClass = JsonType::class)
class Author(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val name: String,
    val gender: Gender,
    val age: Int,

    @Type(type = "json")
    @Column(columnDefinition = "json")
    var books: List<Book>

) : BaseEntity() {

    fun toAuthorDto(): AuthorDTO {
        return AuthorDTO(
            id = this.id,
            name = this.name,
            gender = this.gender,
            age = this.age,
            books = this.books.map { book -> book.toBookDto() }
        )
    }

    fun changeBooks(requestDTO: BookDTO) {
        books = listOf(requestDTO.toEntity())
    }
}

@Mapper
interface AuthorMapper {
    fun toAuthorDto(author: Author): AuthorDTO
}
