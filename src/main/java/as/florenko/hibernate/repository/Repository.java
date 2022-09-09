package as.florenko.hibernate.repository;

import as.florenko.hibernate.Response;
import as.florenko.hibernate.User;
import as.florenko.hibernate.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class Repository {

    private final UsersRepository usersRepository;

    public ResponseEntity<Object> findByCity(String city) {
        List<User> list = usersRepository.findByCity(city);
        if (list.isEmpty()) {
            return new Response().notFoundResponse("Нет пользователя с городом " + city.toUpperCase());
        }
        return new Response().correctResponse(list);
    }

    public ResponseEntity<Object> findByAge(int age) {
        List<User> list = usersRepository.findByAgeLessThan(age);
        if (list.isEmpty()) {
            return new Response().notFoundResponse("Нет пользователей младше " + age);
        }
        return new Response().correctResponse(list);
    }

    public ResponseEntity<Object> findByNameAdnSurname(String name, String surname) {
        Optional<User> user = usersRepository.findByNameAndSurname(name, surname);
        if (user.isEmpty()) {
            return new Response().notFoundResponse("Нет пользователей с именем " + name.toUpperCase() + " и фамилией " + surname.toUpperCase());
        }
        return new Response().correctResponse(user.stream().toList());
    }
}
