/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.emergentes.bean;

import com.emergentes.entidades.DetalleInventario;
import com.emergentes.jpa.DetalleInventarioJpaController;
import com.emergentes.jpa.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class BeanDetalleInventario {

    private EntityManagerFactory emf;
    private DetalleInventarioJpaController jpaDetalleInventario;

    public BeanDetalleInventario() {
        emf = Persistence.createEntityManagerFactory("muebleriaPU");
        jpaDetalleInventario = new DetalleInventarioJpaController(emf);
    }

    public List<DetalleInventario> listarTodos() {
        return jpaDetalleInventario.findDetalleInventarioEntities();
    }

    public void insertar(DetalleInventario ped) {
        jpaDetalleInventario.create(ped);
    }

    public void eliminar(int id) {

        try {
            jpaDetalleInventario.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(BeanDetalleInventario.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }

    public void modificar(DetalleInventario ped) {
        try {
            jpaDetalleInventario.edit(ped);
        } catch (Exception ex) {
            Logger.getLogger(BeanDetalleInventario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public DetalleInventario buscar(int id) {
        return jpaDetalleInventario.findDetalleInventario(id);
    }
    
}
