package org.myownstock.user.cities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.myownstock.user.Users.User;


@Entity
@Getter @Setter
@Table(name = "city")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "insee_code", length = 5, nullable = false, unique = true)
    private String inseeCode;

    @Column(length = 5, nullable = false)
    private String postalCode;

    @Column(length = 75, nullable = false)
    private String name;

}
