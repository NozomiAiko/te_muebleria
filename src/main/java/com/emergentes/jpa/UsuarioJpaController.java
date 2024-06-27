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
import com.emergentes.entidades.Venta;
import java.util.ArrayList;
import java.util.List;
import com.emergentes.entidades.Pedido;
import com.emergentes.entidades.Usuario;
import com.emergentes.jpa.exceptions.IllegalOrphanException;
import com.emergentes.jpa.exceptions.NonexistentEntityException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author 999ma
 */
public class UsuarioJpaController implements Serializable {

    public UsuarioJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Usuario usuario) {
        if (usuario.getVentaList() == null) {
            usuario.setVentaList(new ArrayList<Venta>());
        }
        if (usuario.getPedidoList() == null) {
            usuario.setPedidoList(new ArrayList<Pedido>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Venta> attachedVentaList = new ArrayList<Venta>();
            for (Venta ventaListVentaToAttach : usuario.getVentaList()) {
                ventaListVentaToAttach = em.getReference(ventaListVentaToAttach.getClass(), ventaListVentaToAttach.getIdVenta());
                attachedVentaList.add(ventaListVentaToAttach);
            }
            usuario.setVentaList(attachedVentaList);
            List<Pedido> attachedPedidoList = new ArrayList<Pedido>();
            for (Pedido pedidoListPedidoToAttach : usuario.getPedidoList()) {
                pedidoListPedidoToAttach = em.getReference(pedidoListPedidoToAttach.getClass(), pedidoListPedidoToAttach.getIdPedido());
                attachedPedidoList.add(pedidoListPedidoToAttach);
            }
            usuario.setPedidoList(attachedPedidoList);
            em.persist(usuario);
            for (Venta ventaListVenta : usuario.getVentaList()) {
                Usuario oldIdUsuarioOfVentaListVenta = ventaListVenta.getIdUsuario();
                ventaListVenta.setIdUsuario(usuario);
                ventaListVenta = em.merge(ventaListVenta);
                if (oldIdUsuarioOfVentaListVenta != null) {
                    oldIdUsuarioOfVentaListVenta.getVentaList().remove(ventaListVenta);
                    oldIdUsuarioOfVentaListVenta = em.merge(oldIdUsuarioOfVentaListVenta);
                }
            }
            for (Pedido pedidoListPedido : usuario.getPedidoList()) {
                Usuario oldCodUsuarioOfPedidoListPedido = pedidoListPedido.getCodUsuario();
                pedidoListPedido.setCodUsuario(usuario);
                pedidoListPedido = em.merge(pedidoListPedido);
                if (oldCodUsuarioOfPedidoListPedido != null) {
                    oldCodUsuarioOfPedidoListPedido.getPedidoList().remove(pedidoListPedido);
                    oldCodUsuarioOfPedidoListPedido = em.merge(oldCodUsuarioOfPedidoListPedido);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Usuario usuario) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Usuario persistentUsuario = em.find(Usuario.class, usuario.getIdUsuario());
            List<Venta> ventaListOld = persistentUsuario.getVentaList();
            List<Venta> ventaListNew = usuario.getVentaList();
            List<Pedido> pedidoListOld = persistentUsuario.getPedidoList();
            List<Pedido> pedidoListNew = usuario.getPedidoList();
            List<String> illegalOrphanMessages = null;
            for (Pedido pedidoListOldPedido : pedidoListOld) {
                if (!pedidoListNew.contains(pedidoListOldPedido)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Pedido " + pedidoListOldPedido + " since its codUsuario field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<Venta> attachedVentaListNew = new ArrayList<Venta>();
            for (Venta ventaListNewVentaToAttach : ventaListNew) {
                ventaListNewVentaToAttach = em.getReference(ventaListNewVentaToAttach.getClass(), ventaListNewVentaToAttach.getIdVenta());
                attachedVentaListNew.add(ventaListNewVentaToAttach);
            }
            ventaListNew = attachedVentaListNew;
            usuario.setVentaList(ventaListNew);
            List<Pedido> attachedPedidoListNew = new ArrayList<Pedido>();
            for (Pedido pedidoListNewPedidoToAttach : pedidoListNew) {
                pedidoListNewPedidoToAttach = em.getReference(pedidoListNewPedidoToAttach.getClass(), pedidoListNewPedidoToAttach.getIdPedido());
                attachedPedidoListNew.add(pedidoListNewPedidoToAttach);
            }
            pedidoListNew = attachedPedidoListNew;
            usuario.setPedidoList(pedidoListNew);
            usuario = em.merge(usuario);
            for (Venta ventaListOldVenta : ventaListOld) {
                if (!ventaListNew.contains(ventaListOldVenta)) {
                    ventaListOldVenta.setIdUsuario(null);
                    ventaListOldVenta = em.merge(ventaListOldVenta);
                }
            }
            for (Venta ventaListNewVenta : ventaListNew) {
                if (!ventaListOld.contains(ventaListNewVenta)) {
                    Usuario oldIdUsuarioOfVentaListNewVenta = ventaListNewVenta.getIdUsuario();
                    ventaListNewVenta.setIdUsuario(usuario);
                    ventaListNewVenta = em.merge(ventaListNewVenta);
                    if (oldIdUsuarioOfVentaListNewVenta != null && !oldIdUsuarioOfVentaListNewVenta.equals(usuario)) {
                        oldIdUsuarioOfVentaListNewVenta.getVentaList().remove(ventaListNewVenta);
                        oldIdUsuarioOfVentaListNewVenta = em.merge(oldIdUsuarioOfVentaListNewVenta);
                    }
                }
            }
            for (Pedido pedidoListNewPedido : pedidoListNew) {
                if (!pedidoListOld.contains(pedidoListNewPedido)) {
                    Usuario oldCodUsuarioOfPedidoListNewPedido = pedidoListNewPedido.getCodUsuario();
                    pedidoListNewPedido.setCodUsuario(usuario);
                    pedidoListNewPedido = em.merge(pedidoListNewPedido);
                    if (oldCodUsuarioOfPedidoListNewPedido != null && !oldCodUsuarioOfPedidoListNewPedido.equals(usuario)) {
                        oldCodUsuarioOfPedidoListNewPedido.getPedidoList().remove(pedidoListNewPedido);
                        oldCodUsuarioOfPedidoListNewPedido = em.merge(oldCodUsuarioOfPedidoListNewPedido);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = usuario.getIdUsuario();
                if (findUsuario(id) == null) {
                    throw new NonexistentEntityException("The usuario with id " + id + " no longer exists.");
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
            Usuario usuario;
            try {
                usuario = em.getReference(Usuario.class, id);
                usuario.getIdUsuario();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The usuario with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Pedido> pedidoListOrphanCheck = usuario.getPedidoList();
            for (Pedido pedidoListOrphanCheckPedido : pedidoListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Usuario (" + usuario + ") cannot be destroyed since the Pedido " + pedidoListOrphanCheckPedido + " in its pedidoList field has a non-nullable codUsuario field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<Venta> ventaList = usuario.getVentaList();
            for (Venta ventaListVenta : ventaList) {
                ventaListVenta.setIdUsuario(null);
                ventaListVenta = em.merge(ventaListVenta);
            }
            em.remove(usuario);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Usuario> findUsuarioEntities() {
        return findUsuarioEntities(true, -1, -1);
    }

    public List<Usuario> findUsuarioEntities(int maxResults, int firstResult) {
        return findUsuarioEntities(false, maxResults, firstResult);
    }

    private List<Usuario> findUsuarioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Usuario.class));
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

    public Usuario findUsuario(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Usuario.class, id);
        } finally {
            em.close();
        }
    }

    public int getUsuarioCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Usuario> rt = cq.from(Usuario.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
