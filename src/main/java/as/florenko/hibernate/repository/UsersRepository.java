package as.florenko.hibernate.repository;

import as.florenko.hibernate.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UsersRepository extends JpaRepository<User, Integer> {
    List<User> findByCity(String city);

    List<User> findByAgeLessThan(int age);

    Optional<User> findByNameAndSurname(String name, String surname);
}
