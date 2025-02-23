package org.myownstock.user.Users;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.myownstock.user.roles.Role;
import java.time.LocalDate;

@Entity
@Getter @Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 75, nullable = false)
    private String lastname;

    @Column(length = 75)
    private String firstname;

    @Column(nullable = false, unique = true)
    @Email
    @NotNull
    private String email;

    @Column(nullable = false)
    @Pattern(regexp="(?=.*[A-Za-z])(?=.*[0-9])[A-Za-z-0-9]{8,}", message = "Minimum eight characters, at least one letter and one number")
    @NotNull
    private String password;

    @Column(nullable = false)
    private LocalDate birthdate;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private Role role;

    public User(String email, String password, LocalDate birthdate) {
        this.email = email;
        this.password = password;
        this.birthdate = birthdate;
    }

    public User toPublicUser() {
        this.setPassword(null); // pwd will appear on serialization but empty
        return this;
    }
}
