package com.fanta.server.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Knife4j 接口文档配置
 */
@EnableSwagger2
@Configuration
@Profile("dev")
public class Knife4jConfig {

    @Bean
    public Docket defaultApi2() {
        return new Docket(DocumentationType.OAS_30)
                .groupName("测试")
                .apiInfo(apiInfo())
                .select()
                // 指定 Controller 扫描包路径
                .apis(RequestHandlerSelectors.basePackage("com.fanta.server.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .description("knife4j在线API接口文档")
                .contact(new Contact("Roc-xb", "https://yang-roc.blog.csdn.net/", "aida_pc@qq.com"))
                .version("v3.0.0")
                .title("knife4j在线API接口文档")
                .build();
    }
}