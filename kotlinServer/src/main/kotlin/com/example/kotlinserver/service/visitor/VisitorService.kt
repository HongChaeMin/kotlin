package com.example.kotlinserver.service.visitor

import com.example.kotlinserver.dto.visitor.VisitorDTO
import com.example.kotlinserver.dto.visitor.request.RequestVisitorDTO
import com.example.kotlinserver.dto.visitor.response.ResponseVisitorDTO

interface VisitorService {

    fun saveVisitor(request: VisitorDTO): VisitorDTO

    fun addVisitorUser(request: RequestVisitorDTO): VisitorDTO

    fun selectOneVisitorList(request: RequestVisitorDTO): ResponseVisitorDTO

    fun selectVisitorAllList(): List<ResponseVisitorDTO>
}
