package org.myownstock.user.communities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.myownstock.user.Users.User;

@Entity
@Table(name = "user_to_community")
@Getter @Setter
public class UserToCommunity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "community_id")
    private Community community;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
