package pl.lbu.test.example.git.authorizations.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class BasicAuth {
    private String username;
    private String password;
}
