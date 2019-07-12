package com.company;

import com.company.controller.ProductController;
import com.company.model.Product;

import java.util.Scanner;

public class Main {

    static ProductController productController = new ProductController();

    public static void main(String[] args) {
        int choice;
        int index;
        Scanner input = new Scanner(System.in);
        do {
            menu();
            System.out.println("Ban chon so may:");
            choice = input.nextInt();
            switch (choice) {
                case 1: {
                    showListProduct();
                    break;
                }
                case 2: {
                    System.out.println("Nhap vi tri ban muon them:");
                    index = input.nextInt();
                    if (addProduct(index)) {
                        System.out.println("Them thanh cong");
                    } else {
                        System.out.println("Vi tri muon them nam ngoai danh sach");
                    }

                    break;
                }
                case 3: {
                    System.out.println("Nhap vi tri ban muon xoa:");
                    index = input.nextInt();
                    if (removeProduct(index)) {
                        System.out.println("Da xoa san pham o vi tri " + index + " thanh cong ");
                    } else {
                        System.out.println("Vi tri xoa khong hop le");
                    }
                    break;
                }
                case 4: {
                    sortProduct();
                    System.out.println("Danh sach sau khi sap xep ");
                    showListProduct();
                    break;
                }
                case 5: {
                    System.out.println("Nhap vi tri ban muon thay doi noi dung:");
                    index = input.nextInt();
                    if (updateProduct(index)) {
                        System.out.println("Sua thanh cong");
                    } else {
                        System.out.println("Vi tri chinh sua khong hop le");
                    }

                    break;
                }
                case 6: {
                    input.nextLine();
                    System.out.println("Nhap ten san pham ban can tim kiem:");
                    String productName = input.nextLine();
                    String result = seachNameProduct(productName);
                    System.out.println(result);
                    break;
                }
            }
        } while (choice != 0);
    }

    private static Product[] sortProduct() {
        return productController.sort();
    }

    private static String seachNameProduct(String productName) {
        int index;
        Product[] listProduct = productController.showList();
        index = productController.find(productName);
        if (index == -1) {
            return "Khong tim thay san pham";
        } else {
            System.out.println();
            System.out.println();
            return "San pham can tim la: " + listProduct[index].toString();
        }
    }

    private static boolean updateProduct(int index) {
        int size = productController.size();
        if (index < 0 || index >= size) {
            return false;
        } else {
            Product product = new Product();
            setProductInfo(product);
            productController.set(index, product);
            return true;
        }
    }

    private static boolean removeProduct(int index) {
        int size = productController.size();

        if (index < 0 && index >= size) {

            return false;
        } else {
            productController.remove(index);
            return true;
        }
    }

    private static boolean addProduct(int index) {
        int size = productController.size();
        if (index < 0 || index >= size) {
            return false;
        }
        Product product = new Product();
        setProductInfo(product);
        productController.add(index, product);
        return true;
    }

    private static void showListProduct() {
        int i=0;
        Product[] listProduct = productController.showList();
        for (Product product : listProduct) {
            if (product != null) {
                System.out.println(product.toString() + " o vi tri so " + i);
            }
            i++;
        }
    }

    public static void setProductInfo(Product product) {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhap thong tin san pham:");
        System.out.println("ID:");
        String id = input.nextLine();
        product.setId(id);
        System.out.println("Name:");
        String name = input.nextLine();
        product.setName(name);
        System.out.println("Price:");
        int price = input.nextInt();
        product.setPrice(price);
        input.nextLine();
        System.out.println("Description:");
        String description = input.nextLine();
        product.setDescription(description);
    }

    public static void menu() {
        System.out.println("\n");
        System.out.println("-----Quan ly San Pham-----");
        System.out.println("1. Danh sach san pham");
        System.out.println("2. Them san pham");
        System.out.println("3. Xoa san pham");
        System.out.println("4. Sap xep san pham theo gia");
        System.out.println("5. Sua thong tin san pham");
        System.out.println("6. Tim kiem san pham");
        System.out.println("0. Thoat");
    }
}
