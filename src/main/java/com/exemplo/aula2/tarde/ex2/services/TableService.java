package com.exemplo.aula2.tarde.ex2.services;

import com.exemplo.aula2.tarde.ex2.controllers.requests.TableRequest;
import com.exemplo.aula2.tarde.ex2.entities.Restaurant;
import com.exemplo.aula2.tarde.ex2.entities.Table;
import com.exemplo.aula2.tarde.ex2.exceptions.TableNotFound;
import com.exemplo.aula2.tarde.ex2.repositories.TableRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TableService {
    private final TableRepository tableRepository;

    public TableService(TableRepository tableRepository) {
        this.tableRepository = tableRepository;
    }

    public Table get(Long id) throws TableNotFound {
        return tableRepository.get(id).orElseThrow(() -> new TableNotFound(id));
    }

    public Table add(TableRequest table) {
        return tableRepository.add(table);
    }

    public Table remove(Long id) {
        return tableRepository.remove(id);
    }

    public List<Table> all() {
        return tableRepository.all();
    }

    public Table closeTable(Long id) throws TableNotFound {
        Table table = get(id);
        Double totalPrice = table.getTotalPrice();
        Restaurant.addCash(totalPrice);
        table.setOrders(new ArrayList<>());
        table.setTotalPrice(0.0);
        return table;
    }
}
