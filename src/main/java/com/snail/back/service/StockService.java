package com.snail.back.service;

import com.snail.back.converter.StockConverter;
import com.snail.back.dto.Stock;
import com.snail.back.entity.StockEntity;
import com.snail.back.exception.StockAlreadyExistException;
import com.snail.back.repository.StockRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class StockService {

    @Autowired
    private final StockRepo stockRepo;

    public void add(StockEntity stock) throws StockAlreadyExistException {
        List<StockEntity> found = stockRepo.findAllByName(stock.getName());

        for (var item : found) {
            if (item.getDate().equals(stock.getDate())) {
                throw new StockAlreadyExistException("Акция с такими параметрами уже существует");
            }
        }

        stockRepo.save(stock);
    }

    public List<Stock> getAll() {
        List<Stock> stocks = new ArrayList<>();

        for (var stock : stockRepo.findByOrderByDate()) {
            stocks.add(StockConverter.toModel(stock));
        }

        return stocks;
    }

    public List<Stock> getRange(Long dateFrom, Long dateTo) {
        List<Stock> stocks = new ArrayList<>();

        for (StockEntity stock : stockRepo.findByOrderByDate()) {
            if (stock.getDate() >= dateFrom && stock.getDate() <= dateTo) {
                stocks.add(StockConverter.toModel(stock));
            }
        }

        return stocks;
    }
}
