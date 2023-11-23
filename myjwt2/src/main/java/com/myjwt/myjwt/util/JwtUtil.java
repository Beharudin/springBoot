package com.myjwt.myjwt.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

@Component
public class JwtUtil {
    private static final long ACCESS_TOKEN_EXPIRATION_TIME = 7 * 24 * 60 * 60 * 1000; // one week
    private static final long REFRESH_TOKEN_EXPIRATION_TIME = 30L * 24L * 60L * 60L * 1000L; // 1 month
    public static String SECRET_KEY="secret";
    public String extractUsername(String token){
        return extractClaim(token, Claims::getSubject);
    }

    public Date extractExpiration(String token){
        return extractClaim(token, Claims::getExpiration);
    }

    public  boolean hasClaim(String token, String claimName){
        final Claims claims= extractAllClaims(token);
        return claims.get(claimName)!=null;
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver){
        final Claims claims=extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token){
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
    }

    private boolean isTokenExpired(String token){
        return extractExpiration(token).before(new Date());
    }

    public String generateToken(UserDetails user){
        Map<String, Object> claims=new HashMap<>();
        return createToken(claims, user);
    }

    private String createToken(Map<String, Object> claims, UserDetails user){
        return Jwts.builder().setClaims(claims)
                .setSubject(user.getUsername())
                .claim("authorities", user.getAuthorities())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+ TimeUnit.HOURS.toMillis(ACCESS_TOKEN_EXPIRATION_TIME)))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();
    }

    public  Boolean isTokenValid(String token, UserDetails user){
        final String email=extractUsername(token);
        return (email.equals(user.getUsername()) && !isTokenExpired(token));
    }
}
