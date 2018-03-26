package com.sebastian.hello.repo;

import com.sebastian.hello.modelo.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 *
 * @author sebastian
 */
@Repository
public interface EmpresaRepo extends JpaRepository<Empresa, Long> {
    
}
