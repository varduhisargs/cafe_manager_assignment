package com.example.demo.service;

import com.example.demo.model.Table;

import java.util.List;

public interface TableService {

    void createTable(Table table);

    List<Table> getTablesByUserId(long id);

    List<Table> getAllTables();

}
