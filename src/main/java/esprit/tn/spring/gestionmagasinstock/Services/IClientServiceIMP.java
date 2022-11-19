package esprit.tn.spring.gestionmagasinstock.Services;

import esprit.tn.spring.gestionmagasinstock.Entities.CategorieClient;
import esprit.tn.spring.gestionmagasinstock.Entities.Client;
import esprit.tn.spring.gestionmagasinstock.Entities.Facture;
import esprit.tn.spring.gestionmagasinstock.Repositories.ClientRepository;
import esprit.tn.spring.gestionmagasinstock.Repositories.FactureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class IClientServiceIMP implements IClientService{
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    FactureRepository factureRepository;
    @Override
    public List<Client> retrieveAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public Client addClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public void deletClient(Long id) {
        clientRepository.deleteById(id);
    }

    @Override
    public Client updateClient(Client c) {
        return clientRepository.save(c);
    }

    @Override
    public Client retrieveClient(Long id) {
        return clientRepository.findById(id).get();
    }

    @Override
    public float getChiffreAffaireParCategorieClient(CategorieClient categorieClient, Date startDate, Date endDate) {
        float ca=0;
        List<Client> categoryClients= clientRepository.getClientByCategorieClient(categorieClient);
        for(Facture f:factureRepository.findAll()) {
            for (Client c : categoryClients) {
                if (f.getClient().equals(c)){
                    if(f.getDateFacture().after(startDate)&&f.getDateFacture().before(endDate)){
                        ca=ca+f.getMonatantFacture();
                    }
                }
            }
        }

        return ca;
    }

}
