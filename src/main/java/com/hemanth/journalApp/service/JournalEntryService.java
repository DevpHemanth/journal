package com.hemanth.journalApp.service;

import com.hemanth.journalApp.entity.JournalEntry;
import com.hemanth.journalApp.repository.JournalEntryRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@Slf4j
public class JournalEntryService {

    @Autowired
    JournalEntryRepo journalEntryRepo;

    public JournalEntry addJournalEntry(JournalEntry journalEntry){
        journalEntry.setTimeOfJournal(LocalDate.now());
        return  journalEntryRepo.save(journalEntry);
    }

    public List<JournalEntry> getAllJournalEntry(){
        return journalEntryRepo.findAll();
    }

    public JournalEntry getJournalEntryById(Long id){
        return journalEntryRepo.findById(id).orElse(null);
    }

    public boolean removeJournalEntryById(Long id){

        journalEntryRepo.deleteById(id);
        return true;
    }

    public JournalEntry updateJournalById(Long id,JournalEntry newJournalEntry){

        JournalEntry oldJournalEntry = getJournalEntryById(id);

        if(oldJournalEntry!=null){
            oldJournalEntry.setTimeOfJournal(LocalDate.now());
            oldJournalEntry.setContent(newJournalEntry.getContent()!= null ? newJournalEntry.getContent() : oldJournalEntry.getContent());
            oldJournalEntry.setTitle(!newJournalEntry.getTitle().isEmpty() ? newJournalEntry.getTitle() : oldJournalEntry.getTitle());
        } else {
            throw new NullPointerException("Returned Null from oldJournal object");
        }

        addJournalEntry(oldJournalEntry);

        System.out.println(Math.floor(-5.8));
        return oldJournalEntry;

    }

}
