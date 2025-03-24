package com.example.styleSphere.global.security;

import com.example.styleSphere.domain.user.entity.UserEntity;
import com.example.styleSphere.domain.user.repository.UserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@RequiredArgsConstructor
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtTokenProvider jwtTokenProvider;
    private final UserRepository userRepository;


    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        // ✅ 1. Authorization 헤더에서 토큰 추출
        String token = extractToken(request);

        if (token != null && jwtTokenProvider.validateToken(token)) {
            // ✅ 2. 토큰 → 이메일 추출 → 사용자 조회 → 인증 객체 생성 및 등록
            setAuthenticationContext(token, request);
        }

        filterChain.doFilter(request, response);
    }


    private String extractToken(HttpServletRequest request) {
        String authHeader = request.getHeader("Authorization");

        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            return authHeader.substring(7); // "Bearer " 이후부터 자름
        }
        return null;
    }


    private void setAuthenticationContext(String token, HttpServletRequest request) {
        String email = jwtTokenProvider.getEmailFromToken(token);

        UserEntity user = userRepository.findByEmail(email).orElse(null);
        if (user == null) return;

        UsernamePasswordAuthenticationToken authentication =
                new UsernamePasswordAuthenticationToken(user, null, null); // 권한이 없다면 null

        authentication.setDetails(
                new WebAuthenticationDetailsSource().buildDetails(request)
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
    }
}
