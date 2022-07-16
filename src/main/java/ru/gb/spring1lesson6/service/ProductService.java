package ru.gb.spring1lesson6.service;



import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Service;
import ru.gb.spring1lesson6.model.Product;
import ru.gb.spring1lesson6.repository.ProductRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ProductService {


    private final ProductRepository productRepository;


    public List<Product> findAll() {
        return productRepository.findAll();
    }



    public Product save(Product product) {
        return productRepository.save(product);
    }


    public Product edit(Product product) {
        return productRepository.edit(product);
    }

    public Product findById(Integer id) {
        return productRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }


    public void deleteById(Integer id) {
        productRepository.deleteById(id);
    }






}
