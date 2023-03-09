package ex.proj.skyline.saitonproject.repository;

import ex.proj.skyline.saitonproject.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailsRepository extends JpaRepository<User, String> {
}
