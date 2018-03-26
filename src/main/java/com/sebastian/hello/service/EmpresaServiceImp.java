package com.sebastian.hello.service;

import com.sebastian.hello.modelo.Empresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author sebastian
 */
@Service
public class EmpresaServiceImp implements EmpresaService {

   @Autowired
   private EmpresaDao userDao;

   @Transactional
   @Override
   public void add(Empresa person) {
      userDao.add(person);
   }

   @Transactional(readOnly = true)
   @Override
   public Empresa buscar(long id) {
      return userDao.buscar(id);
   }

}
