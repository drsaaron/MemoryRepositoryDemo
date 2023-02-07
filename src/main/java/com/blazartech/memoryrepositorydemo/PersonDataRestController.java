/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.blazartech.memoryrepositorydemo;

import com.blazartech.memoryrepositorydemo.data.PersonData;
import com.blazartech.memoryrepositorydemo.data.PersonDataRepository;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author aar1069
 */
@RestController
@Slf4j
public class PersonDataRestController {
    
    @Autowired
    private PersonDataRepository repo;
    
    @GetMapping("/person")
    public List<PersonData> getAllPersons() {
        log.info("getting all persons");
        Iterable<PersonData> i = repo.findAll();
        List<PersonData> l = new ArrayList<>();
        i.forEach(l::add);
        return l;
    }
    
    @GetMapping("/person/{firstName}")
    public List<PersonData> getPeopleByFirstName(@PathVariable String firstName) {
        log.info("getting people of first name {}", firstName);
        return repo.findByFirstName(firstName);
    }
}
