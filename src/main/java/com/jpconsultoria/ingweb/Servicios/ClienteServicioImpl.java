package com.jpconsultoria.ingweb.Servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpconsultoria.ingweb.Entidades.Cliente;
import com.jpconsultoria.ingweb.Repositorios.ClienteRepositorio;

@Service
public class ClienteServicioImpl implements ClienteServicio {

     @Autowired
    private ClienteRepositorio clienteRepository;

    @Override
    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente obtenerCliente(Long id) {
        return clienteRepository.findById(id).get();
    }

    @Override
    public Cliente crearCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }


    /* @Override
    public int actualizarCliente(Long id, Cliente clienteActualizado) {
        int res = 0;
    Optional<Cliente> clienteOptional = clienteRepository.findById(id);
    if (clienteOptional.isPresent()) {
        Cliente cliente = clienteOptional.get();
        cliente.setDni(clienteActualizado.getDni());
        cliente.setNombre(clienteActualizado.getNombre());
        cliente.setDireccion(clienteActualizado.getDireccion());
        cliente.setTelefono(clienteActualizado.getTelefono());
        clienteRepository.save(cliente);
        res=1;
    } else {
        res=0;
    }
    return res;
    } */


    @Override
    public void eliminarCliente(Long id) {
        clienteRepository.deleteById(id);
    }

    @Override
	public int save(Cliente c) {
		int res=0;
		Cliente cliente=clienteRepository.save(c);
		if(!cliente.equals(null)) {
			res=1;
		}
		return res;
	}

    @Override
    public Cliente actualizarCliente(Cliente cliente) {

        return clienteRepository.save(cliente);
        
    }

}
