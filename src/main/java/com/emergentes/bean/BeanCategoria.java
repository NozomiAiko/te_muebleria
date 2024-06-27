
package com.emergentes.bean;
import com.emergentes.entidades.Categoria;
import com.emergentes.jpa.CategoriaJpaController;
import com.emergentes.jpa.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BeanCategoria {
  
    private EntityManagerFactory emf;
    private CategoriaJpaController jpaCategoria;

    public BeanCategoria() {
        emf = Persistence.createEntityManagerFactory("muebleriaPU");
        jpaCategoria= new CategoriaJpaController(emf);
    }
    public List<Categoria> listarTodos(){
        return jpaCategoria.findCategoriaEntities();
    }
    public void insertar(Categoria cat){
        jpaCategoria.create(cat);
    }
    public void eliminar(int id){
        try {
            jpaCategoria.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(BeanCategoria.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void modificar(Categoria cat){
        try {
            jpaCategoria.edit(cat);
        } catch (Exception ex) {
            Logger.getLogger(BeanCategoria.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Categoria buscar(int id){
        return jpaCategoria.findCategoria(id);
    }
    
}


