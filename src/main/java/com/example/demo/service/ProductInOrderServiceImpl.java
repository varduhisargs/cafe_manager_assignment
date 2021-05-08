package com.example.demo.service;

import com.example.demo.model.ProductInOrder;
import com.example.demo.model.ProductInOrderStatus;
import com.example.demo.repository.ProductInOrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductInOrderServiceImpl implements ProductInOrderService {


    private final ProductInOrderRepository productInOrderRepository;

    public ProductInOrderServiceImpl(ProductInOrderRepository productInOrderRepository) {
        this.productInOrderRepository = productInOrderRepository;
    }


    @Override
    public void createProductInOrder(ProductInOrder product) {
            product.setProductInOrderStatus(ProductInOrderStatus.ACTIVE);
            productInOrderRepository.save(product);
        }


    @Override
    public ProductInOrder editProductInOrder(ProductInOrder product) {
        return null;
    }
}
