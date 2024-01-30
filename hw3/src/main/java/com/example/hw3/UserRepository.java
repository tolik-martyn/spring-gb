package com.example.hw3;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class UserRepository {
    private final List<User> users = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public void saveUser(User user) {
        user.setId(idGenerator.getAndIncrement());
        users.add(user);
    }

    public User getUserById(Long userId) {
        return users.stream()
                .filter(user -> user.getId().equals(userId))
                .findFirst()
                .orElse(null);
    }

    public void deleteUser(User user) {
        users.remove(user);
    }

    public List<User> getAllUsers() {
        return new ArrayList<>(users);
    }

}
