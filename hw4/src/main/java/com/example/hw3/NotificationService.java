package com.example.hw3;

import org.springframework.stereotype.Service;

/**
 * Сервис уведомлений (нотификации).
 */
@Service
public class NotificationService {

    /**
     * Уведомляет пользователя с заданным сообщением.
     *
     * @param user    Пользователь, которого нужно уведомить.
     * @param message Сообщение для уведомления.
     */
    public void notifyUser(User user, String message) {
        System.out.println(message + ": " + user.getName() + ", id=" + user.getId());
    }
}