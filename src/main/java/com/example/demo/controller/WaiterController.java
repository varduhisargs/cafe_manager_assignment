package com.example.demo.controller;

import com.example.demo.config.CurrentUser;
import com.example.demo.model.Order;
import com.example.demo.model.ProductInOrder;
import com.example.demo.model.Table;
import com.example.demo.service.OrderService;
import com.example.demo.service.ProductInOrderService;
import com.example.demo.service.TableService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/waiter")
public class WaiterController {

    private final TableService tableService;
    private final OrderService orderService;
    private final ProductInOrderService service;

    public WaiterController(TableService tableService, OrderService orderService, ProductInOrderService service) {
        this.tableService = tableService;
        this.orderService = orderService;
        this.service = service;
    }

    @GetMapping
    public String getTables(@AuthenticationPrincipal CurrentUser currentUser, Model model) {
        List<Table> tablesByUserId = tableService.getTablesByUserId(currentUser.getUser().getId());
        model.addAttribute("tables", tablesByUserId);
        return "waiter";
    }

    @PostMapping("/create/order")
    public String createOrder(Order order) {
        orderService.createOrder(order);
        return "redirect:/";
    }

    @PostMapping("/create/productInOrder")
    public String createProductInOrder(ProductInOrder product) {
        service.createProductInOrder(product);
        return "redirect:/";
    }

//    @PostMapping("/edit/order")
//    public String editOrder(@ModelAttribute) {
//        orderService.createOrder(order);
//        return "redirect:/";
//    }

}
