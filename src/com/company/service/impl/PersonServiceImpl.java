package com.company.service.impl;

import com.company.dao.Database;
import com.company.enums.Gender;
import com.company.model.Person;
import com.company.service.GenericService;


import java.util.Comparator;
import java.util.List;

public class PersonServiceImpl implements GenericService<Person> {
    Database database = new Database();


    @Override
    public String add(List<Person> t) {
        database.getPeople().addAll(t);
        return "Uspeshno: ";
    }

    @Override
    public Person getById(Long id) {
        Person person = null;
            for (Person p : database.getPeople()) {
                if (p.getId() == id) {
                    person = p;
                }else {
                    System.out.println("Not bound");
                }
                break;
            }
        return person;
    }

    @Override
    public String removeByName(String name) {
        database.getPeople().removeIf(person -> person.getName().equals(name));
        return "Name deleted! ";
    }

    @Override
    public List<Person> getAll() {
        return database.getPeople();
    }

    @Override
    public List<Person> sortByName() {
        return database.getPeople().stream().sorted(Comparator.comparing(Person::getName)).toList();
    }

    @Override
    public List<Person> filterByGender() {
        database.getPeople().stream().filter(p -> p.getGender().equals(Gender.MALE)).toList().forEach(System.out::print);
        return database.getPeople().stream().filter(p -> p.getGender().equals(Gender.FEMALE)).toList();
    }

    @Override
    public List<Person> clear() {
       database.getPeople().clear();
        return database.getPeople();
    }
}