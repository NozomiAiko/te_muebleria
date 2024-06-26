
package com.emergentes.bean;

import com.emergentes.entidades.Cliente;
import com.emergentes.jpa.ClienteJpaController;
import com.emergentes.jpa.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BeanCliente {
    
    private EntityManagerFactory emf;
    private ClienteJpaController jpaCliente;

    public BeanCliente() {
        emf = Persistence.createEntityManagerFactory("muebleriaPU");
        jpaCliente= new ClienteJpaController(emf);
    }
    public List<Cliente> listarTodos(){
        return jpaCliente.findClienteEntities();
    }
    public void insertar(Cliente cli){
        jpaCliente.create(cli);
    }
    public void eliminar(int id){
        try {
            jpaCliente.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(BeanCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void modificar(Cliente cli){
        try {
            jpaCliente.edit(cli);
        } catch (Exception ex) {
            Logger.getLogger(BeanCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Cliente buscar(int id){
        return jpaCliente.findCliente(id);
    }
    
}
