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
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
public class HomeController {

    @Autowired
    private PersonService personService;


    @GetMapping("/person")
    public List getAll() {
        return personService.getAll();
    }

    @GetMapping("/person/{pid}")
    public ResponseEntity<Person> read(@PathVariable("pid") int id) {
        try {
            Person person = personService.read(id);
            return ResponseEntity.of(Optional.of(person));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/person/{pid}")
    public void delete(@PathVariable("pid") int id) {
        personService.delete(id);
    }

    @PutMapping("/person/{pid}")
    public void update(@RequestBody Person person, @PathVariable("pid") int id) {
        personService.update(person, id);
    }

    @PostMapping("/person")
    public Person insert(@RequestBody Person person) {
        System.out.println(person.getAddress());
        return personService.insert(person);
    }

    @PostMapping("pic")
    public ResponseEntity pic(@RequestParam("file") MultipartFile file) {

        if (!file.isEmpty()) {
            System.out.println(file.getName());
            System.out.println(file.getSize());
            try {
                byte[] pic = file.getBytes();
                String path = new ClassPathResource("").getFile().getAbsolutePath();
                System.out.println(path);
                FileOutputStream fileOutputStream = new FileOutputStream(path + file.getOriginalFilename());
                fileOutputStream.write(pic);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return ResponseEntity.ok("working");
        } else {

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

}