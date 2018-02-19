package com.yoti.ihoover.repository;

import com.yoti.ihoover.HooverResult;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class HooverResultRepository {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void save(HooverResult hooverResult) {
        em.persist(hooverResult);
        em.flush();
    }

}
