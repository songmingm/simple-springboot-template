package com.fanta.server.common;

import com.fanta.server.config.YamlPropertySourceFactory;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.List;

/**
 * 不受security保护的资源地址
 */
@Configuration
@PropertySource(value = "classpath:ignore.yaml", factory = YamlPropertySourceFactory.class)
@Data
@ConfigurationProperties(prefix = "exclude")
public class IgnoreUrls {

    private List<String> urls;
}
