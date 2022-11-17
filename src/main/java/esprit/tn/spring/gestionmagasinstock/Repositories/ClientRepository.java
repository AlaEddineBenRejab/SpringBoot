package esprit.tn.spring.gestionmagasinstock.Repositories;

import esprit.tn.spring.gestionmagasinstock.Entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Long> {

}
