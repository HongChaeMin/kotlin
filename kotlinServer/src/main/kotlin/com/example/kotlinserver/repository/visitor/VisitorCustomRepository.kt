package com.example.kotlinserver.repository.visitor

import com.example.kotlinserver.domain.visitor.Visitor
import com.example.kotlinserver.dto.visitor.request.RequestVisitorDTO
import com.example.kotlinserver.dto.visitor.response.ResponseVisitorDTO
import java.util.Optional

interface VisitorCustomRepository {
    fun findByVisitorIdAndUserId(request: RequestVisitorDTO): Optional<Visitor>
    fun findByAllId(visitorId: Long): ResponseVisitorDTO?
    fun findByAllList(): List<ResponseVisitorDTO>?
}
