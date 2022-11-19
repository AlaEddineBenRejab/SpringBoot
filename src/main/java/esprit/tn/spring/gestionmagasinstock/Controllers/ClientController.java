package esprit.tn.spring.gestionmagasinstock.Controllers;

import esprit.tn.spring.gestionmagasinstock.Entities.CategorieClient;
import esprit.tn.spring.gestionmagasinstock.Entities.Client;
import esprit.tn.spring.gestionmagasinstock.Services.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("Client")
public class ClientController {
    @Autowired
    IClientService clientService;
    @GetMapping("/getAll")
    public List<Client> retrieveAll(){
        return clientService.retrieveAllClients();
    }
    @PostMapping("/add")
    public Client addClient(@RequestBody Client client){
        return clientService.addClient(client);
    }
    @DeleteMapping("/delete/{id}")
    public void deletClient(@PathVariable(value = "id") Long id){
        clientService.deletClient(id);
    }
    @PutMapping("/update")
    public Client updateClient(@RequestBody Client c){
        return clientService.updateClient(c);
    }
    @GetMapping("getOne/{id}")
    public Client retrieveClient(@PathVariable(value = "id") Long id){
        return clientService.retrieveClient(id);
    }
    @GetMapping("/getChiffreAffaireParCategorieClient")
    public float getChiffreAffaireParCategorieClient(@RequestBody CategorieClient categorieClient,@RequestBody Date startDate,@RequestBody Date endDate){
        return clientService.getChiffreAffaireParCategorieClient(categorieClient,startDate,endDate);
    }
}
