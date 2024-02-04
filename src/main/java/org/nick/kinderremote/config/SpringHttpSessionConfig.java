package org.nick.kinderremote.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.MapSessionRepository;
import org.springframework.session.config.annotation.web.http.EnableSpringHttpSession;

import java.util.concurrent.ConcurrentHashMap;

@Configuration(proxyBeanMethods = false)
@EnableSpringHttpSession
public class SpringHttpSessionConfig {
    @Bean
    public MapSessionRepository sessionRepository() {
        return new MapSessionRepository(new ConcurrentHashMap<>());
    }
}
