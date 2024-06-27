/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.emergentes.bean;

import com.emergentes.entidades.Pedido;
import com.emergentes.jpa.PedidoJpaController;
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
public class BeanPedido {

    private EntityManagerFactory emf;
    private PedidoJpaController jpaPedido;

    public BeanPedido() {
        emf = Persistence.createEntityManagerFactory("muebleriaPU");
        jpaPedido = new PedidoJpaController(emf);
    }

    public List<Pedido> listarTodos() {
        return jpaPedido.findPedidoEntities();
    }

    public void insertar(Pedido ped) {
        jpaPedido.create(ped);
    }

    public void eliminar(int id) {

        try {
            try {
                jpaPedido.destroy(id);
            } catch (IllegalOrphanException ex) {
                Logger.getLogger(BeanPedido.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(BeanPedido.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void modificar(Pedido ped) {
        try {
            jpaPedido.edit(ped);
        } catch (Exception ex) {
            Logger.getLogger(BeanPedido.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Pedido buscar(int id) {
        return jpaPedido.findPedido(id);
    }

}
