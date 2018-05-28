package com.yoti.ihoover.repository;

import com.yoti.ihoover.HooverResult;
import com.yoti.ihoover.domain.Hoover;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import javax.persistence.criteria.*;
import java.util.Iterator;

@Repository
@Transactional(readOnly = true)
public class HooverResultRepository {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void save(HooverResult hooverResult) {
        try {
            em.persist(hooverResult);
            em.flush();
        }catch (PersistenceException pe) {
            System.out.println("============================");
            System.out.println(pe.getMessage());
        }
    }

    public HooverResult find(){
        return (HooverResult)
                em.createQuery("select r from HooverResult r").getResultList().get(0);
    }


    public Iterator<Tuple> findAllByBuilder() {
        CriteriaBuilder cb = em.getCriteriaBuilder();

        //CriteriaQuery<Object> query = cb.createQuery();
        CriteriaQuery<Tuple> q = cb.createTupleQuery();
        Root<HooverResult> report = q.from(HooverResult.class);
        Fetch<HooverResult,Hoover> fetch = report.fetch("hoover", JoinType.INNER);
        fetch.fetch("hooverResult", JoinType.INNER);

        Predicate predicate = cb.and(

                cb.equal( report.get("id"), 1)
        );

        q.where(predicate);
        TypedQuery<Tuple> query = em.createQuery(q);
        query.getResultList().iterator();

        return query.getResultList().iterator();
    }
}
