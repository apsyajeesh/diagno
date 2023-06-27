package com.perscholas.persistence.repo;

import com.perscholas.persistence.model.Note;
import com.perscholas.persistence.model.User;
import org.springframework.data.repository.CrudRepository;

public interface NoteRepository extends CrudRepository<Note, Long> {
}
