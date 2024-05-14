package com.example.ms1.note.note.tag;

import org.springframework.data.jpa.repository.JpaRepository;

import java.nio.file.LinkOption;

public interface NoteTagRepository extends JpaRepository<NoteTag, Long> {
}
