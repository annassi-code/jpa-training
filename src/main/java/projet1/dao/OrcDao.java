package projet1.dao;

import projet1.model.Orc;

import java.util.List;

public interface OrcDao extends GenericDao<Orc, Long> {

     List<Orc> findByRage(String rage);
}
