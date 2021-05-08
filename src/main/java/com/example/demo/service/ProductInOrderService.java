package com.example.demo.service;

import com.example.demo.model.ProductInOrder;

public interface ProductInOrderService {

    void createProductInOrder(ProductInOrder product);

    ProductInOrder editProductInOrder(ProductInOrder product);

}
