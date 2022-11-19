package esprit.tn.spring.gestionmagasinstock.Repositories;

import esprit.tn.spring.gestionmagasinstock.Entities.CategorieClient;
import esprit.tn.spring.gestionmagasinstock.Entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client,Long> {

    public List<Client> getClientByCategorieClient(CategorieClient categorieClient);

}
