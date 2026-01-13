package com.example.lovable_clone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class LovableCloneApplication {
    public static void main(String[] args) {
        System.out.println(">>> LOADING YAML CONFIG <<<");
        SpringApplication.run(LovableCloneApplication.class, args);
    }
}
