package projet1.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Item extends LevelElement {

    private int durability;

    @Enumerated(EnumType.STRING)
    private Color color;

    @ManyToMany(mappedBy = "items")
 /*   @JoinTable(joinColumns = {
            @JoinColumn(name = "LEVEL"),
            @JoinColumn(name = "NAME")},
            inverseJoinColumns = @JoinColumn(name = "CHARACTER_ID"))*/
    private List<Character> characters = new ArrayList<Character>();

    public Item() {
    }

    public Item(String name, int level) {
        super(name, level);
    }

    public Item(LevelElementId id, int durability, Color color) {
        super(id);
        this.durability = durability;
        this.color = color;
    }
}
