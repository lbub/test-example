package pl.lbu.test.example.utils.drivers.options;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class StandardOptions {
    @Builder.Default
    private boolean headless = true;
    @Builder.Default
    private boolean incognito = true;
    @Builder.Default
    private String nodeUrl = "";
    @Builder.Default
    private String driverVersion = "93.0.4577.15";

    public void setDriverVersion(String driverVersion) {
        if (null != driverVersion && !driverVersion.isEmpty()) {
            this.driverVersion = driverVersion;
        }
    }
}
