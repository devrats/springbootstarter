/*   Created by IntelliJ IDEA.
 *   Author: Devvrat Sharma (devrats)
 *   Date: 5/30/2021
 *   Time: 11:08 AM
 *   File: Person.java
 */

package com.example.springbootstarter.entity;



import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pId;
    private String name;

    @Override
    public String toString() {
        return "Person{" +
                "pId=" + pId +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", phone=" + phone +
                ", spouse='" + spouse + '\'' +
                ", address=" + address +
                '}';
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    private int age;
    private long phone;
    private String spouse;

    public Person(String name, int age, long phone, String spouse, Address address) {
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.spouse = spouse;
        this.address = address;
    }

    public Person(int pId, String name, int age, long phone, String spouse, Address address) {
        this.pId = pId;
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.spouse = spouse;
        this.address = address;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JsonManagedReference
    private Address address;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return getpId() == person.getpId() && getAge() == person.getAge() && getPhone() == person.getPhone() && Objects.equals(getName(), person.getName()) && Objects.equals(getSpouse(), person.getSpouse());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getpId(), getName(), getAge(), getPhone(), getSpouse());
    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getSpouse() {
        return spouse;
    }

    public void setSpouse(String spouse) {
        this.spouse = spouse;
    }

    public Person() {
    }

    public Person(String name, int age, long phone, String spouse) {
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.spouse = spouse;
    }

    public Person(int pId, String name, int age, long phone, String spouse) {
        this.pId = pId;
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.spouse = spouse;
    }
}