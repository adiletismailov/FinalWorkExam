package com.company;

import com.company.dao.Database;
import com.company.enums.Gender;
import com.company.model.Animal;
import com.company.model.Person;
import com.company.service.GenericService;
import com.company.service.impl.AnimalServiceImpl;
import com.company.service.impl.PersonServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
//1) Жаны проект тузунуз.
//2) 3 жаны пакет тузунуз - model, service, dao.
//3) model пакеттин ичине Person,Animal деген класс тузунуз, свойствалары - id, name, age, Gender,
// Genderди enum кылып башка пакетке тузуп койсонуз болот.
//            4) dao пакеттин ичине Database деген класс тузунуз, ичинде 2 свойствасы болот - userлер, animalдар.
//            Бул класс биздин база данныхыбыз болот.
//            5) service пакеттин ичине GenericService деген generic interface тузунуз жана impl деген пакет тузуп коюнуз.
//            6) GenericServiceтин ичинде 7 метод болот:
//            - String add(List<T>t);
//- User getById(Long id);
//- String removeByName(String name);
//- List<T> getAll();
//- List<T> sortByName(); 1 ди басканда ascending, 2 ни басканда descending кылып сорттосун
//- List<T> filterByGender(); 1 ди басканда female, 2 ни басканда male кылып фильтрлесин
//- List<T> clear();
//7) impl пакеттин ичине PersonServiceImpl, AnimalServiceImpl деген класстарды тузунуз, бул класстар GenericService
// интерфейсин ишке ашырат жана бул класстарда свойства катары биздин база данныхыбыз болот(Database).
//            8) Класстарда GenericService интерфейсинин бардык методдорун ишке ашырыныз. PersonServiceImpl методдору
//            стандарттык турдо ал эми AnimalServiceImpl методдору stream аркылуу ишке ашырылсын.
//            9) Main класста бардык методдорду чакырып иштетиниз.
    public static void main(String[] args) {
        GenericService<Person> personGenericService = new PersonServiceImpl();
        GenericService<Animal> animalGenericService = new AnimalServiceImpl();

        Person person1 = new Person(1,"Adilet",20, Gender.MALE);
        Person person2 = new Person(2,"Alibek",19, Gender.MALE);
        Person person3 = new Person(3,"Joni",18, Gender.FEMALE);
        Person person4 = new Person(4,"Meerim",21, Gender.FEMALE);
        Person person5 = new Person(5,"Kurstan",17, Gender.MALE);
        List<Person> people = new ArrayList<>(List.of(person1,person2,person3,person4,person5));

        Animal animal1 = new Animal(1,"Dog",3,Gender.MALE);
        Animal animal2 = new Animal(2,"Cat",2,Gender.FEMALE);
        Animal animal3 = new Animal(3,"Dog",1,Gender.MALE);
        Animal animal4 = new Animal(4,"Cat",4,Gender.FEMALE);
        Animal animal5 = new Animal(5,"Dog",5,Gender.MALE);
        List<Animal> animals = new ArrayList<>(List.of(animal1,animal2,animal3,animal4,animal5));

        while (true){
            System.out.print("""
                    1. add:
                    2. getById:
                    3. removeByName:
                    4. getAll:
                    5. sortByName:
                    6. filterByGender:
                    7. clear:
                    
                    Write a command:""");
            int number = new Scanner(System.in).nextInt();
            switch (number){
                case 1 -> System.out.println(personGenericService.add(people));
                case 2 -> System.out.println(personGenericService.getById(new Scanner(System.in).nextLong()));
                case 3 -> System.out.println(personGenericService.removeByName(new Scanner(System.in).nextLine()));
                case 4 -> System.out.println(personGenericService.getAll());
                case 5 -> System.out.println(personGenericService.sortByName());
                case 6 -> System.out.println(personGenericService.filterByGender());
                case 7 -> System.out.println(personGenericService.clear());
            }
        }
    }
}