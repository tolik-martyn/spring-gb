package com.example.hw3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Сервис для работы с пользователями.
 */
@Service
public class UserService {
    private final NotificationService notificationService;

    @Autowired
    public UserService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    /**
     * Создает нового пользователя с указанными параметрами.
     *
     * @param name  Имя нового пользователя.
     * @param age   Возраст нового пользователя.
     * @param email Email нового пользователя.
     * @return Созданный пользователь.
     */
    public User createUser(String name, int age, String email) {
        User user = new User(name, age, email);
        notificationService.notifyUser(user, "User created successfully");
        return user;
    }
}