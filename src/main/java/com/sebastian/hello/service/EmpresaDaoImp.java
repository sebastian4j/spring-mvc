package com.sebastian.hello.service;

import com.sebastian.hello.modelo.Empresa;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.orm.jpa.EntityManagerFactoryInfo;
import org.springframework.stereotype.Repository;

/**
 *
 * @author sebastian
 */
@Repository
public class EmpresaDaoImp implements EmpresaDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void add(Empresa person) {
        em.persist(person);
    }

    @Override
    public Empresa buscar(long id) {
        EntityManagerFactoryInfo info = (EntityManagerFactoryInfo) em.getEntityManagerFactory();
        System.out.println("DS:" + info.getDataSource());
        return em.find(Empresa.class, id);
    }

}
