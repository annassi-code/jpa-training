package projet2.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Instrument {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Enumerated(EnumType.STRING)
    private InstrumentType instrumentType;

    @ManyToMany(mappedBy = "playableInstruments")
    private List<Artist> artists = new ArrayList<>();

    @OneToMany(mappedBy = "favoriteInstrument")
    List<Artist> artistsForWhichItsFavorite;

    @ManyToMany(mappedBy = "playableInstruments")
    List<Artist> artistsWhichCanPlay;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public InstrumentType getInstrumentType() {
        return instrumentType;
    }

    public void setInstrumentType(InstrumentType type) {
        this.instrumentType = type;
    }

    public List<Artist> getArtists() {
        return artists;
    }

    public void setArtists(List<Artist> artists) {
        this.artists = artists;
    }
}
