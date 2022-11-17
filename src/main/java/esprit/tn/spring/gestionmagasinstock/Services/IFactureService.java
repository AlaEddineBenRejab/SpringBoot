package esprit.tn.spring.gestionmagasinstock.Services;

import esprit.tn.spring.gestionmagasinstock.Entities.Facture;

import java.util.List;

public interface IFactureService {

    List<Facture> retrieveAllFactures();
    void cancelFacture(Long id);
    Facture retrieveFacture(Long id);
    List<Facture> getFacturesByClient(Long idClient);
    Facture addFacture(Facture f, Long idClient);
}
