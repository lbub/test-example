package pl.lbu.test.example.git.user.request;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(value = "tests.git.user")
@Data
public class UserRequest {
    private String subdirectoryUrl;
    private QueryParams queryParams;
}
