package com.asvladimirov.syntsc.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "app.split-character")
@Getter
@Setter
public class ReplaceCharacterProperties {
    private char syntscDelimiter;
    private char spellerDelimiter;
}
