package JPA;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public final class JPAUtil {
    private JPAUtil () {
    }
    private static final EntityManagerFactory FACTORY = 
            Persistence.createEntityManagerFactory("abreconexao");

    public static EntityManager getEntityManager() {
        return FACTORY.createEntityManager();
    }
}

