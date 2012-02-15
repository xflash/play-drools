package models;

import java.util.HashSet;
import java.util.Set;

/**
 */
public class Person {
    
    public String name;

    public Set<Pet> pets = new HashSet<Pet>();

    public Person(String name) {
        this.name = name;
    }

    public void cat(String petName) {
        pets.add(pet(petName, PetType.CAT));
    }
    public void dog(String petName) {
        pets.add(pet(petName, PetType.DOG));
    }

    private Pet pet(String petName, PetType petType) {
        return new Pet(petType, petName);
    }
}
