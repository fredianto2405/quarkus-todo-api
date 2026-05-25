package id.my.freddylabs.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "todos")
public class TodoEntity {

    @Id
    public UUID id;

    @Column(name = "user_id")
    public UUID userId;

    public String title;

    public String description;

    public boolean completed;

    @Column(name = "created_at")
    public LocalDateTime createdAt;
}
