package projet1.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED )
public abstract class LevelElement {

    @EmbeddedId
    private LevelElementId id;

    public LevelElement(){ }

    public LevelElement(String name, int level){
        this.id = new LevelElementId(name, level);
    }

    public LevelElement(LevelElementId id) {
        this.id = id;
    }
}
