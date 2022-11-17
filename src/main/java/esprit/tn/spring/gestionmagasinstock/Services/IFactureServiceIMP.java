package esprit.tn.spring.gestionmagasinstock.Services;

import esprit.tn.spring.gestionmagasinstock.Entities.Client;
import esprit.tn.spring.gestionmagasinstock.Entities.Facture;
import esprit.tn.spring.gestionmagasinstock.Repositories.ClientRepository;
import esprit.tn.spring.gestionmagasinstock.Repositories.FactureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class IFactureServiceIMP implements IFactureService{
    @Autowired
    FactureRepository factureRepository;
    @Autowired
    ClientRepository clientRepository;
    @Override
    public List<Facture> retrieveAllFactures() {
        return factureRepository.findAll();
    }

    @Override
    public void cancelFacture(Long id) {
        factureRepository.findById(id).get().setActive(true);
    }

    @Override
    public Facture retrieveFacture(Long id) {
        return factureRepository.findById(id).get();
    }

    @Override
    public List<Facture> getFacturesByClient(Long idClient) {
        return factureRepository.findByClientIdClient(idClient);
    }

    @Override
    public Facture addFacture(Facture f, Long idClient) {
        return null;
    }
}
