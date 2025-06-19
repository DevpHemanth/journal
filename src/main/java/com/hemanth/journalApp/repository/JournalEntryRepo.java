package com.hemanth.journalApp.repository;

import com.hemanth.journalApp.entity.JournalEntry;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JournalEntryRepo extends MongoRepository<JournalEntry,Long> {
}
