package com.asvladimirov.syntsc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@SpringBootApplication
@EnableFeignClients
public class SyntscApplication {

    public static void main(String[] args) {
        SpringApplication.run(SyntscApplication.class);
    }
}