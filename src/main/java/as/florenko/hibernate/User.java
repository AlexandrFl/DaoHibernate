package as.florenko.hibernate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users_table")
public class User {
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;

    private int age;

    private String number;

    private String city;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
}

