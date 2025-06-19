package com.hemanth.journalApp.controller;

import com.hemanth.journalApp.entity.JournalEntry;
import com.hemanth.journalApp.service.JournalEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/journal")
public class JournalControllerV2 {

    @Autowired
    JournalEntryService journalEntryService;

    @GetMapping("/getAll")
    public ResponseEntity<?> findAllJournalEntries(){

        List<JournalEntry> journalEntry = journalEntryService.getAllJournalEntry();

        if(journalEntry != null)
            return new ResponseEntity<>(journalEntry, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @GetMapping("/{id}")
    public ResponseEntity<JournalEntry> findJournalEntryById(@PathVariable long id){

        JournalEntry journalEntry = journalEntryService.getJournalEntryById(id);

        if(journalEntry != null)
            return new ResponseEntity<>(journalEntry, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @PostMapping("/add")
    public ResponseEntity<JournalEntry> createNewJournal(@RequestBody JournalEntry myJournalEntry){

       JournalEntry journalEntry = journalEntryService.addJournalEntry(myJournalEntry);

        if(journalEntry != null)
            return new ResponseEntity<>(journalEntry, HttpStatus.CREATED);
        else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<JournalEntry> removeJournalEntry(@PathVariable long id){

        return journalEntryService.removeJournalEntryById(id) ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<JournalEntry> updateJournalEntry(@PathVariable long id,@RequestBody JournalEntry myJournalEntry){

        JournalEntry journalEntry = journalEntryService.updateJournalById(id, myJournalEntry);

        if(journalEntry != null)
            return new ResponseEntity<>(journalEntry, HttpStatus.ACCEPTED);
        else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
