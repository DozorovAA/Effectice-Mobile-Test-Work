package ru.test.EffectiveMobileTestWork.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.test.EffectiveMobileTestWork.model.user.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);
}
