package com.example.demo.controller;

import com.example.demo.config.CurrentUser;
import com.example.demo.model.*;
import com.example.demo.service.*;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainController {

    private final WaiterService waiterService;
    private final TableService tableService;
    private final OrderService orderService;
    private final ProductInOrderService service;
    private final ProductService productService;

    public MainController(WaiterService waiterService, TableService tableService, OrderService orderService, ProductInOrderService service, ProductService productService) {
        this.waiterService = waiterService;
        this.tableService = tableService;
        this.orderService = orderService;
        this.service = service;
        this.productService = productService;
    }

    @GetMapping("/")
    public String main(@AuthenticationPrincipal CurrentUser currentUser, Order order, Model model) {
        model.addAttribute("user", currentUser);
        List<Product> all = productService.getAll();
        model.addAttribute("products", all);

        if (currentUser.getUser().getUserType().equals(UserType.WAITER)) {

            List<Table> tablesByUserId = tableService.getTablesByUserId(currentUser.getUser().getId());
            List<Order> waiterOrder = orderService.getWaiterOrder(currentUser.getUser().getId());
            model.addAttribute("waiterOrders", waiterOrder);
            model.addAttribute("tables", tablesByUserId);

        } else {

            List<Order> allOrders = orderService.getAll();
            List<Table> allTables = tableService.getAllTables();
            List<User> byUserType = waiterService.getALl();
            model.addAttribute("orders", allOrders);
            model.addAttribute("waiters", byUserType);
            model.addAttribute("tables", allTables);

        }
        return "index";
    }

}
