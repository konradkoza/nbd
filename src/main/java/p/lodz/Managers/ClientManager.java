package p.lodz.Managers;

import jakarta.persistence.EntityManager;
import p.lodz.Model.Address;
import p.lodz.Model.Client;
import p.lodz.Model.Type.ClientType;
import p.lodz.Repositiories.ClientRepository;
import p.lodz.Repositiories.Implementations.ClientRepositoryImpl;

import java.util.List;

public class ClientManager {
    private final ClientRepository clientRepository;

    public ClientManager(EntityManager em) {
        this.clientRepository = new ClientRepositoryImpl(em);
    }

    public Client getClient(Long id){
        return clientRepository.findClientById(id);
    }

    public Client registerClient(String firstName, String lastName, String city, String street, String number, ClientType clientType){
        Address address = new Address(city, street, number);
        Client client = new Client(firstName, lastName, address, clientType);
        return clientRepository.saveClient(client);
    }

    public List<Client> getAllClients() {
        return clientRepository.findAllClients();
    }

    public Client unregister(Long id){
        return clientRepository.archiveClient(id);
    }
}
