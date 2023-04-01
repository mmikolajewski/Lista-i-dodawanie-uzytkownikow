package com.ciastek.list;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UsersRepository {
    private List<User> users = new ArrayList<>();

    public UsersRepository() {
        users.add(new User("Jan", "Wiedział", 21));
        users.add(new User("Paweł", "Słyszał", 37));
        users.add(new User("Karol", "Zapomniał", 17));
    }

    public List<User> getAll() {
        return users;
    }

    public void add(User user) {
        users.add(user);
    }
}
