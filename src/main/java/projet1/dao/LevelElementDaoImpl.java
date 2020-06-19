package projet1.dao;

import projet1.model.LevelElement;

public class LevelElementDaoImpl implements LevelElementDao {
    @Override
    public String getEntityName() {
        return LevelElement.class.getSimpleName();
    }

    @Override
    public Class<LevelElement> getEntityClass() {
        return LevelElement.class;
    }
}
