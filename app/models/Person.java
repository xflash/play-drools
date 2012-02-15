package models;

import play.db.jpa.Model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

/**
 */
@Entity
public class Person extends Model {
    
    public String name;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    public Set<Pet> pets = new HashSet<Pet>();

}
