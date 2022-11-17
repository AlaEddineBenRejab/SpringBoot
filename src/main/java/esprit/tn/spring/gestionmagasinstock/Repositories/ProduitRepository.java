package esprit.tn.spring.gestionmagasinstock.Repositories;

import esprit.tn.spring.gestionmagasinstock.Entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitRepository extends JpaRepository<Produit,Long>{
}
