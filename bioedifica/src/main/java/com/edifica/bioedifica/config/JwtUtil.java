package com.edifica.bioedifica.config;

import java.time.Instant;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.edifica.bioedifica.enums.usuario.RoleUsuario;

/**
 * Utilitário para geração e validação de tokens JWT.
 * Compatível com Java 17.
 */
@Component
public class JwtUtil {
    @Value("${spring.security.oauth2.resourceserver.jwt.secret}")
    private String jwtSecret;

    static {
        // SECRET is no longer needed, use jwtSecret instead
    }

    /**
     * Gera um token JWT para o usuário informado.
     */
    public String gerarToken(String username, String role) {
        Algorithm algoritmo = Algorithm.HMAC256(jwtSecret);
        return JWT.create()
                .withSubject(username)
                .withClaim("role", role)
                .withIssuedAt(Date.from(Instant.now()))
                .withExpiresAt(Date.from(Instant.now().plusSeconds(3600)))
                .sign(algoritmo);
    }

    /**
     * Valida o token JWT e retorna o objeto DecodedJWT se válido.
     */
    public DecodedJWT validarToken(String token) {
        Algorithm algoritmo = Algorithm.HMAC256(jwtSecret);
        JWTVerifier verifier = JWT.require(algoritmo).build();
        return verifier.verify(token);
    }

    /**
     * Exemplo de uso de claims para controlar acesso.
     */
    public boolean isAdmin(String token) {
        DecodedJWT jwt = validarToken(token);
        String role = jwt.getClaim("role").asString();
        return RoleUsuario.ADMIN.name().equals(role);
    }
}
