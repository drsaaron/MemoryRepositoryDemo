/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.blazartech.memoryrepositorydemo.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 *
 * @author aar1069
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
@Slf4j
public class PersonDataRepositoryTest {

    @Autowired
    private PersonDataRepository instance;

    public PersonDataRepositoryTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of findByFirstName method, of class PersonDataRepository.
     */
    @Test
    public void testFindByFirstName() {
        log.info("findByFirstName");
        String firstName = "Daffy";
        List<PersonData> result = instance.findByFirstName(firstName);
        assertEquals(1, result.size());
    }
    
    @Test
    public void testFindAll() {
        log.info("testFindAll");
        Iterable<PersonData> result = instance.findAll();
        List<PersonData> personData = new ArrayList<>();
        result.forEach(personData::add);
        
        assertEquals(5, personData.size());
    }
    
    @Test
    public void testSave() {
        log.info("testSave");
        PersonData newPerson = new PersonData("Henrietta", "Mcelhoney", 54);
        instance.save(newPerson);
        Iterable<PersonData> data = instance.findAll();
        List<PersonData> personData = new ArrayList<>();
        data.forEach(personData::add);
        
        assertEquals(6, personData.size());
        
        Optional<PersonData> op = instance.findById(6L);
        assertTrue(op.isPresent());
        assertEquals(newPerson.getFirstName(), op.get().getFirstName());
    }

}
