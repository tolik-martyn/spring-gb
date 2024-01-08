package org.example;

import com.google.gson.Gson;
import org.apache.commons.lang3.StringUtils;

public class App {
    public static void main(String[] args) {
        // Пример использования Gson и Apache Commons Lang
        Gson gson = new Gson();
        String json = gson.toJson("Hello, World!");

        String reversedString = StringUtils.reverse(json);

        System.out.println("Reversed JSON: " + reversedString);
    }
}