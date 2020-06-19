package projet2.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class SacemRegistration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="code", unique = true)
    private String code;

    @Column(name="date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date date;

    @OneToOne(fetch = FetchType.LAZY)
    private Artist artist;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }
}
