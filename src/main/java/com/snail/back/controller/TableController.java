package com.snail.back.controller;

import com.snail.back.entity.StockEntity;
import com.snail.back.exception.StockAlreadyExistException;
import com.snail.back.exception.StockNotFoundException;
import com.snail.back.model.Stock;
import com.snail.back.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stock")
public class TableController {

    @Autowired
    private StockService stockService;

    @PostMapping
    public ResponseEntity addStock(@RequestBody StockEntity stock) {
        try {
            stockService.add(stock);
            return ResponseEntity.ok().body("Акция добавлена");
        } catch (StockAlreadyExistException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка!");
        }
    }

    @GetMapping
    public ResponseEntity getStock(@RequestParam Long id) {
        try {
            return ResponseEntity.ok().body(stockService.getOne(id));
        } catch (StockNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка!");
        }
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<Stock>> getAll() {
        try {
            var stocks = stockService.getAll();

            return new ResponseEntity<>(stocks, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/range")
    public ResponseEntity<Iterable<Stock>> getRange(@RequestParam Long from, @RequestParam Long to) {
        try {
            var stocks = stockService.getRange(from, to);

            return new ResponseEntity<>(stocks, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteStock(@PathVariable Long id) {
        try {
            return ResponseEntity.ok().body("Удален по id: " + stockService.delete(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка!");
        }
    }
}
