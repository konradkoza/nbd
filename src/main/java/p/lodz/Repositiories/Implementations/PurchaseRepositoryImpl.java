package p.lodz.Repositiories.Implementations;

import jakarta.persistence.EntityManager;
import p.lodz.Repositiories.PurchaseRepository;

public class PurchaseRepositoryImpl implements PurchaseRepository {
    private final EntityManager em;
    public PurchaseRepositoryImpl(EntityManager em) {
        this.em = em;
    }
}
