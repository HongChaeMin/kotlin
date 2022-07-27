package com.example.kotlinserver.repository.visitor

import com.example.kotlinserver.domain.visitor.Visitor
import org.springframework.data.jpa.repository.JpaRepository

interface VisitorRepository : JpaRepository<Visitor, Long>, VisitorCustomRepository
