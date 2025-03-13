package com.example.styleSphere.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(title = "StyleSphere",
                     description = "StyleSphere API with spring boot 3.4.3",
                     version = "v0.1")
)
@Configuration
@RequiredArgsConstructor
public class DocConfig {
    @Bean
    public GroupedOpenApi customOpenApi(){
        String[] paths = {"/styleSphere/**"};

        return GroupedOpenApi.builder()
                .group("StyleSphere API")
                .pathsToMatch(paths)
                .build();
    }
}
