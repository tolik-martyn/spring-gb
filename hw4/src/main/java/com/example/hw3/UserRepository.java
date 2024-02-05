package com.example.hw3;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Репозиторий для управления пользователями в памяти.
 */
@Repository
public class UserRepository {
    private final Map<Long, User> users = new ConcurrentHashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public UserRepository() {
        initializeData();
    }

    /**
     * Инициализирует начальный список пользователей.
     */
    private void initializeData() {
        List<User> initialUsers = List.of(
                new User("Ivan", 32, "Ivan@mail.ru"),
                new User("Oleg", 23, "Oleg@mail.ru"),
                new User("Max", 29, "Max@mail.ru"),
                new User("Olya", 25, "Olya@mail.ru")
        );
        initialUsers.forEach(this::saveUser);
    }

    /**
     * Сохраняет пользователя в хранилище.
     * Если у пользователя нет идентификатора, генерирует новый и присваивает его пользователю.
     *
     * @param user Пользователь для сохранения.
     */
    public void saveUser(User user) {
        if (user.getId() == null) {
            user.setId(idGenerator.getAndIncrement());
        }
        users.put(user.getId(), user);
    }

    /**
     * Возвращает пользователя по его идентификатору.
     *
     * @param userId Идентификатор пользователя.
     * @return Пользователь с заданным идентификатором или null, если пользователь не найден.
     */
    public User getUserById(Long userId) {
        return users.get(userId);
    }

    /**
     * Удаляет пользователя из хранилища.
     *
     * @param user Пользователь для удаления.
     */
    public void deleteUser(User user) {
        users.remove(user.getId());
    }

    /**
     * Возвращает список всех пользователей.
     *
     * @return Список всех пользователей.
     */
    public List<User> getAllUsers() {
        return new ArrayList<>(users.values());
    }
}