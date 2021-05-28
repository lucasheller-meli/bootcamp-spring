package com.exemplo.aula2.tarde.ex2.controllers;

import com.exemplo.aula2.tarde.ex2.controllers.requests.TableRequest;
import com.exemplo.aula2.tarde.ex2.entities.Table;
import com.exemplo.aula2.tarde.ex2.exceptions.TableNotFound;
import com.exemplo.aula2.tarde.ex2.services.TableService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/tables")
public class TableController {
    private final TableService tableService;

    public TableController(TableService tableService) {
        this.tableService = tableService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Table> get(@PathVariable Long id) throws TableNotFound {
        return ResponseEntity.ok(tableService.get(id));
    }

    @GetMapping
    public ResponseEntity<List<Table>> all() {
        return ResponseEntity.ok(tableService.all());
    }

    @PostMapping
    public ResponseEntity<Table> add(@RequestBody TableRequest tableRequest) {
        Table table = tableService.add(tableRequest);

        URI location = URI.create(String.format("/tables/%s", table.getId()));


        return ResponseEntity.created(location).body(table);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Table> closeTable(@PathVariable Long id) throws TableNotFound {
        return ResponseEntity.ok(tableService.closeTable(id));
    }
}
