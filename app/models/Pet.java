package models;

import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 */
@Entity
public class Pet extends Model {

    @ManyToOne(optional = false)
    public Person owner;

    public String name;

    public PetType type;

}
