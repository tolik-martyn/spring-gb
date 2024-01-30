package com.example.hw3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

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

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public ResponseEntity<String> hello() {
        String response = this.dataProcessingService.getGreeting();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "/sort", method = RequestMethod.POST)
    public ResponseEntity<List<User>> sortUsers(@RequestBody List<User> users) {
        return new ResponseEntity<>(dataProcessingService.sortUsersByAge(users), HttpStatus.OK);
    }

    @RequestMapping(value = "/filter/{age}", method = RequestMethod.GET)
    public ResponseEntity<List<User>> filterUsersByAge(@PathVariable("age") Integer age, @RequestBody List<User> users) {
        return new ResponseEntity<>(dataProcessingService.filterUsersByAge(users, age), HttpStatus.OK);
    }

    @RequestMapping(value = "/average", method = RequestMethod.POST)
    public ResponseEntity<Double> average(@RequestBody List<User> users) {
        return new ResponseEntity<>(dataProcessingService.calculateAverageAge(users), HttpStatus.OK);
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        User createdUser = registrationService.registerUser(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/update/{userId}", method = RequestMethod.PUT)
    public ResponseEntity<User> updateUser(@PathVariable("userId") Long userId, @RequestBody User updatedUser) {
        User user = registrationService.updateUser(userId, updatedUser);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/{userId}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteUser(@PathVariable("userId") Long userId) {
        registrationService.deleteUser(userId);
        return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
    }

    @RequestMapping(value = "/allUsers", method = RequestMethod.GET)
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> allUsers = registrationService.getAllUsers();
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }
}
