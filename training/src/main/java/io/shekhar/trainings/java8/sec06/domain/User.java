package io.shekhar.trainings.java8.sec06.domain;

import java.util.Optional;

/**
 * Created by shekhargulati on 20/09/15.
 */
public class User {

    private final String username;
    private final Optional<String> address;

    public User(String username) {
        this.username = username;
        this.address = Optional.empty();
    }

    public User(String username, String address) {
        this.username = username;
        this.address = Optional.ofNullable(address);
    }

    public String getUsername() {
        return username;
    }

    public Optional<String> getAddress() {
        return address;
    }
}
