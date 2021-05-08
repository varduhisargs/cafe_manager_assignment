package com.example.demo.service;

import com.example.demo.model.Table;
import com.example.demo.repository.TableRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TableServiceImpl implements TableService {

    private final TableRepository tableRepository;

    public TableServiceImpl(TableRepository tableRepository) {
        this.tableRepository = tableRepository;
    }

    @Override
    public void createTable(Table table) {
        tableRepository.save(table);
    }

    @Override
    public List<Table> getTablesByUserId(long id) {
        return tableRepository.findByUserId(id);
    }

    @Override
    public List<Table> getAllTables() {
        return tableRepository.findAll();
    }
}
