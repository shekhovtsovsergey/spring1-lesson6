package ru.gb.spring1lesson6.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.gb.spring1lesson6.model.Product;
import ru.gb.spring1lesson6.service.ProductService;


@Controller
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {



    private final ProductService productService;


    // форма для создания продукта "/product/edit/{id}"
    @RequestMapping(path = "/create", method = RequestMethod.GET)
    public String showSimpleForm(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "create-product";
    }


    // обработка формы создания и редактирования продукта
    @RequestMapping(path = "/create", method = RequestMethod.POST)
    public String processForm(Product product) {
        if (product.getId() == null) {
            productService.save(product);
        } else {
            productService.edit(product);
        }
        return "redirect:/product/all";
    }



    // показать один элемент
    @GetMapping(path = "/{id}") // localhost:8080/spring/product/{id}?random=true
    public String getProductById(Model model,
                                 @PathVariable Long id,
                                 @RequestParam(name = "random", defaultValue = "false", required = false) Boolean isRandom) {
        Product product;


            product = productService.findById(id.intValue());


        model.addAttribute("product", product);
        return "product";
    }


    // показать все элементы
    @RequestMapping(path = "/all", method = RequestMethod.GET)
    public String getAllProducts(Model model) {
        model.addAttribute("products", productService.findAll());
        return "product-list";
    }


    // удаление элемента "/product/delete/{id}"
    @RequestMapping(path = "/delete", method = RequestMethod.GET)
    public String deleteById(@RequestParam Long id) {

        productService.deleteById(id.intValue());
        return "redirect:/product/all";
    }



    @RequestMapping(path = "/edit", method = RequestMethod.GET)
    public String editById(Model model, @RequestParam Integer id) {
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "create-product";
    }





}
