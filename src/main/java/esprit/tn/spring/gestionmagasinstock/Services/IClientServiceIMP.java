package esprit.tn.spring.gestionmagasinstock.Services;

import esprit.tn.spring.gestionmagasinstock.Entities.Client;
import esprit.tn.spring.gestionmagasinstock.Repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class IClientServiceIMP implements IClientService{
    @Autowired
    ClientRepository clientRepository;
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
}
