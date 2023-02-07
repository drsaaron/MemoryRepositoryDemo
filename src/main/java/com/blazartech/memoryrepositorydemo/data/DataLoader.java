/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.blazartech.memoryrepositorydemo.data;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author aar1069
 */
@Component
public class DataLoader {
    
    @Autowired
    private PersonDataRepository repo;
    
    @PostConstruct
    private void initializeData() {
        
        repo.deleteAll();
        
        repo.save(new PersonData("Scott", "Aaron", 54));
        repo.save(new PersonData("Katheen", "Aaron", 57));
        repo.save(new PersonData("Sarah", "Aaron", 22));
        repo.save(new PersonData("Issak", "Huntley", 33));
        repo.save(new PersonData("Pauline", "Paha", 65));
    }
}
