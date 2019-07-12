package com.company.repository;

import com.company.model.Product;

public class ProductRepository implements GeneralRepository<Product> {
    private int size = SIZE;
    Product[] listProducts = new Product[SIZE];

    {
        listProducts[0] = new Product("1", "Sam Sung", 100000, "Dien thoai");
        listProducts[1] = new Product("2", "Iphone", 200000, "Dien thoai");
        listProducts[2] = new Product("3", "Nokia", 50000, "Dien thoai");

    }

    @Override
    public Product[] showList() {
        return listProducts;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(int index, Product product) {
        for (int i = index; i < listProducts.length - 1; i++) {
            Product temp = listProducts[i];
            listProducts[i] = listProducts[i + 1];
            listProducts[i + 1] = temp;
        }
        listProducts[index] = product;
        size++;
    }

    @Override
    public void remove(int index) {
        for (int i = index; i < size - 1; i++) {
            listProducts[i] = listProducts[i + 1];
        }
        listProducts[size - 1] = null;
        size--;

    }

    @Override
    public Product set(int index, Product product) {
        listProducts[index] = product;
        return listProducts[index];
    }

    @Override
    public int find(String ProductName) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (listProducts[i] != null) {
                if (listProducts[i].getName().equalsIgnoreCase(ProductName)) {
                    index = i;
                    break;
                }
            }
        }
        return index;
    }

    @Override
    public Product[] sort() {
        for (int i = 0; i < listProducts.length; i++) {
            if (listProducts[i] != null) {
                for (int j = i; j < listProducts.length; j++) {
                    if (listProducts[j] != null) {
                        if (listProducts[i].getPrice() > listProducts[j].getPrice()) {
                            Product temp = listProducts[i];
                            listProducts[i] = listProducts[j];
                            listProducts[j] = temp;
                        }
                    }
                }
            }
        }
        return listProducts;
    }
}