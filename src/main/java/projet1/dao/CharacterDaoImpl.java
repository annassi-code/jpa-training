package projet1.dao;

import com.querydsl.jpa.JPQLQuery;
import com.querydsl.jpa.impl.JPAQuery;
import projet1.model.Character;
import projet1.model.QCharacter;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.ArrayList;
import java.util.List;

public class CharacterDaoImpl implements CharacterDao {

    @Override
    public String getEntityName() {
        return Character.class.getSimpleName();
    }

    @Override
    public Class<Character> getEntityClass() {
        return Character.class;
    }

    @Override
    public List<Character> findCharactersByName(String name) {
        EntityManager entityManager = null;
        List<Character> characters = new ArrayList<>();

        try {
            entityManager = entityManagerFactory.createEntityManager();
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            QCharacter character = QCharacter.character;
            JPQLQuery<Character> query = new JPAQuery<>(entityManager);
            characters = query.from(character)
                    .where(character.name.eq(name))
                    .fetch();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
        return characters;
    }
}
