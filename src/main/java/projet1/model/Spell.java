package projet1.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class Spell extends LevelElement {
    private int cost;
    private int damage;

    public Spell(String name, int level) {
        super(name, level);
    }
}
