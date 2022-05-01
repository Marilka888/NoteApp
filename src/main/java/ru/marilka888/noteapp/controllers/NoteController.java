package ru.marilka888.noteapp.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.marilka888.noteapp.models.Note;
import ru.marilka888.noteapp.models.User;
import ru.marilka888.noteapp.services.NoteService;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class NoteController {
    private final NoteService noteService;
    private static List<Note> noteList = new ArrayList<Note>();


    @GetMapping("/")
    public String notes(Principal principal, Model model) {
        model.addAttribute("user", noteService.getUserByPrincipal(principal));
        return "profile";
    }

    @GetMapping("/note/{id}")
    public String noteInfo(@PathVariable Long id, Model model, Principal principal) {
        Note note = noteService.getNoteById(id);
        model.addAttribute("user", noteService.getUserByPrincipal(principal));
        model.addAttribute("note", note);
        return "note-info";
    }

    @PostMapping("/notes/create")
    public String createNote(Note note, Principal principal) {
        noteService.saveNote(principal, note);
        return "redirect:/my/notes";
    }

    @PostMapping("/note/delete/{id}")
    public String deleteNote(@PathVariable Long id) {
        noteService.deleteNote(id);
        return "redirect:/my/notes";
    }

    @GetMapping("/my/notes")
    public String userNotes(Principal principal, Model model) {
        User user = noteService.getUserByPrincipal(principal);
        model.addAttribute("user", user);
        model.addAttribute("notes", user.getNotes());
        return "my-notes";
    }

}
