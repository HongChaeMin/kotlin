package com.example.kotlinserver.service.author

import com.example.kotlinserver.dto.author.AuthorDTO
import com.example.kotlinserver.dto.author.BookDTO
import com.example.kotlinserver.repository.AuthorRepository
import com.example.kotlinserver.util.error.ErrorCode
import com.example.kotlinserver.util.error.MyException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class AuthorServiceImpl(private val authorRepository: AuthorRepository) : AuthorService {

    override fun findAuthors(): List<AuthorDTO> {
        val findAuthors = authorRepository.findAll()
        return findAuthors.map { author -> author.toAuthorDto() }
    }

    override fun findAuthor(authorId: Long): AuthorDTO {
        return authorRepository.findByIdOrNull(authorId)
            ?.toAuthorDto()
            ?: throw MyException(ErrorCode.NOT_EXIST_AUTHOR)
    }

    @Transactional
    override fun registerAuthor(requestDTO: AuthorDTO): AuthorDTO {
        val saveAuthor = authorRepository.save(requestDTO.toEntity())
        return saveAuthor.toAuthorDto()
    }

    @Transactional
    override fun updateBooksInAuthor(authorId: Long, requestDTO: BookDTO): AuthorDTO {
        val author = authorRepository.findByIdOrNull(authorId)
            ?: throw MyException(ErrorCode.NOT_EXIST_AUTHOR)
        author.changeBooks(requestDTO)
        return author.toAuthorDto()
    }

    @Transactional
    override fun deleteAuthor(authorId: Long) {
        val author = authorRepository.findByIdOrNull(authorId)
            ?: throw MyException(ErrorCode.NOT_EXIST_AUTHOR)
        authorRepository.delete(author)
    }
}
