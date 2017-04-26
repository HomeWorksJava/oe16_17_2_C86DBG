package com.obudai_egyetem.oe_peterlilli;

import com.obudai_egyetem.oe_peterlilli.entity.Mufajok;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class MufajService {

    @PersistenceContext
    EntityManager em;

    public void Create(Object entity) {
        em.persist(entity);
    }

    public List<Mufajok> Read() {
        return em.createNamedQuery("Mufajok.findAll").getResultList();
    }

    public void Update(Object entity) {
        em.merge(entity);
    }

    public void Delete(Object entity) {
        em.remove(em.contains(entity) ? entity : em.merge(entity));
    }

    public Mufajok ReadOne(int id) {
        return (Mufajok) em.createNamedQuery("Mufajok.findById").setParameter("id", id).getSingleResult();
    }

}
