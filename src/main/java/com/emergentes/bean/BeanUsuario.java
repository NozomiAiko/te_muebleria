package com.emergentes.bean;

import com.emergentes.entidades.Usuario;
import com.emergentes.jpa.UsuarioJpaController;
import com.emergentes.jpa.exceptions.IllegalOrphanException;
import com.emergentes.jpa.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class BeanUsuario {
    
    private EntityManagerFactory emf;
    private UsuarioJpaController jpaUsuario;

    public BeanUsuario() {
        emf = Persistence.createEntityManagerFactory("muebleriaPU");
        jpaUsuario= new UsuarioJpaController(emf);
    }
    public List<Usuario> listarTodos(){
        return jpaUsuario.findUsuarioEntities();
    }
    public void insertar(Usuario cat){
        jpaUsuario.create(cat);
    }
    public void eliminar(int id){
       
        try {
            jpaUsuario.destroy(id);
        } catch (IllegalOrphanException ex) {
            Logger.getLogger(BeanUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(BeanUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void modificar(Usuario cat){
        try {
            jpaUsuario.edit(cat);
        } catch (Exception ex) {
            Logger.getLogger(BeanUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Usuario buscar(int id){
        return jpaUsuario.findUsuario(id);
    }
    
}
