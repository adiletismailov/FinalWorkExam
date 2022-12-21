package com.company.dao;

import com.company.model.Animal;
import com.company.model.Person;

import java.util.ArrayList;
import java.util.List;

public class Database {
    private List<Person> people = new ArrayList<>();
    private List<Animal> animals = new ArrayList<>();


    public List<Person> getPeople() {
        return people;
    }

    public void setPeople(List<Person> people) {
        this.people = people;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }
}