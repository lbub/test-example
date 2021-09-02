package pl.lbu.test.example.utils.drivers.options;

public interface DriverOptions<T, O> {
    DriverOptions standardOptions(StandardOptions standardOptions);

    String getNodeUrl();

    T setNodeUrl(String url);

    String getVersion();

    T setVersion(String version);

    O getOptions();

    T setOptions(O options);

    T setDefaultOptions();

    T setStandardOptions(StandardOptions standardOptions);

    T extendOptions(String additionalOptions);
}
