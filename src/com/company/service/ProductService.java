package com.company.service;

import com.company.model.Product;
import com.company.repository.ProductRepository;

public class ProductService implements GeneralService<Product> {
    ProductRepository productRepository = new ProductRepository();

    @Override
    public Product[] showList() {
        return productRepository.showList();
    }

    @Override
    public int size() {
        return productRepository.size();
    }

    @Override
    public void add(int index, Product Product) {
        productRepository.add(index, Product);
    }

    @Override
    public void remove(int index) {
        productRepository.remove(index);
    }

    @Override
    public Product set(int index, Product Product) {
        return productRepository.set(index, Product);
    }

    @Override
    public int find(String ProductName) {
        return productRepository.find(ProductName);
    }

    @Override
    public Product[] sort() {
        return productRepository.sort();
    }



}
