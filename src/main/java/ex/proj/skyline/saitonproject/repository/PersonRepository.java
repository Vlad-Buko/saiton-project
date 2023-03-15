package ex.proj.skyline.saitonproject.repository;

import ex.proj.skyline.saitonproject.dto.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    // Optional - проверяем человек найден или нет
    Optional<Person> findByUsername(String username);
}
