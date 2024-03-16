package com.project.sltourguide.config;

import com.project.sltourguide.exceptions.MalformedJwtTokenException;
import com.project.sltourguide.exceptions.MissingJwtTokenException;
import io.jsonwebtoken.JwtException;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
@Slf4j
@Component
@RequiredArgsConstructor
public class JwtTokenFilter extends OncePerRequestFilter { // every request first reach this
    private final JwtUtil jwtUtil;
    private final UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request,@NonNull HttpServletResponse response,@NonNull FilterChain filterChain)
            throws IOException, ServletException {
        log.info("start security filer chaining");
        String token = obtainToken(request);
        String email;
        if (token == null) {
            filterChain.doFilter(request, response);
            return;
        }
        try {
            email = jwtUtil.extractUsername(token);
            log.info("email extract from token is {}", email);
            if (email != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                log.info("doFilterInternal email {}", email);
                UserDetails userDetails = userDetailsService.loadUserByUsername(email);
                log.info("doFilterInternal userName {}", userDetails.getUsername());
                if (jwtUtil.validateToken(token,userDetails)) {
                    log.info("valid token");
                    Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            }
        } catch (JwtException e) {
            throw new MalformedJwtTokenException("malformed JWT token");
        }

        filterChain.doFilter(request, response);
    }

    private String obtainToken(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        log.info("--- Authorization header:" + bearerToken);
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }

}