package id.my.freddylabs.service;

import id.my.freddylabs.dto.todo.TodoRequest;
import id.my.freddylabs.entity.TodoEntity;
import id.my.freddylabs.exception.BusinessException;
import id.my.freddylabs.repository.TodoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class TodoService {

    @Inject
    TodoRepository todoRepository;

    @Transactional
    public void create(UUID userId, TodoRequest request) {

        TodoEntity todo = new TodoEntity();

        todo.id = UUID.randomUUID();
        todo.userId = userId;
        todo.title = request.title;
        todo.description = request.description;
        todo.completed = false;
        todo.createdAt = LocalDateTime.now();

        todoRepository.persist(todo);
    }

    public List<TodoEntity> findAll(UUID userId) {
        return todoRepository.find("userId", userId).list();
    }

    @Transactional
    public void update(
            UUID id,
            UUID userId,
            TodoRequest request
    ) {

        TodoEntity todo = todoRepository.findByIdAndUserId(id, userId);

        if (todo == null) {
            throw new BusinessException(
                    "Todo not found",
                    400
            );
        }

        todo.title = request.title;
        todo.description = request.description;
    }

    @Transactional
    public void delete(
            UUID id,
            UUID userId
    ) {

        TodoEntity todo = todoRepository.findByIdAndUserId(id, userId);

        if (todo == null) {
            throw new BusinessException(
                    "Todo not found",
                    400
            );
        }

        todoRepository.delete(todo);
    }
}