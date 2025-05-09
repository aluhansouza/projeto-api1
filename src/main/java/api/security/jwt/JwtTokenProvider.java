package api.security.jwt;

import java.security.Key;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JwtTokenProvider {

    @Value("${jwt.secret.key}")
    private String secret;

    @Value("${jwt.expiration.time}")
    private long expirationTime;

    private Key key;

    @PostConstruct
    public void init() {
        this.key = Keys.hmacShaKeyFor(secret.getBytes());
    }

    // Gera o token JWT
    public String generateToken(UserDetails userDetails) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + expirationTime);

        return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .claim("iat", now)  // "iat" é o claim de emissão (Issued At)
                .setExpiration(expiryDate)
                .signWith(key, Jwts.SIG.HS512)  // Atualizado para a nova forma de assinatura
                .compact();
    }

    // Valida o token JWT
    public boolean validateToken(String token) {
        try {
            // Usando o parser correto da versão 0.12.x
            Jwts.parser()
                .setSigningKey(key)  // Adicionando chave de assinatura
                .parseClaimsJws(token);  // Parse do token
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }

    // Extrai o nome de usuário do token
    public String getUsernameFromToken(String token) {
        return Jwts.parser()
                .setSigningKey(key)  // Adicionando chave de assinatura
                .parseClaimsJws(token)  // Parse do token
                .getBody()
                .getSubject();
    }
}	