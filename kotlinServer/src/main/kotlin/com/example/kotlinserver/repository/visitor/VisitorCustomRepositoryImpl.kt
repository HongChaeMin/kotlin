package com.example.kotlinserver.repository.visitor

import com.example.kotlinserver.domain.visitor.QVisitor.visitor
import com.example.kotlinserver.domain.visitor.Visitor
import com.example.kotlinserver.dto.visitor.request.RequestVisitorDTO
import com.example.kotlinserver.dto.visitor.response.ResponseVisitorDTO
import com.querydsl.jpa.impl.JPAQueryFactory
import java.util.Optional

class VisitorCustomRepositoryImpl(
    private val queryFactory: JPAQueryFactory
) : VisitorCustomRepository {

    override fun findByVisitorIdAndUserId(request: RequestVisitorDTO): Optional<Visitor> {
        return Optional.ofNullable(
            queryFactory.selectFrom(visitor).where(visitor.id.eq(request.visitorId), visitor.userIds.contains(request.userId)).fetchOne()
        )
    }

    override fun findByAllId(visitorId: Long): ResponseVisitorDTO? {
        queryFactory.select()
            .from()
        TODO("Not yet implemented")
    }

    override fun findByAllList(): List<ResponseVisitorDTO>? {
        TODO("Not yet implemented")
    }
}
