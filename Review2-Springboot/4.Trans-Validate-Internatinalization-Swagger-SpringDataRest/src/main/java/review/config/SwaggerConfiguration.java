package review.config;
import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
/**
 * Created by quan0
 * Date 5/28/2023 - 5:33 PM
 * Description: ...
 */

/**
 * JSON: http://localhost:8080/v2/api-docs
 * UI: http://localhost:8080/swagger-ui/index.html
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build().apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo("Application API", // title
                "This is API description for Application", // description
                "1.0", // version
                "Terms of service URL", // termsOfServiceUrl
                new Contact("Phan Thiên Quân", "https://github.com/pthienquan1", "quan01011997123@gmail.com"), // contact
                "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0.html", // license
                Collections.emptyList()); // vendors
    }
}