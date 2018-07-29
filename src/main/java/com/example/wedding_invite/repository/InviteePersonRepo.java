package com.example.wedding_invite.repository;

import com.example.wedding_invite.model.Invitation;
import com.example.wedding_invite.model.InviteePerson;
import com.example.wedding_invite.model.InviteePerson_;
import com.example.wedding_invite.model.Relation;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class InviteePersonRepo<T> {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public T save(T ob) {
        try {
            return em.merge(ob);
            //em.flush();
        } catch (PersistenceException pe) {
            System.out.println("============================");
            System.out.println(pe.getMessage());
        }

        return  null;
    }

    @Transactional
    public void saveLots(List<T> ob) {
        try {
            for(T it : ob)
                em.persist(it);
            em.flush();
        } catch (PersistenceException pe) {
            System.out.println("============================");
            System.out.println(pe.getMessage());
        }
    }

    public InviteePerson find() {
        return (InviteePerson)
                em.createQuery("select i from InviteePerson i join fetch i.invitations inv join fetch inv.to").getResultList().get(0);
    }

    public InviteePerson find(long id) {
        return (InviteePerson)
                em.createQuery("select i from InviteePerson i left join fetch i.invitations where i.id = :id")
                        .setParameter("id", id)
                        .getResultList().get(0);
    }

    public List<InviteePerson> findAll() {
        return em.createQuery("select i from InviteePerson i left join fetch i.invitations inv join fetch inv.to").getResultList();
    }

    public List<InviteePerson> findCriteria(String name){ Date today = new Date();

        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<InviteePerson> query = builder.createQuery(InviteePerson.class);
        Root<InviteePerson> root = query.from(InviteePerson.class);

        Predicate hasBirthday = builder.equal(root.get(InviteePerson_.name), name);
        //Predicate isLongTermCustomer = builder.lessThan(root.get(InviteePerson_.createdAt), today);
        query.where(builder.and(hasBirthday));
        return em.createQuery(query.select(root)).getResultList();
    }

    public InviteePerson find(String name) {
        return (InviteePerson)
                em.createQuery("select i from InviteePerson i left join fetch i.invitations inv " +
                " where i.name = :name ").setParameter("name",name)
                .getResultList().get(0);
    }

    public List<InviteePerson> find(InviteePerson user, Relation relation) {
        return
                em.createQuery("select new com.example.wedding_invite.model.InvitationDTO( inv.from.name, inv.to.name, inv.relation) from InviteePerson i join i.invitations inv " +
                        " " +
                        " where inv.from = :user or inv.to = :user " +
                        " and inv.relation = :relation group by inv.from.name, inv.to.name, inv.relation")
                        .setParameter("user",user)
                        .setParameter("relation",relation)
                        .getResultList();
    }
}
