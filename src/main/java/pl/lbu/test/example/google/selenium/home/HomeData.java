package pl.lbu.test.example.google.selenium.home;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(value = "tests.google.home.data")
@Data
public class HomeData {
    private String search;
}
