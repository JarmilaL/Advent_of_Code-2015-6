package com.lenyiova;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.context.ServletWebServerInitializedEvent;
import org.springframework.context.event.EventListener;

import java.sql.SQLException;
import java.util.Objects;

@SpringBootApplication
public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
        System.out.println("Bezim");

    }

    @EventListener
    public void onAppEvent(ServletWebServerInitializedEvent event) {
        int port = event.getApplicationContext().getWebServer().getPort();
        logger.info("Web app address: http://localhost:" + port + Objects.requireNonNull(event.getApplicationContext().getServletContext()).getContextPath());
    }
}
