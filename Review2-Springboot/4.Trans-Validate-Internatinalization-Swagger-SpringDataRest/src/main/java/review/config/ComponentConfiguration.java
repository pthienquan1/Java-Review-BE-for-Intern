package review.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.modelmapper.ModelMapper;
/**
 * Created by quan0
 * Date 5/25/2023 - 1:10 PM
 * Description: ...
 */
@Configuration
public class ComponentConfiguration {
  @Bean
  public ModelMapper initModelMapper(){
      return new ModelMapper();
  }
}
