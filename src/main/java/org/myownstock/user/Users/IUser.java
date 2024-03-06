package org.myownstock.user.Users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IUser extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
    public List<User> findByLastname(String lastname);

    public List<User> findByLastnameAndFirstname(String lastname, String firstname);

    @Query("SELECT u FROM User u WHERE u.lastname = :lastname AND u.firstname = :firstname")
    public List<User> getByLastnameAndFirstname(@Param("lastname") String lastname, @Param("firstname") String firstname);


}
