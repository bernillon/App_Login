package org.myownstock.user.Users;

import org.myownstock.user.helpers.services.Service;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService extends Service<User> {
    public User add(User user);

    public List<User> findAll();

    public ResponseEntity<?> update(User user);

    public User findById(Long id);

    public void deleteById(Long id);

    User authenticate(String email, String password);


}
