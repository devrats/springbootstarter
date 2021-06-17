/*   Created by IntelliJ IDEA.
 *   Author: Devvrat Sharma (devrats)
 *   Date: 6/16/2021
 *   Time: 8:59 PM
 *   File: Address.java
 */

package com.example.springbootstarter.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Address {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int aId;
    private int hNumber;
    private String street;

    public Address() {
    }

    private String city;
    private String state;
    @OneToOne(mappedBy = "address")
    @JsonBackReference
    private Person person;

    public Address(int hNumber, String street, String city, String state, Person person) {
        this.hNumber = hNumber;
        this.street = street;
        this.city = city;
        this.state = state;
        this.person = person;
    }

    @Override
    public String toString() {
        return "Address{" +
                "aId=" + aId +
                ", hNumber=" + hNumber +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;
        Address address = (Address) o;
        return getaId() == address.getaId() && gethNumber() == address.gethNumber() && Objects.equals(getStreet(), address.getStreet()) && Objects.equals(getCity(), address.getCity()) && Objects.equals(getState(), address.getState()) && Objects.equals(getPerson(), address.getPerson());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getaId(), gethNumber(), getStreet(), getCity(), getState(), getPerson());
    }

    public int getaId() {
        return aId;
    }

    public void setaId(int aId) {
        this.aId = aId;
    }

    public int gethNumber() {
        return hNumber;
    }

    public void sethNumber(int hNumber) {
        this.hNumber = hNumber;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Address(int aId, int hNumber, String street, String city, String state, Person person) {
        this.aId = aId;
        this.hNumber = hNumber;
        this.street = street;
        this.city = city;
        this.state = state;
        this.person = person;
    }
}