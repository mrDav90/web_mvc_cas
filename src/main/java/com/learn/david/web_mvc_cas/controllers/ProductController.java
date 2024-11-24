package com.learn.david.web_mvc_cas.controllers;


import com.learn.david.web_mvc_cas.entities.Product;
import com.learn.david.web_mvc_cas.services.IProduct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final IProduct productService;

    @GetMapping
    public String getProducts(ModelMap model) {
        var list = productService.getProducts();
        model.addAttribute("products", list);
        model.addAttribute("product", new Product());
        return "index";
    }

    @PostMapping
    public String addProduct(ModelMap model, @ModelAttribute Product product) {
        productService.addProduct(product);
        return "redirect:/products";
    }
}
