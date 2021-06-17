/*   Created by IntelliJ IDEA.
 *   Author: Devvrat Sharma (devrats)
 *   Date: 5/30/2021
 *   Time: 11:22 AM
 *   File: PersonService.java
 */

package com.example.springbootstarter.service;

import com.example.springbootstarter.entity.Person;
import com.example.springbootstarter.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Period;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Component
public class PersonService {

    PersonRepository personRepository;

    public Person insert(Person person){
        Person save = personRepository.save(person);
        return save;
    }

    public void delete(int id){
        personRepository.deleteById(id);
    }

    public Person read(int id)  {
        Optional<Person> byId = personRepository.findById(id);
        Person person = byId.get();
        return person;
    }

    public Person update(Person person, int id){
        person.setpId(id);
        return personRepository.save(person);
    }

    public PersonRepository getPersonRepository() {
        return personRepository;
    }

    @Autowired
    public void setPersonRepository(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List getAll(){
        return personRepository.findAll();
    }

}