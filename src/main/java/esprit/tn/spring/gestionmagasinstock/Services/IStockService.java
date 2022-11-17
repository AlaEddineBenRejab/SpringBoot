package esprit.tn.spring.gestionmagasinstock.Services;

import esprit.tn.spring.gestionmagasinstock.Entities.Stock;

import java.util.List;

public interface IStockService {
    List<Stock> retrieveAllStocks();

    Stock addStock(Stock s);

    Stock updateStock(Stock u);

    Stock retrieveStock(Long id);
}
