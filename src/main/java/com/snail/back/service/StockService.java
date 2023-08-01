package com.snail.back.service;

import com.snail.back.entity.StockEntity;
import com.snail.back.exception.StockAlreadyExistException;
import com.snail.back.exception.StockNotFoundException;
import com.snail.back.model.Stock;
import com.snail.back.repository.StockRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.ArrayList;

@Service
public class StockService {

    @Autowired
    private StockRepo stockRepo;

    public void add(StockEntity stock) throws StockAlreadyExistException {
        ArrayList<StockEntity> found = stockRepo.findAllByName(stock.getName());

        for (var item : found) {
            if (item.getDate().equals(stock.getDate())) {
                throw new StockAlreadyExistException("Акция с такими параметрами уже существует");
            }
        }

        stockRepo.save(stock);
    }

    public Stock getOne(Long id) throws StockNotFoundException {
        var stock = stockRepo.findById(id);

        if (stock.isEmpty()) {
            throw new StockNotFoundException("Акция не найдена");
        }

        return Stock.toModel(stock.get());
    }

    public Iterable<Stock> getAll() {
        var stocks = new ArrayList<Stock>();

        for (var stock : stockRepo.findByOrderByDate()) {
            stocks.add(Stock.toModel(stock));
        }

        return stocks;
    }

    public Iterable<Stock> getRange(Long dateFrom, Long dateTo) throws InvalidParameterException {
        var stocks = new ArrayList<Stock>();

        for (var stock : stockRepo.findByOrderByDate()) {
            if (stock.getDate() >= dateFrom && stock.getDate() <= dateTo) {
                stocks.add(Stock.toModel(stock));
            }
        }

        return stocks;
    }

    public Long delete(Long id) {
        stockRepo.deleteById(id);
        return id;
    }
}
