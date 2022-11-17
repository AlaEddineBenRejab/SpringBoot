package esprit.tn.spring.gestionmagasinstock.Repositories;

import esprit.tn.spring.gestionmagasinstock.Entities.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FournisseurRepository extends JpaRepository<Fournisseur,Long> {
}
