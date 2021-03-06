package com.obudai_egyetem.oe_peterlilli;

import com.obudai_egyetem.oe_peterlilli.entity.Filmek;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class FilmService {

    @PersistenceContext
    EntityManager em;

    public void Create(Object entity) {
        em.persist(entity);
    }

    public List<Filmek> Read() {
        return em.createNamedQuery("Filmek.findAll").getResultList();
    }

    public void Update(Object entity) {
        em.merge(entity);
    }

    public void Delete(Object entity) {
        em.remove(em.contains(entity) ? entity : em.merge(entity));
    }

    public Filmek ReadOne(int id) {
        return (Filmek) em.createNamedQuery("Filmek.findById").setParameter("id", id).getSingleResult();
    }

}
