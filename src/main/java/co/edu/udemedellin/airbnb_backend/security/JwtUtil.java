package co.edu.udemedellin.airbnb_backend.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtUtil {
    private final String SECRET_KEY = "q3ZbRz9Y1sFsxM2HZxM7X2P1xO5xL3ZbRz9Y1sFsxM2HZxM7X2P1xO5xL3ZbRz9=";
    private final long EXPIRATION_TIME = 86400000L;

    private SecretKey getSigningKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
            return Keys.hmacShaKeyFor(keyBytes);
    }

    public String generateToken(String username) {
        return Jwts.builder()
                .subject(username)
                .expiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(getSigningKey())
                .compact();
    }

    public String extractUsername(String token) {
        return Jwts.parser()
                .verifyWith(getSigningKey())
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();

    }

    public boolean validateToken(String token, String username) {
        try {
            return extractUsername(token).equals(username);
        } catch (Exception e) {
            return false;
        }

    }
}
