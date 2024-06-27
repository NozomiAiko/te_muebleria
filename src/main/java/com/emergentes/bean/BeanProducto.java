/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.emergentes.bean;

import com.emergentes.entidades.Producto;
import com.emergentes.jpa.ProductoJpaController;
import com.emergentes.jpa.exceptions.IllegalOrphanException;
import com.emergentes.jpa.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BeanProducto {
    private EntityManagerFactory emf;
    private ProductoJpaController jpaProducto;

    public BeanProducto() {
        emf = Persistence.createEntityManagerFactory("muebleriaPU");
        jpaProducto= new ProductoJpaController(emf);
    }
    public List<Producto> listarTodos(){
        return jpaProducto.findProductoEntities();
    }
    public void insertar(Producto pro){
        jpaProducto.create(pro);
    }
    public void eliminar(int id){
        
        try {
            jpaProducto.destroy(id);
        } catch (IllegalOrphanException ex) {
            Logger.getLogger(BeanProducto.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(BeanProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void modificar(Producto pro){
        try {
            jpaProducto.edit(pro);
        } catch (Exception ex) {
            Logger.getLogger(BeanProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Producto buscar(int id){
        return jpaProducto.findProducto(id);
    }
}
