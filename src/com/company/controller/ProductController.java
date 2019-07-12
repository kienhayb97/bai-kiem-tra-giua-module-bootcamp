package com.company.controller;


import com.company.model.Product;
import com.company.service.ProductService;

public class ProductController {
    ProductService productService = new ProductService();

    public Product[] showList() {
        return productService.showList();
    }

    public int size() {
        return productService.size();
    }

    public void add(int index, Product Product) {
        productService.add(index, Product);
    }

    public void remove(int index) {
        productService.remove(index);
    }

    public Product set(int index, Product Product) {
        return productService.set(index, Product);
    }

    public int find(String ProductName) {
        return productService.find(ProductName);
    }
    public Product[] sort() {
        return productService.sort();
    }

}