package com.sebastian.hello.service;

import com.sebastian.hello.modelo.Empresa;
import java.util.List;


public interface EmpresaDao {
   void add(Empresa person);
   Empresa buscar(long id);
}
