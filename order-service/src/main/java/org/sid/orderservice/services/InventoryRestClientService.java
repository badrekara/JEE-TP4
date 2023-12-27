package org.sid.orderservice.services;

import org.sid.orderservice.model.Customer;
import org.sid.orderservice.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

//un client rest:est un service qui permet de cmmuniquer avec une rest api

@FeignClient(name = "inventory-service")////facon de dire, cette interface lorsque jappelle ces methodes la envoie moi une requete vers un service qui sappelle customerservice
public interface InventoryRestClientService {
    @GetMapping("/products/{id}?projection=fullProduct")
    public Product productById(@PathVariable Long id);
    @GetMapping("/products?projection=fullProduct")
    public PagedModel<Product> allProducts();
}

