package esprit.tn.spring.gestionmagasinstock.Services;

import esprit.tn.spring.gestionmagasinstock.Entities.Fournisseur;
import esprit.tn.spring.gestionmagasinstock.Entities.Produit;
import esprit.tn.spring.gestionmagasinstock.Entities.Rayon;
import esprit.tn.spring.gestionmagasinstock.Entities.Stock;
import esprit.tn.spring.gestionmagasinstock.Repositories.FournisseurRepository;
import esprit.tn.spring.gestionmagasinstock.Repositories.ProduitRepository;
import esprit.tn.spring.gestionmagasinstock.Repositories.RayonRepository;
import esprit.tn.spring.gestionmagasinstock.Repositories.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class IProduitServiceIMP implements IProduitService{
    @Autowired
    ProduitRepository produitRepository;
    @Autowired
    RayonRepository rayonRepository;
    @Autowired
    StockRepository stockRepository;
    @Autowired
    FournisseurRepository fournisseurRepository;
    @Override
    public List<Produit> retrieveAllProduits() {
        return produitRepository.findAll();
    }

    @Override
    public Produit addProduit(Produit p, Long idRayon, Long idStock) {

        Stock stock = stockRepository.findById(idStock).get();
        Rayon rayon = rayonRepository.findById(idRayon).get();
        if (rayon!=null&&stock!=null){
            p.setRayon(rayon);
            p.setStock(stock);
            return  produitRepository.save(p);
        }
        return null;
    }

    @Override
    public Produit retrieveProduit(Long id) {
        return produitRepository.findById(id).get();
    }

    @Override
    public void assignProduitToStock(Long idProduit, Long idStock) {
        Produit produit = produitRepository.findById(idProduit).get();
        Stock stock = stockRepository.findById(idStock).get();
        if ((produit!=null)&&(stock!=null))
        {
            produit.setStock(stock);
            produitRepository.save(produit);
        }
    }

    @Override
    public void assignFournisseurToProduit(Long fournisseurId, Long produitId) {
        Fournisseur f = fournisseurRepository.findById(fournisseurId).orElse(null);
        Produit p = produitRepository.findById(produitId).orElse(null);
        if(f!=null && p!=null){
            p.getFournisseurs().add(f);
            produitRepository.save(p);
        }
    }
}
