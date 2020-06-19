package projet1.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactorySingleton {

    private static EntityManagerFactory emf = null;

    private EntityManagerFactorySingleton(){

    }

    public static EntityManagerFactory  getInstance(){
        return emf == null ?
            emf = Persistence.createEntityManagerFactory("training") : emf;
    }
}
