
package com.jpconsultoria.ingweb.Controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jpconsultoria.ingweb.Entidades.Cliente;
import com.jpconsultoria.ingweb.Servicios.ClienteServicio;

@Controller
@RequestMapping("/clientes")
public class ClienteController {


	 @Autowired
    private ClienteServicio clienteService;

    @GetMapping("/lista")
    public String listarClientes(Model model) {
        model.addAttribute("clientes", clienteService.listarClientes());
        return "clientes/lista";
    }

    @GetMapping("/crear")
    public String mostrarFormularioCrear(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "clientes/formulario";
    }

/*     @PostMapping
    public String crearCliente(@ModelAttribute("cliente") Cliente cliente) {
        clienteService.crearCliente(cliente);
        return "redirect:/clientes";
    } */
    @PostMapping("/save")
	public String save(@Validated Cliente c, Model model) {
		clienteService.save(c);
		model.addAttribute("titulo", "Crear nuevo Cliente");
		return "redirect:/clientes/lista";
	}

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        /* Optional<Cliente> cliente = clienteService.obtenerCliente(id); */
        model.addAttribute("cliente", clienteService.obtenerCliente(id));
        return "clientes/edit";
    }

    @PostMapping("/{id}")
    public String actualizarCliente(@PathVariable Long id, @ModelAttribute("cliente") Cliente cliente) {
        /* clienteService.actualizarCliente(id, cliente); */
        Cliente clienteExistente = clienteService.obtenerCliente(id);
        clienteExistente.setId(id);
        clienteExistente.setDni(cliente.getDni());
        clienteExistente.setNombre(cliente.getNombre());
        clienteExistente.setDireccion(cliente.getDireccion());
        clienteExistente.setTelefono(cliente.getTelefono());
        clienteService.actualizarCliente(clienteExistente);
        return "redirect:/clientes/lista";
    }


    @GetMapping("/eliminar/{id}")
    public String eliminarCliente(@PathVariable Long id) {
        clienteService.eliminarCliente(id);
        return "redirect:/clientes/lista";
    }

}
