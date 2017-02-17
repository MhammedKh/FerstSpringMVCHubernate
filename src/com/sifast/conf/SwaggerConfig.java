package com.sifast.conf;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import com.google.common.collect.Lists;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    // @Bean
    // public Docket api() {
    // return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("com.sifast.ws")).paths(PathSelectors.any()).build();
    // }

    @Bean
    public Docket latestDocumentationPlugin() {
        return new VersionedDocket("1.0", "com.sifast.ws.v1");
    }

    @Bean
    public Docket v10DocumentationPlugin() {
        return new VersionedDocket("2.0", "com.sifast.ws.v2");
    }

    class VersionedDocket extends Docket {

        public VersionedDocket(String version, String pack) {
            super(DocumentationType.SWAGGER_2);
            super.groupName(version).select().apis(RequestHandlerSelectors.basePackage(pack)).paths(PathSelectors.any()).build().apiInfo(getApiInfo(version))
                    .securitySchemes(Lists.newArrayList(apiKey())).securityContexts(Lists.newArrayList(securityContext()));
        }

        private ApiKey apiKey() {
            return new ApiKey("api_key", "api_key", "query");
        }

        private SecurityContext securityContext() {
            return SecurityContext.builder().securityReferences(defaultAuth()).forPaths(PathSelectors.regex("/v2/api-docs")).build();
        }

        List<SecurityReference> defaultAuth() {
            AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
            AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
            authorizationScopes[0] = authorizationScope;
            return Lists.newArrayList(new SecurityReference("key", authorizationScopes));
        }

        @SuppressWarnings("deprecation")
        private ApiInfo getApiInfo(String version) {
            return new ApiInfo("Api Documentation V" + version, "Api Documentation V" + version, // description
                    version, "", // terms of service url
                    "", "", // licence
                    "" // licence url
            );
        }

        // @Bean
        // SecurityConfiguration security() {
        // return new SecurityConfiguration("test-app-client-id", "test-app-client-secret", "test-app-realm", "test-app", "api_key", ApiKeyVehicle.QUERY_PARAM, "api_key", "," /*
        // * scope
        // * separator
        // */);
        // }

        // @Bean
        // UiConfiguration uiConfig() {
        // return new UiConfiguration("validatorUrl",// url
        // "none", // docExpansion => none | list
        // "alpha", // apiSorter => alpha
        // "schema", // defaultModelRendering => schema
        // UiConfiguration.Constants.DEFAULT_SUBMIT_METHODS, false, // enableJsonEditor => true | false
        // true, // showRequestHeaders => true | false
        // 60000L); // requestTimeout => in milliseconds, defaults to null (uses jquery xh timeout)
        // }
    }

}
