package org.myownstock.user.Users.auth;

import org.myownstock.user.Users.IUser;
import org.myownstock.user.Users.User;
import org.myownstock.user.Users.utils.HashUtils;
import org.myownstock.user.Users.utils.TokenUtils;
import org.myownstock.user.roles.IRole;
import org.myownstock.user.roles.Role;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class AuthService {

    private static final Logger log = LoggerFactory.getLogger(AuthService.class);
    private final IUser userRepository;
    private final HashUtils hashUtils;

    @Autowired
    public AuthService(HashUtils hashUtils, IUser userRepository) {
        this.hashUtils = hashUtils;
        this.userRepository = userRepository;
    }

    public User signUp(User u){
        String passwordRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[\\W_])[A-Za-z\\d\\W_]{8,}$";

        if (!u.getPassword().matches(passwordRegex)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Le mot de passe doit contenir au moins une majuscule, une minuscule, un chiffre, un caractère spécial et avoir 8 caractères minimum.");
        }

        Optional<User> existingUser = this.userRepository.findIfEmailExist(u.getEmail());
        if (existingUser.isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Un utilisateur avec cet e-mail existe déjà.");
        }

        u.setPassword(this.hashUtils.generate(u.getPassword()));
        return this.userRepository.save(u);
    }

    public User signIn(User u) {
        String passwordRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[\\W_])[A-Za-z\\d\\W_]{8,}$";

        // Vérification du format du mot de passe
        if (!u.getPassword().matches(passwordRegex)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Le mot de passe doit contenir au moins une majuscule, une minuscule, un chiffre, un caractère spécial et avoir 8 caractères minimum.");
        }

        return this.userRepository.findByEmailAndPwd(u.getEmail(), this.hashUtils.generate(u.getPassword()))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Email ou mot de passe incorrect"));
    }

    public String generateToken(User user) {
        return TokenUtils.generateJWT(user);
    }
}
