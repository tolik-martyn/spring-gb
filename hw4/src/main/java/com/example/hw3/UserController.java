package com.example.hw3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Контроллер для управления пользователями.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Обработчик POST-запроса для /user.
     * Создает нового пользователя с указанными параметрами.
     *
     * @param name  Имя нового пользователя.
     * @param age   Возраст нового пользователя.
     * @param email Email нового пользователя.
     * @return Ответ с созданным пользователем и кодом состояния 201 (CREATED).
     */
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<User> createUser(@RequestParam String name, @RequestParam int age, @RequestParam String email) {
        return new ResponseEntity<>(userService.createUser(name, age, email), HttpStatus.CREATED);
    }
}