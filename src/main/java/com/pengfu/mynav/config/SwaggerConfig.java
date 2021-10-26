package com.pengfu.mynav.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * @author PrideZH
 * @date 2021/10/25 - 22:41
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket docket(Environment environment) {
        // 获得项目环境
        Profiles profiles = Profiles.of("dev", "test");
        boolean flag = environment.acceptsProfiles(profiles);

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .enable(flag)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.pengfu.mynav.controller"))
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
            "MyNav-api",
            "MyNav API 文档",
            "1.0",
            "",
             new Contact("PrideZH", "", "332842890@qq.com"),
            "Apache 2.0",
            "http://www.apache.org/licenses/LICENSE-2.0",
             new ArrayList<VendorExtension>()
        );
    }

}
