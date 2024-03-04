package org.myownstock.user.communities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.myownstock.user.cities.City;

@Entity
@Getter @Setter
public class Community {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 150, nullable = false, unique = true)
    private String label;

    @Column(length = 10, nullable = false)
    private String streetNumber;

    @Column(length = 60, nullable = false)
    private String address;

    @Column(length = 60, nullable = true)
    private String addressDetail;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private City city;


}
