package esprit.tn.spring.gestionmagasinstock.Services;

import esprit.tn.spring.gestionmagasinstock.Entities.Client;

import java.util.List;

public interface IClientService {
    List<Client> retrieveAllClients();
    Client addClient(Client client);
    void deletClient(Long id);
    Client updateClient(Client c);
    Client retrieveClient(Long id);
}
