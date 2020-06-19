package projet2.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactorySingleton {

    private static EntityManagerFactory emf = null;

    private EntityManagerFactorySingleton(){
    }

    public static EntityManagerFactory getInstance(){
        if (emf == null){
            emf = Persistence.createEntityManagerFactory("training");
        }
        return emf;
    }
}
