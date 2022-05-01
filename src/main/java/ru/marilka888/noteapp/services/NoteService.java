package ru.marilka888.noteapp.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.marilka888.noteapp.models.Note;
import ru.marilka888.noteapp.models.User;
import ru.marilka888.noteapp.repositories.NoteRepo;
import ru.marilka888.noteapp.repositories.UserRepo;

import java.security.Principal;

@Service
@Slf4j
@RequiredArgsConstructor
public class NoteService {
    private final NoteRepo noteRepository;
    private final UserRepo userRepository;

    public void saveNote(Principal principal, Note note) {
        note.setUser(getUserByPrincipal(principal));
        log.info("Saving new Note. Title: {}; User number: {}", note.getTitle(), note.getUser().getNumber());
        noteRepository.save(note);
    }

    public User getUserByPrincipal(Principal principal) { //проверка номера
        if (principal == null) return new User();
        return userRepository.findByNumber(principal.getName());
    }

    public void deleteNote(Long id) {
        noteRepository.deleteById(id);
        log.info("Note with id = {} was deleted", id);
    }

    public Note getNoteById(Long id) {
        return noteRepository.findById(id).orElse(null);
    }

}
