/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.emergentes.bean;

import com.emergentes.entidades.Inventario;
import com.emergentes.jpa.InventarioJpaController;
import com.emergentes.jpa.exceptions.IllegalOrphanException;
import com.emergentes.jpa.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BeanInventario {
    private EntityManagerFactory emf;
    private InventarioJpaController jpaInventario;

    public BeanInventario() {
        emf = Persistence.createEntityManagerFactory("muebleriaPU");
        jpaInventario= new InventarioJpaController(emf);
    }
    public List<Inventario> listarTodos(){
        return jpaInventario.findInventarioEntities();
    }
    public void insertar(Inventario pro){
        jpaInventario.create(pro);
    }
    public void eliminar(int id){
        
        try {
            jpaInventario.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(BeanInventario.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
    }
    public void modificar(Inventario pro){
        try {
            jpaInventario.edit(pro);
        } catch (Exception ex) {
            Logger.getLogger(BeanInventario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Inventario buscar(int id){
        return jpaInventario.findInventario(id);
    }
}
