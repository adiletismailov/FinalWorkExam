package com.company.service.impl;

import com.company.dao.Database;
import com.company.enums.Gender;
import com.company.model.Animal;
import com.company.service.GenericService;

import java.util.Comparator;
import java.util.List;

public class AnimalServiceImpl implements GenericService<Animal> {
    Database database = new Database();

    @Override
    public String add(List<Animal> t) {
        database.getAnimals().addAll(t);
        return "Successful";
    }

    @Override
    public Animal getById(Long id) {
        Animal animal = null;
        for (Animal a : database.getAnimals()) {
            if (a.getId() == id) {
                animal = a;
            } else {
                System.out.println("Not bound");
            }
            break;
        }
        return animal;
    }

    @Override
    public String removeByName(String name) {
        database.getAnimals().removeIf(a -> a.getName().equals(name));
        return "Successful";
    }

    @Override
    public List<Animal> getAll() {
        return database.getAnimals();
    }

    @Override
    public List<Animal> sortByName() {
        return database.getAnimals().stream().sorted(Comparator.comparing(Animal::getName)).toList();
    }

    @Override
    public List<Animal> filterByGender() {
        database.getAnimals().stream().filter(a -> a.getGender().equals(Gender.MALE)).toList().forEach(System.out::println);
        return database.getAnimals().stream().filter(a -> a.getGender().equals(Gender.FEMALE)).toList();
    }

    @Override
    public List<Animal> clear() {
        database.getAnimals().clear();
        return database.getAnimals();
    }
}
