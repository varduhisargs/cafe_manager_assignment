package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.model.Table;
import com.example.demo.model.User;
import com.example.demo.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/manager")
public class ManagerController {

    private final WaiterService waiterService;
    private final TableService tableService;
    private final ProductService productService;

    public ManagerController(WaiterServiceImpl waiterService, TableServiceImpl tableService, ProductServiceImpl productService) {
        this.waiterService = waiterService;
        this.tableService = tableService;
        this.productService = productService;
    }

    @PostMapping(value = "/create/waiter")
    public String createWaiter(User user) {
        waiterService.createWaiter(user);
        return "redirect:/";
    }

    @PostMapping(value = "/create/table")
    public String createTable(Table table, Model model) {
        tableService.createTable(table);
        return "redirect:/";
    }

    @PostMapping(value = "/create/product")
    public String createProduct(Product product) {
        productService.createProduct(product);
        return "redirect:/";
    }

}
