/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.emergentes.jpa;

import com.emergentes.entidades.DetalleInventario;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.emergentes.entidades.Producto;
import com.emergentes.entidades.Inventario;
import com.emergentes.jpa.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author 999ma
 */
public class DetalleInventarioJpaController implements Serializable {

    public DetalleInventarioJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(DetalleInventario detalleInventario) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Producto cdProducto = detalleInventario.getCdProducto();
            if (cdProducto != null) {
                cdProducto = em.getReference(cdProducto.getClass(), cdProducto.getIdProducto());
                detalleInventario.setCdProducto(cdProducto);
            }
            Inventario idInventario = detalleInventario.getIdInventario();
            if (idInventario != null) {
                idInventario = em.getReference(idInventario.getClass(), idInventario.getIdInventario());
                detalleInventario.setIdInventario(idInventario);
            }
            em.persist(detalleInventario);
            if (cdProducto != null) {
                cdProducto.getDetalleInventarioList().add(detalleInventario);
                cdProducto = em.merge(cdProducto);
            }
            if (idInventario != null) {
                idInventario.getDetalleInventarioList().add(detalleInventario);
                idInventario = em.merge(idInventario);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(DetalleInventario detalleInventario) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            DetalleInventario persistentDetalleInventario = em.find(DetalleInventario.class, detalleInventario.getIdDetalle());
            Producto cdProductoOld = persistentDetalleInventario.getCdProducto();
            Producto cdProductoNew = detalleInventario.getCdProducto();
            Inventario idInventarioOld = persistentDetalleInventario.getIdInventario();
            Inventario idInventarioNew = detalleInventario.getIdInventario();
            if (cdProductoNew != null) {
                cdProductoNew = em.getReference(cdProductoNew.getClass(), cdProductoNew.getIdProducto());
                detalleInventario.setCdProducto(cdProductoNew);
            }
            if (idInventarioNew != null) {
                idInventarioNew = em.getReference(idInventarioNew.getClass(), idInventarioNew.getIdInventario());
                detalleInventario.setIdInventario(idInventarioNew);
            }
            detalleInventario = em.merge(detalleInventario);
            if (cdProductoOld != null && !cdProductoOld.equals(cdProductoNew)) {
                cdProductoOld.getDetalleInventarioList().remove(detalleInventario);
                cdProductoOld = em.merge(cdProductoOld);
            }
            if (cdProductoNew != null && !cdProductoNew.equals(cdProductoOld)) {
                cdProductoNew.getDetalleInventarioList().add(detalleInventario);
                cdProductoNew = em.merge(cdProductoNew);
            }
            if (idInventarioOld != null && !idInventarioOld.equals(idInventarioNew)) {
                idInventarioOld.getDetalleInventarioList().remove(detalleInventario);
                idInventarioOld = em.merge(idInventarioOld);
            }
            if (idInventarioNew != null && !idInventarioNew.equals(idInventarioOld)) {
                idInventarioNew.getDetalleInventarioList().add(detalleInventario);
                idInventarioNew = em.merge(idInventarioNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = detalleInventario.getIdDetalle();
                if (findDetalleInventario(id) == null) {
                    throw new NonexistentEntityException("The detalleInventario with id " + id + " no longer exists.");
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
            DetalleInventario detalleInventario;
            try {
                detalleInventario = em.getReference(DetalleInventario.class, id);
                detalleInventario.getIdDetalle();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The detalleInventario with id " + id + " no longer exists.", enfe);
            }
            Producto cdProducto = detalleInventario.getCdProducto();
            if (cdProducto != null) {
                cdProducto.getDetalleInventarioList().remove(detalleInventario);
                cdProducto = em.merge(cdProducto);
            }
            Inventario idInventario = detalleInventario.getIdInventario();
            if (idInventario != null) {
                idInventario.getDetalleInventarioList().remove(detalleInventario);
                idInventario = em.merge(idInventario);
            }
            em.remove(detalleInventario);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<DetalleInventario> findDetalleInventarioEntities() {
        return findDetalleInventarioEntities(true, -1, -1);
    }

    public List<DetalleInventario> findDetalleInventarioEntities(int maxResults, int firstResult) {
        return findDetalleInventarioEntities(false, maxResults, firstResult);
    }

    private List<DetalleInventario> findDetalleInventarioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(DetalleInventario.class));
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

    public DetalleInventario findDetalleInventario(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(DetalleInventario.class, id);
        } finally {
            em.close();
        }
    }

    public int getDetalleInventarioCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<DetalleInventario> rt = cq.from(DetalleInventario.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
