package esprit.tn.spring.gestionmagasinstock.Services;

import esprit.tn.spring.gestionmagasinstock.Entities.Produit;

import java.util.List;

public interface IProduitService {

    List<Produit> retrieveAllProduits();

    Produit addProduit(Produit p, Long idRayon, Long idStock);

    Produit retrieveProduit(Long id);
    void assignProduitToStock(Long idProduit, Long idStock);
    void assignFournisseurToProduit(Long fournisseurId, Long produitId) ;
}
