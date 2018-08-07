/**
 * FileName: Swagger2
 * Author: panlu02
 * Date: 2018/7/2 下午3:47
 * Description: Swagger2
 **/
package com.example.springboot;

import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2 {
    public Docket creatRestApi() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.springboot"))
                .paths(PathSelectors.any())
                .build();
    }

    public ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Spring Boot 中使用失望个人构建RESTful APIs")
                .description("更多Spring Boot相关文章请关注")
                .description("")
                .contact("panlu99")
                .version("1.0.0")
                .build();
    }
}
