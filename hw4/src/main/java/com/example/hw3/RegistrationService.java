package com.example.hw3;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

/**
 * Сервис для работы с пользователями.
 */
@Service
public class RegistrationService {
    private final UserService userService;
    private final UserRepository userRepository;
    private final NotificationService notificationService;

    public RegistrationService(UserService userService, UserRepository userRepository, NotificationService notificationService) {
        this.userService = userService;
        this.userRepository = userRepository;
        this.notificationService = notificationService;
    }

    /**
     * Регистрирует нового пользователя.
     *
     * @param user Новый пользователь для регистрации.
     * @return Зарегистрированный пользователь.
     */
    public User registerUser(User user) {
        User createdUser = userService.createUser(user.getName(), user.getAge(), user.getEmail());
        userRepository.saveUser(createdUser);
        notificationService.notifyUser(createdUser, "User registered successfully");
        return createdUser;
    }

    /**
     * Обновляет информацию о пользователе по его идентификатору.
     *
     * @param userId      Идентификатор пользователя для обновления.
     * @param updatedUser Обновленная информация о пользователе.
     * @return Обновленный пользователь.
     * @throws ResponseStatusException Если пользователь с указанным идентификатором не найден.
     */
    public User updateUser(Long userId, User updatedUser) {
        User existingUser = userRepository.getUserById(userId);
        if (existingUser != null) {
            existingUser.setName(updatedUser.getName());
            existingUser.setAge(updatedUser.getAge());
            existingUser.setEmail(updatedUser.getEmail());
            notificationService.notifyUser(existingUser, "User updated successfully");
            return existingUser;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User with id " + userId + " not found");

        }
    }

    /**
     * Удаляет пользователя по идентификатору.
     *
     * @param userId Идентификатор пользователя для удаления.
     * @throws ResponseStatusException Если пользователь с указанным идентификатором не найден.
     */
    public void deleteUser(Long userId) {
        User user = userRepository.getUserById(userId);
        if (user != null) {
            userRepository.deleteUser(user);
            notificationService.notifyUser(user, "User deleted successfully");
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User with id " + userId + " not found");
        }
    }

    /**
     * Возвращает список всех пользователей.
     *
     * @return Список всех пользователей.
     */
    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }
}