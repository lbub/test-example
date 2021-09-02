package pl.lbu.test.example.git.authorizations.request;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(value = "tests.git.authorizations")
@Data
public class AuthorizationsRequest {
    private String subdirectoryUrl;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private BasicAuth basicAuth;
}
