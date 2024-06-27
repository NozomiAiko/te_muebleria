/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.emergentes.jpa;

import com.emergentes.entidades.DetallePedido;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.emergentes.entidades.Producto;
import com.emergentes.entidades.Pedido;
import com.emergentes.jpa.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author 999ma
 */
public class DetallePedidoJpaController implements Serializable {

    public DetallePedidoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(DetallePedido detallePedido) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Producto codProducto = detallePedido.getCodProducto();
            if (codProducto != null) {
                codProducto = em.getReference(codProducto.getClass(), codProducto.getIdProducto());
                detallePedido.setCodProducto(codProducto);
            }
            Pedido idPedido = detallePedido.getIdPedido();
            if (idPedido != null) {
                idPedido = em.getReference(idPedido.getClass(), idPedido.getIdPedido());
                detallePedido.setIdPedido(idPedido);
            }
            em.persist(detallePedido);
            if (codProducto != null) {
                codProducto.getDetallePedidoList().add(detallePedido);
                codProducto = em.merge(codProducto);
            }
            if (idPedido != null) {
                idPedido.getDetallePedidoList().add(detallePedido);
                idPedido = em.merge(idPedido);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(DetallePedido detallePedido) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            DetallePedido persistentDetallePedido = em.find(DetallePedido.class, detallePedido.getIdDetallePedido());
            Producto codProductoOld = persistentDetallePedido.getCodProducto();
            Producto codProductoNew = detallePedido.getCodProducto();
            Pedido idPedidoOld = persistentDetallePedido.getIdPedido();
            Pedido idPedidoNew = detallePedido.getIdPedido();
            if (codProductoNew != null) {
                codProductoNew = em.getReference(codProductoNew.getClass(), codProductoNew.getIdProducto());
                detallePedido.setCodProducto(codProductoNew);
            }
            if (idPedidoNew != null) {
                idPedidoNew = em.getReference(idPedidoNew.getClass(), idPedidoNew.getIdPedido());
                detallePedido.setIdPedido(idPedidoNew);
            }
            detallePedido = em.merge(detallePedido);
            if (codProductoOld != null && !codProductoOld.equals(codProductoNew)) {
                codProductoOld.getDetallePedidoList().remove(detallePedido);
                codProductoOld = em.merge(codProductoOld);
            }
            if (codProductoNew != null && !codProductoNew.equals(codProductoOld)) {
                codProductoNew.getDetallePedidoList().add(detallePedido);
                codProductoNew = em.merge(codProductoNew);
            }
            if (idPedidoOld != null && !idPedidoOld.equals(idPedidoNew)) {
                idPedidoOld.getDetallePedidoList().remove(detallePedido);
                idPedidoOld = em.merge(idPedidoOld);
            }
            if (idPedidoNew != null && !idPedidoNew.equals(idPedidoOld)) {
                idPedidoNew.getDetallePedidoList().add(detallePedido);
                idPedidoNew = em.merge(idPedidoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = detallePedido.getIdDetallePedido();
                if (findDetallePedido(id) == null) {
                    throw new NonexistentEntityException("The detallePedido with id " + id + " no longer exists.");
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
            DetallePedido detallePedido;
            try {
                detallePedido = em.getReference(DetallePedido.class, id);
                detallePedido.getIdDetallePedido();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The detallePedido with id " + id + " no longer exists.", enfe);
            }
            Producto codProducto = detallePedido.getCodProducto();
            if (codProducto != null) {
                codProducto.getDetallePedidoList().remove(detallePedido);
                codProducto = em.merge(codProducto);
            }
            Pedido idPedido = detallePedido.getIdPedido();
            if (idPedido != null) {
                idPedido.getDetallePedidoList().remove(detallePedido);
                idPedido = em.merge(idPedido);
            }
            em.remove(detallePedido);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<DetallePedido> findDetallePedidoEntities() {
        return findDetallePedidoEntities(true, -1, -1);
    }

    public List<DetallePedido> findDetallePedidoEntities(int maxResults, int firstResult) {
        return findDetallePedidoEntities(false, maxResults, firstResult);
    }

    private List<DetallePedido> findDetallePedidoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(DetallePedido.class));
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

    public DetallePedido findDetallePedido(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(DetallePedido.class, id);
        } finally {
            em.close();
        }
    }

    public int getDetallePedidoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<DetallePedido> rt = cq.from(DetallePedido.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
