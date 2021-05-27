package com.exemplo.aula2.tarde.ex2.repositories;

import com.exemplo.aula2.tarde.ex2.controllers.requests.TableRequest;
import com.exemplo.aula2.tarde.ex2.entities.Order;
import com.exemplo.aula2.tarde.ex2.entities.Table;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class TableRepository {
    private final Map<Long, Table> tables = new HashMap<>();
    private Long nextId = 0L;

    public Table add(TableRequest tableRequest) {
        Long id = nextId++;
        List<Order> orders = tableRequest.getOrders();

        Table table = Table.builder()
                .id(id)
                .orders(orders)
                .totalPrice(orders.stream().mapToDouble(Order::getTotalPrice).sum())
                .build();
        tables.put(id, table);
        return table;
    }

    public Table remove(Long id) {
        return tables.remove(id);
    }

    public Optional<Table> get(Long id) {
        return Optional.ofNullable(tables.get(id));
    }

    public List<Table> all() {
        return new ArrayList<>(tables.values());
    }
}
