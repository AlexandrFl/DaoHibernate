package as.florenko.hibernate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

@Component
public class Repository implements CommandLineRunner {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        var names = List.of("Женя", "Даша", "Маша", "Ибрагим");
        var cities = List.of("Москва", "Самара", "Мурманск", "Магадан");
        var surnames = List.of("Иванов", "Петров", "Васильев", "Семенов");
        var random = new Random();
        IntStream.range(0, 50)
                .forEach(i -> {
                    var user = User.builder()
                            .name(names.get(random.nextInt(names.size())))
                            .surname(surnames.get(random.nextInt(surnames.size())))
                            .age(random.nextInt(60))
                            .number(String.valueOf(8923456 + i))
                            .city(cities.get(random.nextInt(cities.size())))
                            .build();
                    entityManager.persist(user);
                });
    }

    public List findByCity(String city) {
        List users;
        Query query = entityManager.createQuery("select u from User u where u.city=:city");
        query.setParameter("city", city);
        users = query.getResultList();
        return users;
    }
}
