package projet2.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NamedQuery(name = "findByFavInstrumentType", query = "select a from Artist a where a.favouriteInstrument.type = :instrumentType")
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Artist extends Person{

    private String bandName;
    private Integer size;

    @ManyToOne
    @EqualsAndHashCode.Exclude
    private Manager manager;

    @ManyToOne
    private Instrument favouriteInstrument;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable( name="ARTIST_INSTRUMENTS",
            joinColumns = @JoinColumn(name="artist"),
            inverseJoinColumns = @JoinColumn(name="instrument"))
    private List<Instrument> playableInstruments = new ArrayList<>();

    @OneToOne(cascade = CascadeType.REMOVE)
    private SacemRegistration sacemRegistration;

    @OneToMany(mappedBy = "artist")
    private List<Media> medias = new ArrayList<>();
    
    public Artist(String firstName, String lastName, String bandName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.bandName = bandName;
    }
}
