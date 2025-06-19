package com.hemanth.journalApp.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document("journal_entries")
@Data
public class JournalEntry {

    @Id
    private long id;
    private String title;
    private String content;
    private LocalDate timeOfJournal;

}
