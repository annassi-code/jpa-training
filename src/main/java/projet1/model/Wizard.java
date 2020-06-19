package projet1.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class Wizard extends Character {
    private String magic;

    public Wizard(String name, int health, int strength, int level) {
        super(name, health, strength, level);
    }

    public Wizard(String name, User user) {
        super(name, user);
    }
}
