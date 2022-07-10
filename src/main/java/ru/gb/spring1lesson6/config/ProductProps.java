package ru.gb.spring1lesson6.config;


import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import ru.gb.spring1lesson6.model.Product;
import java.util.*;


@Getter
@Setter
@ConfigurationProperties("shop.properties")
public class ProductProps {

   private List<Product> products;

}
