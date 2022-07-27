package com.example.kotlinserver.dto.visitor.response

data class ResponseVisitorDTO(
    private val visitorId: Long?,
    private val users: List<ResponseVisitorUserDTO>
)
