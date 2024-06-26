/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.emergentes.bean;

import com.emergentes.entidades.Venta;
import com.emergentes.jpa.VentaJpaController;
import com.emergentes.jpa.exceptions.IllegalOrphanException;
import com.emergentes.jpa.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author 999ma
 */
public class BeanVenta {
    
    private EntityManagerFactory emf;
    private VentaJpaController jpaVenta;

    public BeanVenta() {
        emf = Persistence.createEntityManagerFactory("muebleriaPU");
        jpaVenta= new VentaJpaController(emf);
    }
    public List<Venta> listarTodos(){
        return jpaVenta.findVentaEntities();
    }
    public void insertar(Venta cat){
        jpaVenta.create(cat);
    }
    public void eliminar(int id){
       
        try {
            jpaVenta.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(BeanVenta.class.getName()).log(Level.SEVERE, null, ex);
        }      
    }
    public void modificar(Venta cat){
        try {
            jpaVenta.edit(cat);
        } catch (Exception ex) {
            Logger.getLogger(BeanVenta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Venta buscar(int id){
        return jpaVenta.findVenta(id);
    }
    
}
