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
import com.emergentes.entidades.Cliente;
import com.emergentes.entidades.Usuario;
import com.emergentes.entidades.DetallePedido;
import com.emergentes.entidades.Pedido;
import com.emergentes.jpa.exceptions.IllegalOrphanException;
import com.emergentes.jpa.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author 999ma
 */
public class PedidoJpaController implements Serializable {

    public PedidoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Pedido pedido) {
        if (pedido.getDetallePedidoList() == null) {
            pedido.setDetallePedidoList(new ArrayList<DetallePedido>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cliente codCliente = pedido.getCodCliente();
            if (codCliente != null) {
                codCliente = em.getReference(codCliente.getClass(), codCliente.getIdCliente());
                pedido.setCodCliente(codCliente);
            }
            Usuario codUsuario = pedido.getCodUsuario();
            if (codUsuario != null) {
                codUsuario = em.getReference(codUsuario.getClass(), codUsuario.getIdUsuario());
                pedido.setCodUsuario(codUsuario);
            }
            List<DetallePedido> attachedDetallePedidoList = new ArrayList<DetallePedido>();
            for (DetallePedido detallePedidoListDetallePedidoToAttach : pedido.getDetallePedidoList()) {
                detallePedidoListDetallePedidoToAttach = em.getReference(detallePedidoListDetallePedidoToAttach.getClass(), detallePedidoListDetallePedidoToAttach.getIdDetallePedido());
                attachedDetallePedidoList.add(detallePedidoListDetallePedidoToAttach);
            }
            pedido.setDetallePedidoList(attachedDetallePedidoList);
            em.persist(pedido);
            if (codCliente != null) {
                codCliente.getPedidoList().add(pedido);
                codCliente = em.merge(codCliente);
            }
            if (codUsuario != null) {
                codUsuario.getPedidoList().add(pedido);
                codUsuario = em.merge(codUsuario);
            }
            for (DetallePedido detallePedidoListDetallePedido : pedido.getDetallePedidoList()) {
                Pedido oldIdPedidoOfDetallePedidoListDetallePedido = detallePedidoListDetallePedido.getIdPedido();
                detallePedidoListDetallePedido.setIdPedido(pedido);
                detallePedidoListDetallePedido = em.merge(detallePedidoListDetallePedido);
                if (oldIdPedidoOfDetallePedidoListDetallePedido != null) {
                    oldIdPedidoOfDetallePedidoListDetallePedido.getDetallePedidoList().remove(detallePedidoListDetallePedido);
                    oldIdPedidoOfDetallePedidoListDetallePedido = em.merge(oldIdPedidoOfDetallePedidoListDetallePedido);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Pedido pedido) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Pedido persistentPedido = em.find(Pedido.class, pedido.getIdPedido());
            Cliente codClienteOld = persistentPedido.getCodCliente();
            Cliente codClienteNew = pedido.getCodCliente();
            Usuario codUsuarioOld = persistentPedido.getCodUsuario();
            Usuario codUsuarioNew = pedido.getCodUsuario();
            List<DetallePedido> detallePedidoListOld = persistentPedido.getDetallePedidoList();
            List<DetallePedido> detallePedidoListNew = pedido.getDetallePedidoList();
            List<String> illegalOrphanMessages = null;
            for (DetallePedido detallePedidoListOldDetallePedido : detallePedidoListOld) {
                if (!detallePedidoListNew.contains(detallePedidoListOldDetallePedido)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain DetallePedido " + detallePedidoListOldDetallePedido + " since its idPedido field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (codClienteNew != null) {
                codClienteNew = em.getReference(codClienteNew.getClass(), codClienteNew.getIdCliente());
                pedido.setCodCliente(codClienteNew);
            }
            if (codUsuarioNew != null) {
                codUsuarioNew = em.getReference(codUsuarioNew.getClass(), codUsuarioNew.getIdUsuario());
                pedido.setCodUsuario(codUsuarioNew);
            }
            List<DetallePedido> attachedDetallePedidoListNew = new ArrayList<DetallePedido>();
            for (DetallePedido detallePedidoListNewDetallePedidoToAttach : detallePedidoListNew) {
                detallePedidoListNewDetallePedidoToAttach = em.getReference(detallePedidoListNewDetallePedidoToAttach.getClass(), detallePedidoListNewDetallePedidoToAttach.getIdDetallePedido());
                attachedDetallePedidoListNew.add(detallePedidoListNewDetallePedidoToAttach);
            }
            detallePedidoListNew = attachedDetallePedidoListNew;
            pedido.setDetallePedidoList(detallePedidoListNew);
            pedido = em.merge(pedido);
            if (codClienteOld != null && !codClienteOld.equals(codClienteNew)) {
                codClienteOld.getPedidoList().remove(pedido);
                codClienteOld = em.merge(codClienteOld);
            }
            if (codClienteNew != null && !codClienteNew.equals(codClienteOld)) {
                codClienteNew.getPedidoList().add(pedido);
                codClienteNew = em.merge(codClienteNew);
            }
            if (codUsuarioOld != null && !codUsuarioOld.equals(codUsuarioNew)) {
                codUsuarioOld.getPedidoList().remove(pedido);
                codUsuarioOld = em.merge(codUsuarioOld);
            }
            if (codUsuarioNew != null && !codUsuarioNew.equals(codUsuarioOld)) {
                codUsuarioNew.getPedidoList().add(pedido);
                codUsuarioNew = em.merge(codUsuarioNew);
            }
            for (DetallePedido detallePedidoListNewDetallePedido : detallePedidoListNew) {
                if (!detallePedidoListOld.contains(detallePedidoListNewDetallePedido)) {
                    Pedido oldIdPedidoOfDetallePedidoListNewDetallePedido = detallePedidoListNewDetallePedido.getIdPedido();
                    detallePedidoListNewDetallePedido.setIdPedido(pedido);
                    detallePedidoListNewDetallePedido = em.merge(detallePedidoListNewDetallePedido);
                    if (oldIdPedidoOfDetallePedidoListNewDetallePedido != null && !oldIdPedidoOfDetallePedidoListNewDetallePedido.equals(pedido)) {
                        oldIdPedidoOfDetallePedidoListNewDetallePedido.getDetallePedidoList().remove(detallePedidoListNewDetallePedido);
                        oldIdPedidoOfDetallePedidoListNewDetallePedido = em.merge(oldIdPedidoOfDetallePedidoListNewDetallePedido);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = pedido.getIdPedido();
                if (findPedido(id) == null) {
                    throw new NonexistentEntityException("The pedido with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Pedido pedido;
            try {
                pedido = em.getReference(Pedido.class, id);
                pedido.getIdPedido();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The pedido with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<DetallePedido> detallePedidoListOrphanCheck = pedido.getDetallePedidoList();
            for (DetallePedido detallePedidoListOrphanCheckDetallePedido : detallePedidoListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Pedido (" + pedido + ") cannot be destroyed since the DetallePedido " + detallePedidoListOrphanCheckDetallePedido + " in its detallePedidoList field has a non-nullable idPedido field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Cliente codCliente = pedido.getCodCliente();
            if (codCliente != null) {
                codCliente.getPedidoList().remove(pedido);
                codCliente = em.merge(codCliente);
            }
            Usuario codUsuario = pedido.getCodUsuario();
            if (codUsuario != null) {
                codUsuario.getPedidoList().remove(pedido);
                codUsuario = em.merge(codUsuario);
            }
            em.remove(pedido);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Pedido> findPedidoEntities() {
        return findPedidoEntities(true, -1, -1);
    }

    public List<Pedido> findPedidoEntities(int maxResults, int firstResult) {
        return findPedidoEntities(false, maxResults, firstResult);
    }

    private List<Pedido> findPedidoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Pedido.class));
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

    public Pedido findPedido(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Pedido.class, id);
        } finally {
            em.close();
        }
    }

    public int getPedidoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Pedido> rt = cq.from(Pedido.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
