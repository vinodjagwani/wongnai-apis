package th.wongnai.fdelivery.driver.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

import java.time.LocalTime;
import java.util.List;

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .genericModelSubstitutes(Mono.class, Flux.class, Flux.class)
                .select()
                .apis(RequestHandlerSelectors.basePackage("th.wongnai.fdelivery.driver.feature.web.rest"))
                .paths(PathSelectors.any()).build()
                .securitySchemes(List.of(new ApiKey("token", "Authorization", "header")))
                .securityContexts(List.of(SecurityContext.builder().securityReferences(defaultAuth()).build()))
                .forCodeGeneration(true)
                .directModelSubstitute(LocalTime.class, String.class).apiInfo(apiInfo());
    }

    public ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Wongnai Thailand Food Delivery Driver Service")
                .contact(new Contact("Wongnai", "", "")).version("1.0").build();
    }

    public List<SecurityReference> defaultAuth() {
        final AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        return List.of(new SecurityReference("token", new AuthorizationScope[]{authorizationScope}));
    }
}
