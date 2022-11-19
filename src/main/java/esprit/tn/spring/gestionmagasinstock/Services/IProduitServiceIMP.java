package esprit.tn.spring.gestionmagasinstock.Services;

import esprit.tn.spring.gestionmagasinstock.Entities.*;
import esprit.tn.spring.gestionmagasinstock.Repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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
    @Autowired
    DetailFactureRepository detailFactureRepository;
    @Autowired
    FactureRepository factureRepository;

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

    @Override
    public float getRevenuBrutProduit(Long idProduit, Date startDate, Date endDate) {
        Produit p = produitRepository.findById(idProduit).get();
        float prix=0;
        for(DetailFacture df:detailFactureRepository.findAll()){
            if(df.getProduit().equals(p)){
                if(factureRepository.findByDetailFactures(df).getDateFacture().before(endDate)
                        &&factureRepository.findByDetailFactures(df).getDateFacture().after(startDate)){
                    prix=prix + (p.getPrixUnitaire()*df.getQte());
                }

            }
        }

        return prix;
    }
}
