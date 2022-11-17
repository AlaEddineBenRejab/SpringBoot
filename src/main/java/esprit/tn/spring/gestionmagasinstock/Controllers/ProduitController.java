package esprit.tn.spring.gestionmagasinstock.Controllers;

import esprit.tn.spring.gestionmagasinstock.Entities.Produit;
import esprit.tn.spring.gestionmagasinstock.Services.IProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Produit")
public class ProduitController {
    @Autowired
    IProduitService iProduitService;
    @GetMapping("/getAll")
    public List<Produit> retrieveAllProducts(){
        return iProduitService.retrieveAllProduits();
    }
    @PostMapping("/add/{idR}/{idS}")
    public Produit addProduit(@RequestBody Produit p, @PathVariable(value = "idR") Long idRayon,@PathVariable(value = "idS") Long idStock){
        return  iProduitService.addProduit(p,idRayon,idStock);
    }
    @GetMapping("/getOne/{id}")
    public Produit retrieveProduit(@PathVariable(value = "id") long idProduit){
        return iProduitService.retrieveProduit(idProduit);
    }
}
