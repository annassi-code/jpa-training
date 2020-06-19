package projet2.dao;

import projet2.model.Artist;
import projet2.model.Instrument;
import projet2.model.InstrumentType;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class ArtistImplDAO implements ArtistDAO {

    static EntityManagerFactory emf = EntityManagerFactorySingleton.getInstance();

    @Override
    public List<Artist> findByInstrumentType(InstrumentType instrumentType) {
        EntityManager em = null;
        List<Artist> artists = new ArrayList<>();

        try {
            em = emf.createEntityManager();
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Artist> queryCriteria = cb.createQuery(Artist.class);
            Root<Artist> queryRoot = queryCriteria.from(Artist.class);
            queryCriteria.select(queryRoot);
            Query criteriaQuery = em.createQuery(queryCriteria);

            artists = criteriaQuery.getResultList();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
        return artists;
    }

    @Override
    public List<Artist> findAll() {
        EntityManager em = null;
        List<Artist> artists = new ArrayList<>();
        try {
            em = emf.createEntityManager();
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            Query query = em.createQuery("from Artist a");
            artists = query.getResultList();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
        return artists;
    }

    @Override
    public Artist findById(Long id) {
        EntityManager em = null;
        Artist artist = null;
        try {
            em = emf.createEntityManager();
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            artist = em.find(Artist.class, 101);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
        return artist;
    }

    @Override
    public void update(Artist entity) {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.merge(entity);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    }

    @Override
    public void delete(Artist entity) {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(entity);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }

    }

    @Override
    public void deleteByKey(Long id) {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(em.find(Artist.class, id));
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    }

    @Override
    public void create(Artist entity) {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.persist(entity);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    }
}
