package id.my.freddylabs.repository;

import id.my.freddylabs.entity.TodoEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.UUID;

@ApplicationScoped
public class TodoRepository implements PanacheRepository<TodoEntity> {

    public long countByUser(UUID userId) {
        return count("userId", userId);
    }

    public TodoEntity findByIdAndUserId(UUID id, UUID userId) {
        return find(
                "id = ?1 and userId = ?2",
                id,
                userId
        ).firstResult();
    }
}