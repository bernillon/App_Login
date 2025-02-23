package org.myownstock.user.Users;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.myownstock.user.roles.Role;

import java.time.LocalDate;

/**
 * This class allows to validate credentials
 * and convert them to a basic user object
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Credentials {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 75, nullable = false)
    private String lastname;

    @Column(length = 75)
    private String firstname;

    @Column(unique = true)
    @Size(min = 6)
    @Email
    private String email;

    @Column(nullable = false)
    private LocalDate birthdate;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private Role role;

    @Column(name="password")
    @Pattern(regexp="(?=.*[A-Za-z])(?=.*[0-9])[A-Za-z-0-9]{8,}", message = "Minimum eight characters, at least one letter and one number")
    private String password;

    // TODO: we can also decide to handle the hashing logic here while converting to user
    public User toUser() {
        return new User(this.id, this.lastname, this.firstname, this.email, this.password, this.birthdate, this.role);
    }
}
