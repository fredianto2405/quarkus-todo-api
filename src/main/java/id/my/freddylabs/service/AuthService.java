package id.my.freddylabs.service;

import id.my.freddylabs.dto.auth.LoginRequest;
import id.my.freddylabs.dto.auth.RegisterRequest;
import id.my.freddylabs.entity.UserEntity;
import id.my.freddylabs.exception.BusinessException;
import id.my.freddylabs.repository.UserRepository;
import id.my.freddylabs.util.JwtUtil;
import id.my.freddylabs.util.PasswordUtil;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

@ApplicationScoped
public class AuthService {

    @Inject
    UserRepository userRepository;

    @Transactional
    public void register(RegisterRequest request) {

        if (userRepository.findByEmail(request.email) != null) {
            throw new BusinessException("Email already registered", 400);
        }

        UserEntity user = new UserEntity();
        user.id = UUID.randomUUID();
        user.name = request.name;
        user.email = request.email;
        user.password = PasswordUtil.hash(request.password);
        user.createdAt = LocalDateTime.now();

        userRepository.persist(user);
    }

    public Map<String, Object> login(LoginRequest request) {

        UserEntity user = userRepository.findByEmail(request.email);

        if (user == null) {
            throw new BusinessException("Invalid email or password", 401);
        }

        if (!PasswordUtil.verify(request.password, user.password)) {
            throw new BusinessException("Invalid email or password", 401);
        }

        String token = JwtUtil.generate(user.id, user.email);

        return Map.of(
                "token", token
        );
    }
}
