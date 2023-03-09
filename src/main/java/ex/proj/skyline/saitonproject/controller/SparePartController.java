package ex.proj.skyline.saitonproject.controller;

import com.fasterxml.jackson.annotation.JsonView;
import ex.proj.skyline.saitonproject.dto.Note;
import ex.proj.skyline.saitonproject.dto.Views;
import ex.proj.skyline.saitonproject.repository.NoteRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by Vladislav Domaniewski
 */

@RestController
@RequestMapping("/autoshop/api/spares")
public class SparePartController {

    private final NoteRepository noteRepository;

    @Autowired
    public SparePartController(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @GetMapping
    @JsonView(Views.idName.class)
    public List<Note> list() {
        return noteRepository.findAll();
    }

    @GetMapping("{id}")
    public Note getOne(@PathVariable("id") Note note) {
        return note;
    }

    @PostMapping
    public Note create(@RequestBody Note note) {
        note.setCreationDateTime(LocalDateTime.now());
        return noteRepository.save(note);
    }

    @PutMapping("{id}")
    public Note update(@PathVariable("id") Note noteFromDb,
                       @RequestBody Note note) {
        BeanUtils.copyProperties(note, noteFromDb, "id");
        return noteRepository.save(noteFromDb);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Note note) {
        noteRepository.delete(note);
    }
}
