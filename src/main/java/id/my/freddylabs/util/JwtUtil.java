package id.my.freddylabs.util;

import io.smallrye.jwt.build.Jwt;

import java.util.Set;
import java.util.UUID;

public class JwtUtil {

    public static String generate(UUID userId, String email) {

        return Jwt.issuer("todo-api")
                .upn(email)
                .groups(Set.of("USER"))
                .claim("userId", userId)
                .expiresIn(86400)
                .sign();
    }
}