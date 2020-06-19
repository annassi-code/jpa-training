package projet1.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public interface GenericDao<T, K> {

    EntityManagerFactory entityManagerFactory = EntityManagerFactorySingleton.getInstance();

    abstract String getEntityName();
    abstract Class<T> getEntityClass();

    default List<T> findAll(){
        EntityManager em = null;
        List<T> entities = new ArrayList<>();
        try {
            em = entityManagerFactory.createEntityManager();
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            Query query = em.createQuery("from " + getEntityName() + " a");
            entities = query.getResultList();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
        return entities;
    }

    default T findById(K id){
        EntityManager entityManager = null;
        T entity = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            entity = entityManager.find(getEntityClass(), id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
        return entity;
    }

    default void update(T entity){
        EntityManager entityManager = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.merge(entity);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    default void delete(T entity){
        EntityManager entityManager = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.remove(entity);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    default void deleteByKey(K id){
        EntityManager entityManager = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.remove(entityManager.find(getEntityClass(), id));
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    default void create(T entity){
        EntityManager entityManager = null;
        try{
            entityManager = entityManagerFactory.createEntityManager();
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(entity);
            transaction.commit();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(entityManager != null && entityManager.isOpen()){
                entityManager.close();
            }
        }
    }
}
