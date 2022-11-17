package esprit.tn.spring.gestionmagasinstock.Controllers;

import esprit.tn.spring.gestionmagasinstock.Entities.Stock;
import esprit.tn.spring.gestionmagasinstock.Services.IStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Stock")
public class StockController {
    @Autowired
    IStockService stockService;

    @GetMapping("/getAll")
    public List<Stock> retrieveAllStocks(){
        return stockService.retrieveAllStocks();
    }
    @PostMapping("/add")
    public Stock addStock(@RequestBody Stock s){
        return stockService.addStock(s);
    }
    @PutMapping("/update")
    public Stock updateStock(@RequestBody Stock u){
        return stockService.updateStock(u);
    }
    @GetMapping("/getOne/{id}")
    public Stock retrieveStock(@PathVariable(value = "id") Long id){
        return stockService.retrieveStock(id);
    }
}
