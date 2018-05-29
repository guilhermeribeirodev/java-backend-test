package com.yoti.wedding_invite.repository;

import com.yoti.wedding_invite.model.InviteePerson;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

@Repository
@Transactional(readOnly = true)
public class InviteePersonRepo<T> {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void save(T ob) {
        try {
            em.persist(ob);
            em.flush();
        } catch (PersistenceException pe) {
            System.out.println("============================");
            System.out.println(pe.getMessage());
        }
    }

    public InviteePerson find() {
        return (InviteePerson)
                em.createQuery("select i from InviteePerson i").getResultList().get(0);
    }

}
