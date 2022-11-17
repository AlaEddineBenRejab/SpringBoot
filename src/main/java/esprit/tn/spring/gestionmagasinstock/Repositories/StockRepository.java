package esprit.tn.spring.gestionmagasinstock.Repositories;

import esprit.tn.spring.gestionmagasinstock.Entities.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock,Long> {
}
