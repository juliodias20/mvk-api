package br.com.maverick.api.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtAuthorizationFilter extends OncePerRequestFilter {
    private final JwtTokenUtil jwtTokenUtil;

    public JwtAuthorizationFilter(JwtTokenUtil jwtTokenUtil) {
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        String header = request.getHeader(JwtConstants.HEADER_STRING);

        if (header == null || !header.startsWith(JwtConstants.TOKEN_PREFIX)) {
            chain.doFilter(request, response);

            return;
        }

        UsernamePasswordAuthenticationToken authentication = this.getAuthentication(request);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        chain.doFilter(request, response);
    }

    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
        String token = this.extractToken(request);

        if (token == null) {
            return null;
        }

        Integer id = jwtTokenUtil.getIdFromToken(token);
        Integer comapanyId = jwtTokenUtil.getCompanyIdFromToken(token);
        String name = jwtTokenUtil.getNameFromToken(token);
        String cpf = jwtTokenUtil.getCpfFromToken(token);
        String username = jwtTokenUtil.getUsernameFromToken(token);

        CurrentUser currentUser = new CurrentUser(id, comapanyId, name, cpf, username, null);
        return new UsernamePasswordAuthenticationToken(currentUser, null, currentUser.getAuthorities());
    }

    private String extractToken(HttpServletRequest request) {
        String header = request.getHeader(JwtConstants.HEADER_STRING);

        if (header != null && header.startsWith(JwtConstants.TOKEN_PREFIX)) {
            return header.replace(JwtConstants.TOKEN_PREFIX, "");
        }

        return null;
    }
}