/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.emergentes.jpa;

import com.emergentes.entidades.Cliente;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.emergentes.entidades.Venta;
import java.util.ArrayList;
import java.util.List;
import com.emergentes.entidades.Pedido;
import com.emergentes.jpa.exceptions.NonexistentEntityException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author 999ma
 */
public class ClienteJpaController implements Serializable {

    public ClienteJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Cliente cliente) {
        if (cliente.getVentaList() == null) {
            cliente.setVentaList(new ArrayList<Venta>());
        }
        if (cliente.getPedidoList() == null) {
            cliente.setPedidoList(new ArrayList<Pedido>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Venta> attachedVentaList = new ArrayList<Venta>();
            for (Venta ventaListVentaToAttach : cliente.getVentaList()) {
                ventaListVentaToAttach = em.getReference(ventaListVentaToAttach.getClass(), ventaListVentaToAttach.getIdVenta());
                attachedVentaList.add(ventaListVentaToAttach);
            }
            cliente.setVentaList(attachedVentaList);
            List<Pedido> attachedPedidoList = new ArrayList<Pedido>();
            for (Pedido pedidoListPedidoToAttach : cliente.getPedidoList()) {
                pedidoListPedidoToAttach = em.getReference(pedidoListPedidoToAttach.getClass(), pedidoListPedidoToAttach.getIdPedido());
                attachedPedidoList.add(pedidoListPedidoToAttach);
            }
            cliente.setPedidoList(attachedPedidoList);
            em.persist(cliente);
            for (Venta ventaListVenta : cliente.getVentaList()) {
                Cliente oldIdClienteOfVentaListVenta = ventaListVenta.getIdCliente();
                ventaListVenta.setIdCliente(cliente);
                ventaListVenta = em.merge(ventaListVenta);
                if (oldIdClienteOfVentaListVenta != null) {
                    oldIdClienteOfVentaListVenta.getVentaList().remove(ventaListVenta);
                    oldIdClienteOfVentaListVenta = em.merge(oldIdClienteOfVentaListVenta);
                }
            }
            for (Pedido pedidoListPedido : cliente.getPedidoList()) {
                Cliente oldCodClienteOfPedidoListPedido = pedidoListPedido.getCodCliente();
                pedidoListPedido.setCodCliente(cliente);
                pedidoListPedido = em.merge(pedidoListPedido);
                if (oldCodClienteOfPedidoListPedido != null) {
                    oldCodClienteOfPedidoListPedido.getPedidoList().remove(pedidoListPedido);
                    oldCodClienteOfPedidoListPedido = em.merge(oldCodClienteOfPedidoListPedido);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Cliente cliente) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cliente persistentCliente = em.find(Cliente.class, cliente.getIdCliente());
            List<Venta> ventaListOld = persistentCliente.getVentaList();
            List<Venta> ventaListNew = cliente.getVentaList();
            List<Pedido> pedidoListOld = persistentCliente.getPedidoList();
            List<Pedido> pedidoListNew = cliente.getPedidoList();
            List<Venta> attachedVentaListNew = new ArrayList<Venta>();
            for (Venta ventaListNewVentaToAttach : ventaListNew) {
                ventaListNewVentaToAttach = em.getReference(ventaListNewVentaToAttach.getClass(), ventaListNewVentaToAttach.getIdVenta());
                attachedVentaListNew.add(ventaListNewVentaToAttach);
            }
            ventaListNew = attachedVentaListNew;
            cliente.setVentaList(ventaListNew);
            List<Pedido> attachedPedidoListNew = new ArrayList<Pedido>();
            for (Pedido pedidoListNewPedidoToAttach : pedidoListNew) {
                pedidoListNewPedidoToAttach = em.getReference(pedidoListNewPedidoToAttach.getClass(), pedidoListNewPedidoToAttach.getIdPedido());
                attachedPedidoListNew.add(pedidoListNewPedidoToAttach);
            }
            pedidoListNew = attachedPedidoListNew;
            cliente.setPedidoList(pedidoListNew);
            cliente = em.merge(cliente);
            for (Venta ventaListOldVenta : ventaListOld) {
                if (!ventaListNew.contains(ventaListOldVenta)) {
                    ventaListOldVenta.setIdCliente(null);
                    ventaListOldVenta = em.merge(ventaListOldVenta);
                }
            }
            for (Venta ventaListNewVenta : ventaListNew) {
                if (!ventaListOld.contains(ventaListNewVenta)) {
                    Cliente oldIdClienteOfVentaListNewVenta = ventaListNewVenta.getIdCliente();
                    ventaListNewVenta.setIdCliente(cliente);
                    ventaListNewVenta = em.merge(ventaListNewVenta);
                    if (oldIdClienteOfVentaListNewVenta != null && !oldIdClienteOfVentaListNewVenta.equals(cliente)) {
                        oldIdClienteOfVentaListNewVenta.getVentaList().remove(ventaListNewVenta);
                        oldIdClienteOfVentaListNewVenta = em.merge(oldIdClienteOfVentaListNewVenta);
                    }
                }
            }
            for (Pedido pedidoListOldPedido : pedidoListOld) {
                if (!pedidoListNew.contains(pedidoListOldPedido)) {
                    pedidoListOldPedido.setCodCliente(null);
                    pedidoListOldPedido = em.merge(pedidoListOldPedido);
                }
            }
            for (Pedido pedidoListNewPedido : pedidoListNew) {
                if (!pedidoListOld.contains(pedidoListNewPedido)) {
                    Cliente oldCodClienteOfPedidoListNewPedido = pedidoListNewPedido.getCodCliente();
                    pedidoListNewPedido.setCodCliente(cliente);
                    pedidoListNewPedido = em.merge(pedidoListNewPedido);
                    if (oldCodClienteOfPedidoListNewPedido != null && !oldCodClienteOfPedidoListNewPedido.equals(cliente)) {
                        oldCodClienteOfPedidoListNewPedido.getPedidoList().remove(pedidoListNewPedido);
                        oldCodClienteOfPedidoListNewPedido = em.merge(oldCodClienteOfPedidoListNewPedido);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = cliente.getIdCliente();
                if (findCliente(id) == null) {
                    throw new NonexistentEntityException("The cliente with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cliente cliente;
            try {
                cliente = em.getReference(Cliente.class, id);
                cliente.getIdCliente();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The cliente with id " + id + " no longer exists.", enfe);
            }
            List<Venta> ventaList = cliente.getVentaList();
            for (Venta ventaListVenta : ventaList) {
                ventaListVenta.setIdCliente(null);
                ventaListVenta = em.merge(ventaListVenta);
            }
            List<Pedido> pedidoList = cliente.getPedidoList();
            for (Pedido pedidoListPedido : pedidoList) {
                pedidoListPedido.setCodCliente(null);
                pedidoListPedido = em.merge(pedidoListPedido);
            }
            em.remove(cliente);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Cliente> findClienteEntities() {
        return findClienteEntities(true, -1, -1);
    }

    public List<Cliente> findClienteEntities(int maxResults, int firstResult) {
        return findClienteEntities(false, maxResults, firstResult);
    }

    private List<Cliente> findClienteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Cliente.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Cliente findCliente(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Cliente.class, id);
        } finally {
            em.close();
        }
    }

    public int getClienteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Cliente> rt = cq.from(Cliente.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
