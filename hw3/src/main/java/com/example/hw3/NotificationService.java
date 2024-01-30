package com.example.hw3;

import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    public void notifyUser(User user, String message) {
        System.out.println(message + ": " + user.getName() + ", id=" + user.getId());
    }
}
