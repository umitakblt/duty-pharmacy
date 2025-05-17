package com.umitakbulut.duty_pharmacy.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Slf4j
@Configuration
@EnableAsync
@RequiredArgsConstructor
public class AsyncConfiguration {
    private final AppConfiguration appConfiguration;

    @Bean(name = "asyncThreadPoolTaskExecutor")
    public ThreadPoolTaskExecutor asyncThreadPoolTaskExecutor() {
        log.info("Async thread pool task executor with threadPoolTaskExecutorProperties : {}", appConfiguration.getThreadPool());
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setCorePoolSize(appConfiguration.getThreadPool().getCorePoolSize());
        threadPoolTaskExecutor.setMaxPoolSize(appConfiguration.getThreadPool().getMaxPoolSize());
        threadPoolTaskExecutor.setQueueCapacity(appConfiguration.getThreadPool().getQueueCapacity());
        threadPoolTaskExecutor.setThreadNamePrefix(appConfiguration.getThreadPool().getThreadNamePrefix());
        threadPoolTaskExecutor.initialize();
        return threadPoolTaskExecutor;
    }
}
