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
import com.emergentes.entidades.DetalleInventario;
import com.emergentes.entidades.Inventario;
import com.emergentes.jpa.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author 999ma
 */
public class InventarioJpaController implements Serializable {

    public InventarioJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Inventario inventario) {
        if (inventario.getDetalleInventarioList() == null) {
            inventario.setDetalleInventarioList(new ArrayList<DetalleInventario>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Producto idProducto = inventario.getIdProducto();
            if (idProducto != null) {
                idProducto = em.getReference(idProducto.getClass(), idProducto.getIdProducto());
                inventario.setIdProducto(idProducto);
            }
            List<DetalleInventario> attachedDetalleInventarioList = new ArrayList<DetalleInventario>();
            for (DetalleInventario detalleInventarioListDetalleInventarioToAttach : inventario.getDetalleInventarioList()) {
                detalleInventarioListDetalleInventarioToAttach = em.getReference(detalleInventarioListDetalleInventarioToAttach.getClass(), detalleInventarioListDetalleInventarioToAttach.getIdDetalle());
                attachedDetalleInventarioList.add(detalleInventarioListDetalleInventarioToAttach);
            }
            inventario.setDetalleInventarioList(attachedDetalleInventarioList);
            em.persist(inventario);
            if (idProducto != null) {
                idProducto.getInventarioList().add(inventario);
                idProducto = em.merge(idProducto);
            }
            for (DetalleInventario detalleInventarioListDetalleInventario : inventario.getDetalleInventarioList()) {
                Inventario oldIdInventarioOfDetalleInventarioListDetalleInventario = detalleInventarioListDetalleInventario.getIdInventario();
                detalleInventarioListDetalleInventario.setIdInventario(inventario);
                detalleInventarioListDetalleInventario = em.merge(detalleInventarioListDetalleInventario);
                if (oldIdInventarioOfDetalleInventarioListDetalleInventario != null) {
                    oldIdInventarioOfDetalleInventarioListDetalleInventario.getDetalleInventarioList().remove(detalleInventarioListDetalleInventario);
                    oldIdInventarioOfDetalleInventarioListDetalleInventario = em.merge(oldIdInventarioOfDetalleInventarioListDetalleInventario);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Inventario inventario) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Inventario persistentInventario = em.find(Inventario.class, inventario.getIdInventario());
            Producto idProductoOld = persistentInventario.getIdProducto();
            Producto idProductoNew = inventario.getIdProducto();
            List<DetalleInventario> detalleInventarioListOld = persistentInventario.getDetalleInventarioList();
            List<DetalleInventario> detalleInventarioListNew = inventario.getDetalleInventarioList();
            if (idProductoNew != null) {
                idProductoNew = em.getReference(idProductoNew.getClass(), idProductoNew.getIdProducto());
                inventario.setIdProducto(idProductoNew);
            }
            List<DetalleInventario> attachedDetalleInventarioListNew = new ArrayList<DetalleInventario>();
            for (DetalleInventario detalleInventarioListNewDetalleInventarioToAttach : detalleInventarioListNew) {
                detalleInventarioListNewDetalleInventarioToAttach = em.getReference(detalleInventarioListNewDetalleInventarioToAttach.getClass(), detalleInventarioListNewDetalleInventarioToAttach.getIdDetalle());
                attachedDetalleInventarioListNew.add(detalleInventarioListNewDetalleInventarioToAttach);
            }
            detalleInventarioListNew = attachedDetalleInventarioListNew;
            inventario.setDetalleInventarioList(detalleInventarioListNew);
            inventario = em.merge(inventario);
            if (idProductoOld != null && !idProductoOld.equals(idProductoNew)) {
                idProductoOld.getInventarioList().remove(inventario);
                idProductoOld = em.merge(idProductoOld);
            }
            if (idProductoNew != null && !idProductoNew.equals(idProductoOld)) {
                idProductoNew.getInventarioList().add(inventario);
                idProductoNew = em.merge(idProductoNew);
            }
            for (DetalleInventario detalleInventarioListOldDetalleInventario : detalleInventarioListOld) {
                if (!detalleInventarioListNew.contains(detalleInventarioListOldDetalleInventario)) {
                    detalleInventarioListOldDetalleInventario.setIdInventario(null);
                    detalleInventarioListOldDetalleInventario = em.merge(detalleInventarioListOldDetalleInventario);
                }
            }
            for (DetalleInventario detalleInventarioListNewDetalleInventario : detalleInventarioListNew) {
                if (!detalleInventarioListOld.contains(detalleInventarioListNewDetalleInventario)) {
                    Inventario oldIdInventarioOfDetalleInventarioListNewDetalleInventario = detalleInventarioListNewDetalleInventario.getIdInventario();
                    detalleInventarioListNewDetalleInventario.setIdInventario(inventario);
                    detalleInventarioListNewDetalleInventario = em.merge(detalleInventarioListNewDetalleInventario);
                    if (oldIdInventarioOfDetalleInventarioListNewDetalleInventario != null && !oldIdInventarioOfDetalleInventarioListNewDetalleInventario.equals(inventario)) {
                        oldIdInventarioOfDetalleInventarioListNewDetalleInventario.getDetalleInventarioList().remove(detalleInventarioListNewDetalleInventario);
                        oldIdInventarioOfDetalleInventarioListNewDetalleInventario = em.merge(oldIdInventarioOfDetalleInventarioListNewDetalleInventario);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = inventario.getIdInventario();
                if (findInventario(id) == null) {
                    throw new NonexistentEntityException("The inventario with id " + id + " no longer exists.");
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
            Inventario inventario;
            try {
                inventario = em.getReference(Inventario.class, id);
                inventario.getIdInventario();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The inventario with id " + id + " no longer exists.", enfe);
            }
            Producto idProducto = inventario.getIdProducto();
            if (idProducto != null) {
                idProducto.getInventarioList().remove(inventario);
                idProducto = em.merge(idProducto);
            }
            List<DetalleInventario> detalleInventarioList = inventario.getDetalleInventarioList();
            for (DetalleInventario detalleInventarioListDetalleInventario : detalleInventarioList) {
                detalleInventarioListDetalleInventario.setIdInventario(null);
                detalleInventarioListDetalleInventario = em.merge(detalleInventarioListDetalleInventario);
            }
            em.remove(inventario);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Inventario> findInventarioEntities() {
        return findInventarioEntities(true, -1, -1);
    }

    public List<Inventario> findInventarioEntities(int maxResults, int firstResult) {
        return findInventarioEntities(false, maxResults, firstResult);
    }

    private List<Inventario> findInventarioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Inventario.class));
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

    public Inventario findInventario(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Inventario.class, id);
        } finally {
            em.close();
        }
    }

    public int getInventarioCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Inventario> rt = cq.from(Inventario.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
