package projet2.dao;

import java.util.List;

public interface GenericDAO<T, K> {
     List<T> findAll();
     T findById(K id);
     void update(T entity);
     void delete(T entity);
     void deleteByKey(K id);
     void create(T entity);
}
