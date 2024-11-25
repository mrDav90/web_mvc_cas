package com.learn.david.web_mvc_keycloak.controllers;


import com.learn.david.web_mvc_keycloak.entities.Product;
import com.learn.david.web_mvc_keycloak.services.IProduct;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
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
        OAuth2AuthenticationToken authentication =
                (OAuth2AuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        var list = productService.getProducts();
        model.addAttribute("products", list);
        model.addAttribute("product", new Product());
        model.addAttribute("username", authentication.getPrincipal().getAttribute("preferred_username"));
        model.addAttribute("name", authentication.getPrincipal().getAttribute("name"));
        return "products";
    }

    @PostMapping
    public String addProduct(ModelMap model, @ModelAttribute Product product) {
        productService.addProduct(product);
        return "redirect:/products";
    }
}
