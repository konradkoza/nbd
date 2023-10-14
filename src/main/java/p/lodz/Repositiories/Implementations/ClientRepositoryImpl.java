package p.lodz.Repositiories.Implementations;

import jakarta.persistence.EntityManager;
import p.lodz.Model.Client;
import p.lodz.Repositiories.ClientRepository;

public class ClientRepositoryImpl implements ClientRepository {
    private final EntityManager em;
    public ClientRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public Client saveClient(Client client) {
        if(client.getId() == null) em.persist(client);
        else client = em.merge(client);
        return client;
    }

    @Override
    public Client archiveClient(Long id) {
        Client client = em.find(Client.class, id);
        if (client != null) {
            client.setArchived(true);
            em.merge(client);
        }
        return client;
    }
}
