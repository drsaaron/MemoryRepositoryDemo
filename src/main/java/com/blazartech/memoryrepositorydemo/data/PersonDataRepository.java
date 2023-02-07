/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.blazartech.memoryrepositorydemo.data;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author aar1069
 */
@Repository
public interface PersonDataRepository extends CrudRepository<PersonData, Long> {
    
    List<PersonData> findByFirstName(String firstName);
}
