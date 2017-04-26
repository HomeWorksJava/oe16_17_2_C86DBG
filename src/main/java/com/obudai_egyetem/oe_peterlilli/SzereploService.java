package com.obudai_egyetem.oe_peterlilli;

import com.obudai_egyetem.oe_peterlilli.entity.Szereplok;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class SzereploService {

    @PersistenceContext
    EntityManager em;

    public void Create(Object entity) {
        em.persist(entity);
    }

    public List<Szereplok> Read() {
        return em.createNamedQuery("Szereplok.findAll").getResultList();
    }

    public void Update(Object entity) {
        em.merge(entity);
    }

    public void Delete(Object entity) {
        em.remove(em.contains(entity) ? entity : em.merge(entity));
    }

    public Szereplok ReadOne(int id) {
        return (Szereplok) em.createNamedQuery("Szereplok.findById").setParameter("id", id).getSingleResult();
    }

}
