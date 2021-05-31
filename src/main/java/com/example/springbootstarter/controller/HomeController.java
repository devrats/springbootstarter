/*   Created by IntelliJ IDEA.
 *   Author: Devvrat Sharma (devrats)
 *   Date: 5/30/2021
 *   Time: 11:35 AM
 *   File: HomeController.java
 */

package com.example.springbootstarter.controller;

import com.example.springbootstarter.entity.Person;
import com.example.springbootstarter.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HomeController {

    @Autowired
   private PersonService personService;


    @GetMapping("/person")
    public List getAll(){
        return personService.getAll();
    }

    @GetMapping("/person/{pid}")
    public Person read(@PathVariable("pid") int id){
        return personService.read(id);
    }

    @DeleteMapping("/person/{pid}")
    public void delete(@PathVariable("pid") int id){
        personService.delete(id);
    }

    @PutMapping("/person/{pid}")
    public void update(@RequestBody Person person,@PathVariable("pid") int id){
        personService.update(person,id);
    }

    @PostMapping("/person")
    public Person insert(@RequestBody Person person){
        return personService.insert(person);
    }
}