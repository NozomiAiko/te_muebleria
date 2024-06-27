/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.emergentes.jpa;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.emergentes.entidades.Producto;
import com.emergentes.entidades.Cliente;
import com.emergentes.entidades.Usuario;
import com.emergentes.entidades.Venta;
import com.emergentes.jpa.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author 999ma
 */
public class VentaJpaController implements Serializable {

    public VentaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Venta venta) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Producto cd1Producto = venta.getCd1Producto();
            if (cd1Producto != null) {
                cd1Producto = em.getReference(cd1Producto.getClass(), cd1Producto.getIdProducto());
                venta.setCd1Producto(cd1Producto);
            }
            Cliente idCliente = venta.getIdCliente();
            if (idCliente != null) {
                idCliente = em.getReference(idCliente.getClass(), idCliente.getIdCliente());
                venta.setIdCliente(idCliente);
            }
            Usuario idUsuario = venta.getIdUsuario();
            if (idUsuario != null) {
                idUsuario = em.getReference(idUsuario.getClass(), idUsuario.getIdUsuario());
                venta.setIdUsuario(idUsuario);
            }
            em.persist(venta);
            if (cd1Producto != null) {
                cd1Producto.getVentaList().add(venta);
                cd1Producto = em.merge(cd1Producto);
            }
            if (idCliente != null) {
                idCliente.getVentaList().add(venta);
                idCliente = em.merge(idCliente);
            }
            if (idUsuario != null) {
                idUsuario.getVentaList().add(venta);
                idUsuario = em.merge(idUsuario);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Venta venta) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Venta persistentVenta = em.find(Venta.class, venta.getIdVenta());
            Producto cd1ProductoOld = persistentVenta.getCd1Producto();
            Producto cd1ProductoNew = venta.getCd1Producto();
            Cliente idClienteOld = persistentVenta.getIdCliente();
            Cliente idClienteNew = venta.getIdCliente();
            Usuario idUsuarioOld = persistentVenta.getIdUsuario();
            Usuario idUsuarioNew = venta.getIdUsuario();
            if (cd1ProductoNew != null) {
                cd1ProductoNew = em.getReference(cd1ProductoNew.getClass(), cd1ProductoNew.getIdProducto());
                venta.setCd1Producto(cd1ProductoNew);
            }
            if (idClienteNew != null) {
                idClienteNew = em.getReference(idClienteNew.getClass(), idClienteNew.getIdCliente());
                venta.setIdCliente(idClienteNew);
            }
            if (idUsuarioNew != null) {
                idUsuarioNew = em.getReference(idUsuarioNew.getClass(), idUsuarioNew.getIdUsuario());
                venta.setIdUsuario(idUsuarioNew);
            }
            venta = em.merge(venta);
            if (cd1ProductoOld != null && !cd1ProductoOld.equals(cd1ProductoNew)) {
                cd1ProductoOld.getVentaList().remove(venta);
                cd1ProductoOld = em.merge(cd1ProductoOld);
            }
            if (cd1ProductoNew != null && !cd1ProductoNew.equals(cd1ProductoOld)) {
                cd1ProductoNew.getVentaList().add(venta);
                cd1ProductoNew = em.merge(cd1ProductoNew);
            }
            if (idClienteOld != null && !idClienteOld.equals(idClienteNew)) {
                idClienteOld.getVentaList().remove(venta);
                idClienteOld = em.merge(idClienteOld);
            }
            if (idClienteNew != null && !idClienteNew.equals(idClienteOld)) {
                idClienteNew.getVentaList().add(venta);
                idClienteNew = em.merge(idClienteNew);
            }
            if (idUsuarioOld != null && !idUsuarioOld.equals(idUsuarioNew)) {
                idUsuarioOld.getVentaList().remove(venta);
                idUsuarioOld = em.merge(idUsuarioOld);
            }
            if (idUsuarioNew != null && !idUsuarioNew.equals(idUsuarioOld)) {
                idUsuarioNew.getVentaList().add(venta);
                idUsuarioNew = em.merge(idUsuarioNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = venta.getIdVenta();
                if (findVenta(id) == null) {
                    throw new NonexistentEntityException("The venta with id " + id + " no longer exists.");
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
            Venta venta;
            try {
                venta = em.getReference(Venta.class, id);
                venta.getIdVenta();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The venta with id " + id + " no longer exists.", enfe);
            }
            Producto cd1Producto = venta.getCd1Producto();
            if (cd1Producto != null) {
                cd1Producto.getVentaList().remove(venta);
                cd1Producto = em.merge(cd1Producto);
            }
            Cliente idCliente = venta.getIdCliente();
            if (idCliente != null) {
                idCliente.getVentaList().remove(venta);
                idCliente = em.merge(idCliente);
            }
            Usuario idUsuario = venta.getIdUsuario();
            if (idUsuario != null) {
                idUsuario.getVentaList().remove(venta);
                idUsuario = em.merge(idUsuario);
            }
            em.remove(venta);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Venta> findVentaEntities() {
        return findVentaEntities(true, -1, -1);
    }

    public List<Venta> findVentaEntities(int maxResults, int firstResult) {
        return findVentaEntities(false, maxResults, firstResult);
    }

    private List<Venta> findVentaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Venta.class));
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

    public Venta findVenta(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Venta.class, id);
        } finally {
            em.close();
        }
    }

    public int getVentaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Venta> rt = cq.from(Venta.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
