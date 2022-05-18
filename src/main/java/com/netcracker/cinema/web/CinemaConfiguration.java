package com.netcracker.cinema.web;

import com.netcracker.cinema.service.ApplicationContextHandler;
import com.vaadin.spring.annotation.EnableVaadin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableVaadin
public class CinemaConfiguration {

    public static ApplicationContextHandler handler;

    @Autowired
    CinemaConfiguration(ApplicationContextHandler handler) {
        this.handler = handler;
    }
}