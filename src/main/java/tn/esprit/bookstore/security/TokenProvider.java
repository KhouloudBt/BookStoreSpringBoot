package tn.esprit.bookstore.security;

import io.jsonwebtoken.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import tn.esprit.bookstore.services.UserDetailsImpl;


import java.util.Date;

//generate a JWT from username, date, expiration, secret
//get username from JWT
//validate a JWT
@Component
public class TokenProvider {

    private static final Logger logger = Logger.getLogger(TokenProvider.class);

    @Value("${bookstore.app.jwtSecret}")
    private String jwtSecret;

    @Value("${bookstore.app.jwtExpirationMs}")
    private int jwtExpirationMs;

    public String generateJwtToken(Authentication authentication) {

        UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();

        return Jwts.builder()
                .setSubject((userPrincipal.getUsername()))
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    public String getUserNameFromJwtToken(String token) {
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException e) {
            logger.error("Invalid JWT signature: {}");
        } catch (MalformedJwtException e) {
            logger.error("Invalid JWT token: {}");
        } catch (ExpiredJwtException e) {
            logger.error("JWT token is expired: {}");
        } catch (UnsupportedJwtException e) {
            logger.error("JWT token is unsupported: {}");
        } catch (IllegalArgumentException e) {
            logger.error("JWT claims string is empty: {}");
        }

        return false;
    }


}
