package ru.marilka888.noteapp.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.marilka888.noteapp.models.User;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByNumber(String number);
}
