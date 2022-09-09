package as.florenko.hibernate.repository;

import as.florenko.hibernate.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UsersRepository extends CrudRepository<User, Integer> {
    @Query("select u from User u where u.city = :city")
    List<User> findByCity(@Param("city") String city);

    @Query("select u from User u where u.age < :age")
    List<User> findByAgeLessThan(@Param("age") int age);

    @Query("select u from User u where u.name = :name and u.surname = :surname")
    Optional<User> findByNameAndSurname(@Param("name") String name, @Param("surname") String surname);
}
