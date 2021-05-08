package com.example.demo.service;


import com.example.demo.model.User;

import java.util.List;

public interface WaiterService {

    void createWaiter(User user);

    List<User> getALl();

}
