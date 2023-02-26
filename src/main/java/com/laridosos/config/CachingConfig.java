package com.laridosos.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;

@Configuration
@EnableCaching
@EnableScheduling
public class CachingConfig {

    public static final String MEDICINE_STATUS = "medicineApplicationsByStatusApplied";

    public static final int SEGUNDO = 1000;
    public static final int MINUTO = 60 * SEGUNDO;

    @Bean
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager(MEDICINE_STATUS);
    }

    @CacheEvict(allEntries = true, value = {MEDICINE_STATUS})
    @Scheduled(fixedDelay = 30 * SEGUNDO,  initialDelay = 500)
    public void reportCacheEvict() {
        System.out.println("Flush Cache " + LocalDateTime.now());
    }

}
