package projet2.dao;

import projet2.model.Artist;
import projet2.model.InstrumentType;

import java.util.List;

public interface ArtistDAO extends GenericDAO<Artist,Long>{
    List<Artist> findByInstrumentType(InstrumentType instrumentType);
}
