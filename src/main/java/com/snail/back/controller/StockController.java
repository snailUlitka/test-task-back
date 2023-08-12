package com.snail.back.controller;

import com.snail.back.dto.Stock;
import com.snail.back.entity.StockEntity;
import com.snail.back.exception.StockAlreadyExistException;
import com.snail.back.exception.StockNotFound;
import com.snail.back.service.StockService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/stock")
public class StockController {

    @Autowired
    private final StockService stockService;

    @PostMapping
    public ResponseEntity<String> addStock(@RequestBody StockEntity stock) throws StockAlreadyExistException {
        stockService.add(stock);

        return new ResponseEntity<>("Акция добавлена", HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Stock>> getAll() {
        List<Stock> stocks = stockService.getAll();

        return new ResponseEntity<>(stocks, HttpStatus.OK);
    }

    @GetMapping("/range")
    public ResponseEntity<List<Stock>> getRange(@RequestParam Long from, @RequestParam Long to) {
        List<Stock> stocks = stockService.getRange(from, to);

        return new ResponseEntity<>(stocks, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<String> patchStock(@PathVariable Long id, @RequestBody StockEntity stock)
            throws StockNotFound {
        stockService.patch(id, stock);

        return new ResponseEntity<>("Акция изменена", HttpStatus.OK);
    }

    @ExceptionHandler(StockAlreadyExistException.class)
    public ResponseEntity<String> handleException(StockAlreadyExistException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(StockNotFound.class)
    public ResponseEntity<String> handleException(StockNotFound e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
}
