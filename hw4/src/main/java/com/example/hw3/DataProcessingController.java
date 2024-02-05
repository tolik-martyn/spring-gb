package com.example.hw3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Контроллер для обработки данных.
 */
@Controller
@RequestMapping("/api")
public class DataProcessingController {
    private final DataProcessingService dataProcessingService;
    private final RegistrationService registrationService;

    @Autowired
    public DataProcessingController(DataProcessingService dataProcessingService, RegistrationService registrationService) {
        this.dataProcessingService = dataProcessingService;
        this.registrationService = registrationService;
    }

    /**
     * Обработчик GET-запроса для /api/hello.
     * Отображает страницу с приветствием.
     *
     * @param model Модель для передачи данных в представление.
     * @return Имя представления "hello".
     */
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(Model model) {
        model.addAttribute("greeting", dataProcessingService.getGreeting());
        return "hello";
    }

    /**
     * Обработчик POST-запроса для /api/sort.
     * Сортирует пользователей по возрасту.
     *
     * @param users Список пользователей для сортировки.
     * @param model Модель для передачи данных в представление.
     * @return Имя представления "sortUsers".
     */
    @RequestMapping(value = "/sort", method = RequestMethod.POST)
    public String sortUsers(@RequestBody List<User> users, Model model) {
        model.addAttribute("users", dataProcessingService.sortUsersByAge(users));
        return "sortUsers";
    }

    /**
     * Обработчик GET-запроса для /api/filter/{age}.
     * Фильтрует пользователей по возрасту.
     *
     * @param age   Возраст для фильтрации пользователей.
     * @param users Список пользователей для фильтрации.
     * @param model Модель для передачи данных в представление.
     * @return Имя представления "filterUsersByAge".
     */
    @RequestMapping(value = "/filter/{age}", method = RequestMethod.GET)
    public String filterUsersByAge(@PathVariable("age") Integer age, @RequestBody List<User> users, Model model) {
        model.addAttribute("users", dataProcessingService.filterUsersByAge(users, age));
        model.addAttribute("age", age);
        return "filterUsersByAge";
    }

    /**
     * Обработчик POST-запроса для /api/average.
     * Рассчитывает средний возраст пользователей.
     *
     * @param users Список пользователей для расчета.
     * @param model Модель для передачи данных в представление.
     * @return Имя представления "averageAge".
     */
    @RequestMapping(value = "/average", method = RequestMethod.POST)
    public String average(@RequestBody List<User> users, Model model) {
        model.addAttribute("averageAge", dataProcessingService.calculateAverageAge(users));
        return "averageAge";
    }

    /**
     * Обработчик POST-запроса для /api/register.
     * Регистрирует нового пользователя.
     *
     * @param user  Новый пользователь для регистрации.
     * @param model Модель для передачи данных в представление.
     * @return Имя представления "registerUser".
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerUser(@RequestBody User user, Model model) {
        model.addAttribute("user", registrationService.registerUser(user));
        return "registerUser";
    }


    /**
     * Обработчик PUT-запроса для /api/update/{userId}.
     * Обновляет информацию о пользователе по его идентификатору.
     *
     * @param userId      Идентификатор пользователя для обновления.
     * @param updatedUser Обновленная информация о пользователе.
     * @param model       Модель для передачи данных в представление.
     * @return Имя представления "updateUser".
     */
    @RequestMapping(value = "/update/{userId}", method = RequestMethod.PUT)
    public String updateUser(@PathVariable("userId") Long userId, @RequestBody User updatedUser, Model model) {
        model.addAttribute("user", registrationService.updateUser(userId, updatedUser));
        return "updateUser";
    }

    /**
     * Обработчик DELETE-запроса для /api/delete/{userId}.
     * Удаляет пользователя по его идентификатору.
     *
     * @param userId Идентификатор пользователя для удаления.
     * @param model  Модель для передачи данных в представление.
     * @return Имя представления "deleteUser".
     */
    @RequestMapping(value = "/delete/{userId}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable("userId") Long userId, Model model) {
        registrationService.deleteUser(userId);
        model.addAttribute("userId", userId);
        return "deleteUser";
    }

    /**
     * Обработчик GET-запроса для /api/allUsers.
     * Возвращает список всех пользователей.
     *
     * @param model Модель для передачи данных в представление.
     * @return Имя представления "allUsers".
     */
    @RequestMapping(value = "/allUsers", method = RequestMethod.GET)
    public String getAllUsers(Model model) {
        model.addAttribute("users", registrationService.getAllUsers());
        return "allUsers";
    }
}