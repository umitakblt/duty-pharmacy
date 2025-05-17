package com.umitakbulut.duty_pharmacy.config;


import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
@RequiredArgsConstructor
public class HazelcastConfiguration {
    private final AppConfiguration appConfiguration;

    @Bean
    public CacheManager cacheManager(@Qualifier("hazelcastInstance") HazelcastInstance hazelcastInstance) {
        return new com.hazelcast.spring.cache.HazelcastCacheManager(hazelcastInstance);
    }

    @Bean(value = "hazelcastInstance")
    public HazelcastInstance hazelcastInstance () {
        HazelcastInstance hazelcastInstance = Hazelcast.getHazelcastInstanceByName(appConfiguration.getHazelcast().getInstanceName());
        if (hazelcastInstance != null) {
            return hazelcastInstance;
        }

        Config hazelcastConfig = new Config();
        hazelcastConfig.setInstanceName(appConfiguration.getHazelcast().getInstanceName());
        hazelcastConfig.getNetworkConfig().setPort(appConfiguration.getHazelcast().getPort());
        return Hazelcast.newHazelcastInstance(hazelcastConfig);
    }
}
