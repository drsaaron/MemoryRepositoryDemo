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
        
        repo.save(new PersonData("Donald", "Duck", 54));
        repo.save(new PersonData("Daffy", "Duck", 57));
        repo.save(new PersonData("Goofy", "Duck", 22));
        repo.save(new PersonData("Mickey", "Mouse", 33));
        repo.save(new PersonData("Speedy", "Gonzales", 65));
    }
}
