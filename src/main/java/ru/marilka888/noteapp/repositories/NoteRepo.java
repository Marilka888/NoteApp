package ru.marilka888.noteapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.marilka888.noteapp.models.Note;

import java.util.List;

public interface NoteRepo extends JpaRepository<Note, Long> {
    List<Note> findAllById(Iterable<Long> longs);

    void deleteById(Long id);
}
