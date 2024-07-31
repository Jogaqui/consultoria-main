package com.jpconsultoria.ingweb.Servicios;


import java.util.List;

import com.jpconsultoria.ingweb.Entidades.Cliente;

public interface ClienteServicio {
    
    public List<Cliente> listarClientes();
    public Cliente crearCliente(Cliente cliente);
    public int save(Cliente c);
    public Cliente obtenerCliente(Long id);
    public Cliente actualizarCliente(Cliente cliente);
    public void eliminarCliente(Long id);


}
