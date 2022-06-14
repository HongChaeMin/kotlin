package com.example.kotlinserver.config

import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.io.Decoders
import io.jsonwebtoken.security.Keys
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Component
import java.util.*
import javax.servlet.http.HttpServletRequest

@Component
class JwtProvider() {
    // JWT를 생성하고 검증하는 키 세팅
    private var secretKey = Keys.hmacShaKeyFor(Decoders.BASE64.decode("hannahSecretKey"))

    // 토큰 유효시간 30분
    private val tokenValidTime = 30 * 60 * 1000L

    // JWT 토큰 생성
    fun createToken(userPk: String): String {
        val claims: Claims = Jwts.claims().setSubject(userPk) // JWT payload 에 저장되는 정보단위
        claims["userPk"] = userPk // 정보는 key / value 쌍으로 저장된다.
        val now = Date()
        return Jwts.builder()
                .setClaims(claims) // 정보 저장
                .setIssuedAt(now) // 토큰 발행 시간 정보
                .setExpiration(Date(now.time + tokenValidTime)) // set Expire Time
                .signWith(secretKey) // Key 세팅
                .compact()
    }

    // 토큰에서 회원 정보 추출
    fun getUserPk(token: String): String {
        return Jwts.parserBuilder()
                .setSigningKey(secretKey).build()
                .parseClaimsJws(token).body.subject
    }

    // Request의 Header에서 token 값을 가져옵니다. "Authorization" : "TOKEN값'
    fun resolveToken(request: HttpServletRequest): String {
        return request.getHeader("Authorization")
    }

    // 토큰의 유효성 + 만료일자 확인
    fun validateToken(jwtToken: String): Boolean {
        return try {
            val claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(jwtToken)
            !claims.body.expiration.before(Date())
        } catch (e: Exception) {
            false
        }
    }
}
