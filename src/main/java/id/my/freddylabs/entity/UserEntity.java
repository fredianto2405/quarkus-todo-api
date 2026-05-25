package id.my.freddylabs.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    public UUID id;

    public String name;

    public String email;

    public String password;

    @Column(name = "created_at")
    public LocalDateTime createdAt;
}