package com.enigmacamp.security;

import com.enigmacamp.service.UserService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class AuthTokenFilter extends OncePerRequestFilter {
    private final JwtUtil jwtUtil;
    private final UserService userService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        System.out.println("doFilterInternal");

        try {
            String headerAuth = request.getHeader(HttpHeaders.AUTHORIZATION);
            String token = null;

            if (headerAuth != null && headerAuth.startsWith("Bearer ")) {
                token = headerAuth.substring(7);
            }

            if (token != null && jwtUtil.verifyJwtToken(token)) {
                Map<String, Object> userInfo = jwtUtil.getUserInfoByToken(token);
                UserDetails user = userService.loadUserByUserId(userInfo.get("userId").toString());
                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
                authenticationToken.setDetails(new WebAuthenticationDetailsSource());
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
            System.out.println("end of filter");
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

        filterChain.doFilter(request, response);
        System.out.println("filter done");
    }
}
