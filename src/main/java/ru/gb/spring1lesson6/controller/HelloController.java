package ru.gb.spring1lesson6.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.gb.spring1lesson6.config.ProductProps;


@Controller
@RequiredArgsConstructor
public class HelloController {

    private final ProductProps productProps;


    @ResponseBody
    @GetMapping
    public String helloMessage (){
        return "Hello";
    }


    @GetMapping("/hello")
    public String helloMessageJsp (Model model){
        model.addAttribute("msg","Count of products:" + productProps.getProducts().size());
        return "message";
    }



}
