package models;

/**
 * User: rcoqueugniot
 * Date: 01.02.12
 * Time: 17:20
 */
public class Pet {

    public String name;


    public PetType type;

    public Pet(PetType type, String name) {
        this.type = type;
        this.name = name;
    }
}
