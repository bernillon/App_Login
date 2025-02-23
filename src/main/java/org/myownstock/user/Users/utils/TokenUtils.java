package org.myownstock.user.Users.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.myownstock.user.Users.User;

import java.time.Instant;
import java.util.Date;

public class TokenUtils {

    private static final String secret = "eyJhbGciOiJIUzUxMiJ9eyJSb2xlIjoiQWRtaW4iLCJJc3N1ZXIiOiJJc3N1ZXIiLCJVc2VybmFtZSI6IkphdmFJblVzZSIsImV4cCI6MTcwOTAzMzgzNiwiaWF0IjoxNzA5MDMzODM2fQWITUkA9Ekg6LnBU7yKh7zDzUQonoQmY3t2FBzGCNP5NACstFBvipr431B8vAl9Odq6uDUHdGIxA7dKl6hEA";

    public static String generateJWT(User u){
        long nowMillis = System.currentTimeMillis();
        long expMillis = nowMillis + 10000; //10sec for the moment but in the futur Token have 1h of validity
        Date now = new Date(nowMillis);
        Date exp = new Date(expMillis);

        return JWT.create()
                .withClaim("email", u.getEmail())
                .withClaim("datetime-claim", Instant.now())
                .withClaim("createdAt", now)
                .withClaim("expiresAt",exp)
                .withExpiresAt(exp)
                .sign(Algorithm.HMAC512(secret));
    }

    public static DecodedJWT decodedJWT(String token) {
        return JWT.require(Algorithm.HMAC512(secret)).build().verify(token);
    }
}
