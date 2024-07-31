
package com.jpconsultoria.ingweb.Repositorios;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.jpconsultoria.ingweb.Entidades.Cliente;


@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente, Long>{

}
