/*   Created by IntelliJ IDEA.
 *   Author: Devvrat Sharma (devrats)
 *   Date: 5/30/2021
 *   Time: 11:11 AM
 *   File: PersonRepository.java
 */

package com.example.springbootstarter.repository;

import com.example.springbootstarter.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface PersonRepository extends JpaRepository<Person, Integer> {

}