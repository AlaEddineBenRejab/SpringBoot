package esprit.tn.spring.gestionmagasinstock.Repositories;

import esprit.tn.spring.gestionmagasinstock.Entities.Facture;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FactureRepository extends JpaRepository<Facture,Long> {
    public List<Facture>findByClientIdClient(Long idClient);
}
