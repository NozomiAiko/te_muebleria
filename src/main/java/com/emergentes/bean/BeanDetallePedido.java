/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.emergentes.bean;

import com.emergentes.entidades.DetallePedido;
import com.emergentes.jpa.DetallePedidoJpaController;
import com.emergentes.jpa.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
public class BeanDetallePedido {
    
    private EntityManagerFactory emf;
    private DetallePedidoJpaController jpaDetallePedido;

    public BeanDetallePedido() {
        emf = Persistence.createEntityManagerFactory("muebleriaPU");
        jpaDetallePedido = new DetallePedidoJpaController(emf);
    }

    public List<DetallePedido> listarTodos() {
        return jpaDetallePedido.findDetallePedidoEntities();
    }

    public void insertar(DetallePedido ped) {
        jpaDetallePedido.create(ped);
    }

    public void eliminar(int id) {

        try {
            jpaDetallePedido.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(BeanDetallePedido.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }

    public void modificar(DetallePedido ped) {
        try {
            jpaDetallePedido.edit(ped);
        } catch (Exception ex) {
            Logger.getLogger(BeanDetallePedido.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public DetallePedido buscar(int id) {
        return jpaDetallePedido.findDetallePedido(id);
    }

}
