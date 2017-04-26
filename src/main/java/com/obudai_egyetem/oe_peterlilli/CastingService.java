package com.obudai_egyetem.oe_peterlilli;

import com.obudai_egyetem.oe_peterlilli.entity.Castingok;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class CastingService {

    @PersistenceContext
    EntityManager em;

    public void Create(Object entity) {
        em.persist(entity);
    }

    public List<Castingok> Read() {
        return em.createNamedQuery("Castingok.findAll").getResultList();
    }

    public void Update(Object entity) {
        em.merge(entity);
    }

    public void Delete(Object entity) {
        em.remove(em.contains(entity) ? entity : em.merge(entity));
    }

    public Castingok ReadOne(int id) {
        return (Castingok) em.createNamedQuery("Castingok.findById").setParameter("id", id).getSingleResult();
    }

}
