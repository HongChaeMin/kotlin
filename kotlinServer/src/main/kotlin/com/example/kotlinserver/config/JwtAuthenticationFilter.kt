package com.example.kotlinserver.config

import com.example.kotlinserver.util.error.ErrorCode
import com.example.kotlinserver.util.error.MemberException
import io.jsonwebtoken.ExpiredJwtException
import org.springframework.web.filter.GenericFilterBean
import javax.servlet.FilterChain
import javax.servlet.ServletRequest
import javax.servlet.ServletResponse
import javax.servlet.http.HttpServletRequest

class JwtAuthenticationFilter(private val jwtProvider: JwtProvider) : GenericFilterBean() {

    override fun doFilter(request: ServletRequest, response: ServletResponse, chain: FilterChain) {
        try {
            val token: String = jwtProvider.resolveToken(request as HttpServletRequest)
            jwtProvider.validateToken(token)
        } catch (e: ExpiredJwtException) {
            jwtFailureTask(ErrorCode.EXPIRED_TOKEN_ERROR)
        } catch (e: NullPointerException) {
            jwtFailureTask(ErrorCode.NO_TOKEN_ERROR)
        } catch (e: Exception) {
            jwtFailureTask(ErrorCode.INVALID_TOKEN_ERROR)
        }
        chain.doFilter(request, response)
    }

    // 토큰의 유효성 검증을 통과하지 못할 경우 에러 코드 반환
    private fun jwtFailureTask(e: ErrorCode){
        throw MemberException(e)
    }
}
