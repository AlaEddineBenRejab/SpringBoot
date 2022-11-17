package esprit.tn.spring.gestionmagasinstock.Controllers;

import esprit.tn.spring.gestionmagasinstock.Entities.Facture;
import esprit.tn.spring.gestionmagasinstock.Services.IFactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Facture")
public class FactureController {
    @Autowired
    IFactureService factureService;
    @GetMapping("/getAll")
    public List<Facture> retrieveAllFactures(){
        return factureService.retrieveAllFactures();
    }
    @GetMapping("/cancel/{id}")
    public void cancelFacture(@PathVariable(value = "id") Long id){
        factureService.cancelFacture(id);
    }
    @GetMapping("/getOne/{id}")
    public Facture retrieveFacture(@PathVariable(value = "id") Long id){
        return factureService.retrieveFacture(id);
    }
}
