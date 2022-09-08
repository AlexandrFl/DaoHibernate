package as.florenko.hibernate;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Component
public class Repository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public List findByCity(String city) {
        List users;
        Query query = entityManager.createQuery("select u from User u where u.city=:city");
        query.setParameter("city", city);
        users = query.getResultList();
        return users;
    }
}
