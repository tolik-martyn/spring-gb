package org.example.springbootapp;

import org.springframework.stereotype.Service;

@Service
public class ReverseService {

    public String reverseString(String input) {
        return new StringBuilder(input).reverse().toString();
    }
}
