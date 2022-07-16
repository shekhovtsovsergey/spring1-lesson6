package ru.gb.spring1lesson6.repository;


import org.springframework.stereotype.Component;
import ru.gb.spring1lesson6.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class ProductRepository {



    List<Product> products = new ArrayList<>();
    private int count = 0;




    public List<Product> findAll() {
        return new ArrayList<>(products);
    }




    public Product save(Product product) {

        products.add(product);
        product.setId(count++);
        return Product.builder()
                .id(product.getId())
                .name(product.getName())
                .cost(product.getCost())
                .build();
    }



    public Product edit(Product product) {
        return products.set(product.getId(), product);
    }




    public Optional<Product> findById(Integer id) {
        if (id < products.size()) {
            return Optional.of(products.get(id));
        } else {
            return Optional.empty();
        }
    }


    public void deleteById(Integer id) {
        if (id < products.size()) {
            products.remove(id.intValue());
        }
    }




}
