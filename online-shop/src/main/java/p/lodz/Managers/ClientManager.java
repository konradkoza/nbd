package p.lodz.managers;

import p.lodz.model.Client;
import p.lodz.model.ClientType;
import p.lodz.model.Standard;
import p.lodz.repositiories.Repository;

import java.util.ArrayList;
import java.util.function.Predicate;

public class ClientManager {
    private Repository<Client> clientRepository;

    public ClientManager() {
        this.clientRepository = new Repository<Client>();
    }

    public Client getClient(int id){
        return clientRepository.find(client -> client.getId() == id).get(0);
    }

    public Client registerClient(String firstName, String lastName, String city, String street, String number){
        int nextID;
        if(clientRepository.size() == 0){
            nextID = 0;
        }else {
            int last = clientRepository.size() - 1 ;
            nextID = clientRepository.getElement(last).getId() + 1 ;

        }
        ClientType standard = new Standard();
        Client newClient = new Client(firstName, lastName, nextID, city, street, number, standard);
        clientRepository.addElement(newClient);

        return newClient;

    }

    public ArrayList<Client> findAllClients(Predicate<Client> predicate){
        Predicate<Client> clientPredicate = client -> {
            return predicate.test(client) && !client.isArchived();
        };
        return clientRepository.find(clientPredicate);
    }

    public ArrayList<Client> findAllClients() {
        return clientRepository.findAll();
    }

    public void unregister(int id){
        getClient(id).setArchived(true);
    }

    public Client getClientByNumber(int number){
        return clientRepository.getElement(number);
    }
}
