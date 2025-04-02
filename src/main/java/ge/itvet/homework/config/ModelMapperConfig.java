package ge.itvet.homework.config;

import ge.itvet.homework.domain.Order;
import ge.itvet.homework.dto.OrderDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.addMappings(new PropertyMap<Order, OrderDto>() {
            @Override
            protected void configure() {
                map(source.getStatus().getStatus(), destination.getStatus());
            }
        });

        return modelMapper;
    }
}

