package com.jgperea.technicalTest.config;

import com.jgperea.technicalTest.util.Constant;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * The type Swagger confiig.
 */
@Configuration(proxyBeanMethods = false)
public class SwaggerConfiig {
    /**
     * Api grouped open api.
     *
     * @return the grouped open api
     */
    @Bean
    public GroupedOpenApi api() {
        return GroupedOpenApi.builder()
                .group(Constant.GROUP_OPENAPI)
                .packagesToScan(Constant.REST_PACKAGE)
                .build();
    }

    /**
     * Api ifo open api.
     *
     * @return the open api
     */
    @Bean
    public OpenAPI apiIfo() {
        var server = new Server();
        server.setUrl(Constant.SERVER_LOCAL);
        return new OpenAPI().info(new Info()
                .title(Constant.TITLE_OPENAPI)
                .description(Constant.DESCRIPTION_OPENAPI)
                .version(Constant.VERSION_OPENAPI)).servers(List.of(server));
    }


}
