package com.inn.cafe.JWT;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.function.Function;

@Service
public class JwtUtil {

    private String secretkey = "cafesystem97";

    public String extractUsername(String token){
        return extractClaims(token,Claims::getSubject);
    }

    public Date extractExpiration(String token){
        return extractClaims(token,Claims::getExpiration);
    }

    public <T> T extractClaims(String token, Function<Claims,T> claimsResolver){
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    public Claims extractAllClaims(String token){
        return Jwts.parser().setSigningKey(secretkey).build().parseSignedClaims(token).getPayload();
    }

    private Boolean is 


}
