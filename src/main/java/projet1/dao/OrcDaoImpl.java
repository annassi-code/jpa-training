package projet1.dao;

import projet1.model.Orc;

import java.util.List;

public class OrcDaoImpl implements OrcDao {

    @Override
    public String getEntityName() {
        return Orc.class.getSimpleName();
    }

    @Override
    public Class<Orc> getEntityClass() {
        return Orc.class;
    }


    @Override
    public List<Orc> findByRage(String rage) {
        return null;
    }
}





