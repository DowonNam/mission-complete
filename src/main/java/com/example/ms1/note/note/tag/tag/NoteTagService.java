package com.example.ms1.note.note.tag.tag;

import com.example.ms1.note.note.Note;
import com.example.ms1.note.note.NoteService;
import com.example.ms1.note.note.tag.NoteTag;
import com.example.ms1.note.note.tag.NoteTagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NoteTagService {
    private final NoteTagRepository noteTagRepository;
    private final NoteService noteService;
    private final TagService tagService;

    public NoteTag getNoteTag(Long noteTagId) {
        return noteTagRepository.findById(noteTagId).orElseThrow();
    }

    public NoteTag create(Long noteId, String name) {
        Note note = noteService.getNote(noteId);
        Tag tag = tagService.create(name);

        NoteTag noteTag = new NoteTag();
        noteTag.setNote(note);
        noteTag.setTag(tag);

        return noteTagRepository.save(noteTag);
    }

    public void delete(Long noteTagId) {
        noteTagRepository.deleteById(noteTagId);
    }
}
