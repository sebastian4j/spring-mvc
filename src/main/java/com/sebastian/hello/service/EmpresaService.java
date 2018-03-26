package com.sebastian.hello.service;

import com.sebastian.hello.modelo.Empresa;

/**
 *
 * @author sebastian
 */
public interface EmpresaService {
    void add(Empresa person);
    Empresa buscar(long id);
}
