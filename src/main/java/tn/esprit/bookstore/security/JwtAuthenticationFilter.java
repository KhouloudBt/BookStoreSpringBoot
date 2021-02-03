package tn.esprit.bookstore.security;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;
import tn.esprit.bookstore.services.MemberService;
import tn.esprit.bookstore.services.UserDetailsServiceImpl;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//extending OncePerRequestFilter makes a single execution for each request to our API

public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private TokenProvider jwtUtils;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    private static final Logger logger = Logger.getLogger(JwtAuthenticationFilter.class);

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        try {
            //get JWT from the Authorization header (by removing Bearer prefix)
            String jwt = parseJwt(request);
            //System.out.println(request);
            if (jwt != null && jwtUtils.validateJwtToken(jwt)) {
                //if the request has JWT, validate it, parse username from it
                String username = jwtUtils.getUserNameFromJwtToken(jwt);
                //from username, get UserDetails to create an Authentication object
                UserDetails userDetails = userDetailsService.loadUserByUsername(username);
                //set the current UserDetails in SecurityContext using setAuthentication(authentication) method.
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities());
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        } catch (Exception e) {
            logger.error("Cannot set user authentication: {}", e);
        }

        filterChain.doFilter(request, response);
    }

    private String parseJwt(HttpServletRequest request) {
        String headerAuth = request.getHeader("Authorization");

        if (StringUtils.hasText(headerAuth) && headerAuth.startsWith("Bearer ")) {
            return headerAuth.substring(7, headerAuth.length());
        }

        return null;
    }

}