package com.hemanth.journalApp.entity;

import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "user")
@Data
public class User {

    @Id
    private long id;
    @Indexed(unique = true)
    @NonNull
    private String userName;
    @NonNull
    private String userPassword;
    @DBRef
    private List<JournalEntry> userJournalEntry = new ArrayList<>();
}
