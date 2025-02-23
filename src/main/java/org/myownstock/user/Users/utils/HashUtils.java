package org.myownstock.user.Users.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

@Component
public class HashUtils {

    @Value("${spring.application.security.hash.algo}")
    private String algo;

    @Value("${spring.application.security.hash.salt}")
    private String salt;

    public String generate(String value) {
        try {
            System.out.println(value);
            MessageDigest md = MessageDigest.getInstance(algo);
            md.update(salt.getBytes());
            byte[] hash = md.digest(value.getBytes());
            var test = Base64.getEncoder().encodeToString(hash);
            System.out.println("----- hash -----");
            System.out.println(test);
            return test;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

}
