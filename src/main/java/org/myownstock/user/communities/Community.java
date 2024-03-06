package org.myownstock.user.communities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.myownstock.user.Users.User;
import org.myownstock.user.cities.City;

import java.util.List;

@Entity
@Getter @Setter
public class Community {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 150, nullable = false, unique = true)
    private String label;

    @Column(length = 60, nullable = false)
    private String address;

    @Column(length = 5, nullable = false)
    private String postalCode;


}
