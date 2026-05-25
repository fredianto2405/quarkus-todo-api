package id.my.freddylabs.repository;

import id.my.freddylabs.entity.UserEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UserRepository implements PanacheRepository<UserEntity> {

    public UserEntity findByEmail(String email) {
        return find("email", email).firstResult();
    }
}
