package com.umitakbulut.duty_pharmacy.config;


import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Component
@ConfigurationProperties(prefix = "application")
public class AppConfiguration {
    ThreadPoolProperties threadPool = new ThreadPoolProperties();
    ExternalServiceProperties externalService = new ExternalServiceProperties();
    HazelcastProperties hazelcast = new HazelcastProperties();

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @ToString
    public static class ThreadPoolProperties {
        private int corePoolSize = 10;
        private int maxPoolSize = 10;
        private int queueCapacity = 100;
        private String threadNamePrefix = "async-thread-";
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ExternalServiceProperties {
        private String url;
        private String token;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class HazelcastProperties {
        private String instanceName = "duty-hazelcast";
        private int port = 5701;
    }
}
