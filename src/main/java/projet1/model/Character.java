package projet1.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Character {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int health;
    private int strength;
    private int level;

    @ManyToOne
    private User user;
/*
    @ManyToMany
    @JoinTable( name="CHARACTER_ITEMS",
            inverseJoinColumns = {@JoinColumn(name="item_level"),
                        @JoinColumn(name="item_name")},
            joinColumns = @JoinColumn(name="character_id"))
    private List<Item> items = new ArrayList<Item>();
*/
    public Character(String name, int health, int strength, int level){
        this.name = name;
        this.health = health;
        this.strength = strength;
        this.level = level;
    }


    public Character(String name, User user) {
        this.name = name;
        this.user = user;
    }
}
