package com.example.hw3;

import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Сервис для обработки данных.
 */
@Service
public class DataProcessingService {

    /**
     * Возвращает приветственное сообщение.
     *
     * @return Приветственное сообщение.
     */
    public String getGreeting() {
        return "Hello, World!";
    }

    /**
     * Сортирует список пользователей по возрасту в порядке возрастания.
     *
     * @param users Список пользователей для сортировки.
     * @return Отсортированный список пользователей.
     */
    public List<User> sortUsersByAge(List<User> users) {
        return users.stream()
                .sorted(Comparator.comparing(User::getAge))
                .collect(Collectors.toList());
    }

    /**
     * Фильтрует список пользователей по возрасту.
     *
     * @param users Список пользователей для фильтрации.
     * @param age   Возраст для фильтрации.
     * @return Отфильтрованный список пользователей.
     */
    public List<User> filterUsersByAge(List<User> users, int age) {
        return users.stream()
                .filter(user -> user.getAge() > age)
                .collect(Collectors.toList());
    }

    /**
     * Рассчитывает средний возраст пользователей.
     *
     * @param users Список пользователей для расчета.
     * @return Средний возраст пользователей.
     */
    public double calculateAverageAge(List<User> users) {
        return users.stream()
                .mapToInt(User::getAge)
                .average()
                .orElse(0);
    }
}