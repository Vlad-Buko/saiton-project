package ex.proj.skyline.saitonproject.repository;

import ex.proj.skyline.saitonproject.dto.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Long> {
}
