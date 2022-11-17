package esprit.tn.spring.gestionmagasinstock.Repositories;

import esprit.tn.spring.gestionmagasinstock.Entities.DetailProduit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetailProduitRepository extends JpaRepository<DetailProduit,Long> {
}
