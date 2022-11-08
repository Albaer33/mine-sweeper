package com.codersdungeon.minesweeper.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RestApiController {

    @GetMapping("/user")
    public String hello() {

        String user = SecurityContextHolder.getContext().getAuthentication().getName();
        return "hello world " + user;
    }
}
