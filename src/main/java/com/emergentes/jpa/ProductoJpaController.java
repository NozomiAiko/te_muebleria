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
import com.emergentes.entidades.Categoria;
import com.emergentes.entidades.Venta;
import java.util.ArrayList;
import java.util.List;
import com.emergentes.entidades.DetallePedido;
import com.emergentes.entidades.DetalleInventario;
import com.emergentes.entidades.Inventario;
import com.emergentes.entidades.Producto;
import com.emergentes.jpa.exceptions.IllegalOrphanException;
import com.emergentes.jpa.exceptions.NonexistentEntityException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author 999ma
 */
public class ProductoJpaController implements Serializable {

    public ProductoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Producto producto) {
        if (producto.getVentaList() == null) {
            producto.setVentaList(new ArrayList<Venta>());
        }
        if (producto.getDetallePedidoList() == null) {
            producto.setDetallePedidoList(new ArrayList<DetallePedido>());
        }
        if (producto.getDetalleInventarioList() == null) {
            producto.setDetalleInventarioList(new ArrayList<DetalleInventario>());
        }
        if (producto.getInventarioList() == null) {
            producto.setInventarioList(new ArrayList<Inventario>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Categoria idCategoria = producto.getIdCategoria();
            if (idCategoria != null) {
                idCategoria = em.getReference(idCategoria.getClass(), idCategoria.getIdCategoria());
                producto.setIdCategoria(idCategoria);
            }
            List<Venta> attachedVentaList = new ArrayList<Venta>();
            for (Venta ventaListVentaToAttach : producto.getVentaList()) {
                ventaListVentaToAttach = em.getReference(ventaListVentaToAttach.getClass(), ventaListVentaToAttach.getIdVenta());
                attachedVentaList.add(ventaListVentaToAttach);
            }
            producto.setVentaList(attachedVentaList);
            List<DetallePedido> attachedDetallePedidoList = new ArrayList<DetallePedido>();
            for (DetallePedido detallePedidoListDetallePedidoToAttach : producto.getDetallePedidoList()) {
                detallePedidoListDetallePedidoToAttach = em.getReference(detallePedidoListDetallePedidoToAttach.getClass(), detallePedidoListDetallePedidoToAttach.getIdDetallePedido());
                attachedDetallePedidoList.add(detallePedidoListDetallePedidoToAttach);
            }
            producto.setDetallePedidoList(attachedDetallePedidoList);
            List<DetalleInventario> attachedDetalleInventarioList = new ArrayList<DetalleInventario>();
            for (DetalleInventario detalleInventarioListDetalleInventarioToAttach : producto.getDetalleInventarioList()) {
                detalleInventarioListDetalleInventarioToAttach = em.getReference(detalleInventarioListDetalleInventarioToAttach.getClass(), detalleInventarioListDetalleInventarioToAttach.getIdDetalle());
                attachedDetalleInventarioList.add(detalleInventarioListDetalleInventarioToAttach);
            }
            producto.setDetalleInventarioList(attachedDetalleInventarioList);
            List<Inventario> attachedInventarioList = new ArrayList<Inventario>();
            for (Inventario inventarioListInventarioToAttach : producto.getInventarioList()) {
                inventarioListInventarioToAttach = em.getReference(inventarioListInventarioToAttach.getClass(), inventarioListInventarioToAttach.getIdInventario());
                attachedInventarioList.add(inventarioListInventarioToAttach);
            }
            producto.setInventarioList(attachedInventarioList);
            em.persist(producto);
            if (idCategoria != null) {
                idCategoria.getProductoList().add(producto);
                idCategoria = em.merge(idCategoria);
            }
            for (Venta ventaListVenta : producto.getVentaList()) {
                Producto oldCd1ProductoOfVentaListVenta = ventaListVenta.getCd1Producto();
                ventaListVenta.setCd1Producto(producto);
                ventaListVenta = em.merge(ventaListVenta);
                if (oldCd1ProductoOfVentaListVenta != null) {
                    oldCd1ProductoOfVentaListVenta.getVentaList().remove(ventaListVenta);
                    oldCd1ProductoOfVentaListVenta = em.merge(oldCd1ProductoOfVentaListVenta);
                }
            }
            for (DetallePedido detallePedidoListDetallePedido : producto.getDetallePedidoList()) {
                Producto oldCodProductoOfDetallePedidoListDetallePedido = detallePedidoListDetallePedido.getCodProducto();
                detallePedidoListDetallePedido.setCodProducto(producto);
                detallePedidoListDetallePedido = em.merge(detallePedidoListDetallePedido);
                if (oldCodProductoOfDetallePedidoListDetallePedido != null) {
                    oldCodProductoOfDetallePedidoListDetallePedido.getDetallePedidoList().remove(detallePedidoListDetallePedido);
                    oldCodProductoOfDetallePedidoListDetallePedido = em.merge(oldCodProductoOfDetallePedidoListDetallePedido);
                }
            }
            for (DetalleInventario detalleInventarioListDetalleInventario : producto.getDetalleInventarioList()) {
                Producto oldCdProductoOfDetalleInventarioListDetalleInventario = detalleInventarioListDetalleInventario.getCdProducto();
                detalleInventarioListDetalleInventario.setCdProducto(producto);
                detalleInventarioListDetalleInventario = em.merge(detalleInventarioListDetalleInventario);
                if (oldCdProductoOfDetalleInventarioListDetalleInventario != null) {
                    oldCdProductoOfDetalleInventarioListDetalleInventario.getDetalleInventarioList().remove(detalleInventarioListDetalleInventario);
                    oldCdProductoOfDetalleInventarioListDetalleInventario = em.merge(oldCdProductoOfDetalleInventarioListDetalleInventario);
                }
            }
            for (Inventario inventarioListInventario : producto.getInventarioList()) {
                Producto oldIdProductoOfInventarioListInventario = inventarioListInventario.getIdProducto();
                inventarioListInventario.setIdProducto(producto);
                inventarioListInventario = em.merge(inventarioListInventario);
                if (oldIdProductoOfInventarioListInventario != null) {
                    oldIdProductoOfInventarioListInventario.getInventarioList().remove(inventarioListInventario);
                    oldIdProductoOfInventarioListInventario = em.merge(oldIdProductoOfInventarioListInventario);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Producto producto) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Producto persistentProducto = em.find(Producto.class, producto.getIdProducto());
            Categoria idCategoriaOld = persistentProducto.getIdCategoria();
            Categoria idCategoriaNew = producto.getIdCategoria();
            List<Venta> ventaListOld = persistentProducto.getVentaList();
            List<Venta> ventaListNew = producto.getVentaList();
            List<DetallePedido> detallePedidoListOld = persistentProducto.getDetallePedidoList();
            List<DetallePedido> detallePedidoListNew = producto.getDetallePedidoList();
            List<DetalleInventario> detalleInventarioListOld = persistentProducto.getDetalleInventarioList();
            List<DetalleInventario> detalleInventarioListNew = producto.getDetalleInventarioList();
            List<Inventario> inventarioListOld = persistentProducto.getInventarioList();
            List<Inventario> inventarioListNew = producto.getInventarioList();
            List<String> illegalOrphanMessages = null;
            for (DetallePedido detallePedidoListOldDetallePedido : detallePedidoListOld) {
                if (!detallePedidoListNew.contains(detallePedidoListOldDetallePedido)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain DetallePedido " + detallePedidoListOldDetallePedido + " since its codProducto field is not nullable.");
                }
            }
            for (DetalleInventario detalleInventarioListOldDetalleInventario : detalleInventarioListOld) {
                if (!detalleInventarioListNew.contains(detalleInventarioListOldDetalleInventario)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain DetalleInventario " + detalleInventarioListOldDetalleInventario + " since its cdProducto field is not nullable.");
                }
            }
            for (Inventario inventarioListOldInventario : inventarioListOld) {
                if (!inventarioListNew.contains(inventarioListOldInventario)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Inventario " + inventarioListOldInventario + " since its idProducto field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (idCategoriaNew != null) {
                idCategoriaNew = em.getReference(idCategoriaNew.getClass(), idCategoriaNew.getIdCategoria());
                producto.setIdCategoria(idCategoriaNew);
            }
            List<Venta> attachedVentaListNew = new ArrayList<Venta>();
            for (Venta ventaListNewVentaToAttach : ventaListNew) {
                ventaListNewVentaToAttach = em.getReference(ventaListNewVentaToAttach.getClass(), ventaListNewVentaToAttach.getIdVenta());
                attachedVentaListNew.add(ventaListNewVentaToAttach);
            }
            ventaListNew = attachedVentaListNew;
            producto.setVentaList(ventaListNew);
            List<DetallePedido> attachedDetallePedidoListNew = new ArrayList<DetallePedido>();
            for (DetallePedido detallePedidoListNewDetallePedidoToAttach : detallePedidoListNew) {
                detallePedidoListNewDetallePedidoToAttach = em.getReference(detallePedidoListNewDetallePedidoToAttach.getClass(), detallePedidoListNewDetallePedidoToAttach.getIdDetallePedido());
                attachedDetallePedidoListNew.add(detallePedidoListNewDetallePedidoToAttach);
            }
            detallePedidoListNew = attachedDetallePedidoListNew;
            producto.setDetallePedidoList(detallePedidoListNew);
            List<DetalleInventario> attachedDetalleInventarioListNew = new ArrayList<DetalleInventario>();
            for (DetalleInventario detalleInventarioListNewDetalleInventarioToAttach : detalleInventarioListNew) {
                detalleInventarioListNewDetalleInventarioToAttach = em.getReference(detalleInventarioListNewDetalleInventarioToAttach.getClass(), detalleInventarioListNewDetalleInventarioToAttach.getIdDetalle());
                attachedDetalleInventarioListNew.add(detalleInventarioListNewDetalleInventarioToAttach);
            }
            detalleInventarioListNew = attachedDetalleInventarioListNew;
            producto.setDetalleInventarioList(detalleInventarioListNew);
            List<Inventario> attachedInventarioListNew = new ArrayList<Inventario>();
            for (Inventario inventarioListNewInventarioToAttach : inventarioListNew) {
                inventarioListNewInventarioToAttach = em.getReference(inventarioListNewInventarioToAttach.getClass(), inventarioListNewInventarioToAttach.getIdInventario());
                attachedInventarioListNew.add(inventarioListNewInventarioToAttach);
            }
            inventarioListNew = attachedInventarioListNew;
            producto.setInventarioList(inventarioListNew);
            producto = em.merge(producto);
            if (idCategoriaOld != null && !idCategoriaOld.equals(idCategoriaNew)) {
                idCategoriaOld.getProductoList().remove(producto);
                idCategoriaOld = em.merge(idCategoriaOld);
            }
            if (idCategoriaNew != null && !idCategoriaNew.equals(idCategoriaOld)) {
                idCategoriaNew.getProductoList().add(producto);
                idCategoriaNew = em.merge(idCategoriaNew);
            }
            for (Venta ventaListOldVenta : ventaListOld) {
                if (!ventaListNew.contains(ventaListOldVenta)) {
                    ventaListOldVenta.setCd1Producto(null);
                    ventaListOldVenta = em.merge(ventaListOldVenta);
                }
            }
            for (Venta ventaListNewVenta : ventaListNew) {
                if (!ventaListOld.contains(ventaListNewVenta)) {
                    Producto oldCd1ProductoOfVentaListNewVenta = ventaListNewVenta.getCd1Producto();
                    ventaListNewVenta.setCd1Producto(producto);
                    ventaListNewVenta = em.merge(ventaListNewVenta);
                    if (oldCd1ProductoOfVentaListNewVenta != null && !oldCd1ProductoOfVentaListNewVenta.equals(producto)) {
                        oldCd1ProductoOfVentaListNewVenta.getVentaList().remove(ventaListNewVenta);
                        oldCd1ProductoOfVentaListNewVenta = em.merge(oldCd1ProductoOfVentaListNewVenta);
                    }
                }
            }
            for (DetallePedido detallePedidoListNewDetallePedido : detallePedidoListNew) {
                if (!detallePedidoListOld.contains(detallePedidoListNewDetallePedido)) {
                    Producto oldCodProductoOfDetallePedidoListNewDetallePedido = detallePedidoListNewDetallePedido.getCodProducto();
                    detallePedidoListNewDetallePedido.setCodProducto(producto);
                    detallePedidoListNewDetallePedido = em.merge(detallePedidoListNewDetallePedido);
                    if (oldCodProductoOfDetallePedidoListNewDetallePedido != null && !oldCodProductoOfDetallePedidoListNewDetallePedido.equals(producto)) {
                        oldCodProductoOfDetallePedidoListNewDetallePedido.getDetallePedidoList().remove(detallePedidoListNewDetallePedido);
                        oldCodProductoOfDetallePedidoListNewDetallePedido = em.merge(oldCodProductoOfDetallePedidoListNewDetallePedido);
                    }
                }
            }
            for (DetalleInventario detalleInventarioListNewDetalleInventario : detalleInventarioListNew) {
                if (!detalleInventarioListOld.contains(detalleInventarioListNewDetalleInventario)) {
                    Producto oldCdProductoOfDetalleInventarioListNewDetalleInventario = detalleInventarioListNewDetalleInventario.getCdProducto();
                    detalleInventarioListNewDetalleInventario.setCdProducto(producto);
                    detalleInventarioListNewDetalleInventario = em.merge(detalleInventarioListNewDetalleInventario);
                    if (oldCdProductoOfDetalleInventarioListNewDetalleInventario != null && !oldCdProductoOfDetalleInventarioListNewDetalleInventario.equals(producto)) {
                        oldCdProductoOfDetalleInventarioListNewDetalleInventario.getDetalleInventarioList().remove(detalleInventarioListNewDetalleInventario);
                        oldCdProductoOfDetalleInventarioListNewDetalleInventario = em.merge(oldCdProductoOfDetalleInventarioListNewDetalleInventario);
                    }
                }
            }
            for (Inventario inventarioListNewInventario : inventarioListNew) {
                if (!inventarioListOld.contains(inventarioListNewInventario)) {
                    Producto oldIdProductoOfInventarioListNewInventario = inventarioListNewInventario.getIdProducto();
                    inventarioListNewInventario.setIdProducto(producto);
                    inventarioListNewInventario = em.merge(inventarioListNewInventario);
                    if (oldIdProductoOfInventarioListNewInventario != null && !oldIdProductoOfInventarioListNewInventario.equals(producto)) {
                        oldIdProductoOfInventarioListNewInventario.getInventarioList().remove(inventarioListNewInventario);
                        oldIdProductoOfInventarioListNewInventario = em.merge(oldIdProductoOfInventarioListNewInventario);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = producto.getIdProducto();
                if (findProducto(id) == null) {
                    throw new NonexistentEntityException("The producto with id " + id + " no longer exists.");
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
            Producto producto;
            try {
                producto = em.getReference(Producto.class, id);
                producto.getIdProducto();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The producto with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<DetallePedido> detallePedidoListOrphanCheck = producto.getDetallePedidoList();
            for (DetallePedido detallePedidoListOrphanCheckDetallePedido : detallePedidoListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Producto (" + producto + ") cannot be destroyed since the DetallePedido " + detallePedidoListOrphanCheckDetallePedido + " in its detallePedidoList field has a non-nullable codProducto field.");
            }
            List<DetalleInventario> detalleInventarioListOrphanCheck = producto.getDetalleInventarioList();
            for (DetalleInventario detalleInventarioListOrphanCheckDetalleInventario : detalleInventarioListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Producto (" + producto + ") cannot be destroyed since the DetalleInventario " + detalleInventarioListOrphanCheckDetalleInventario + " in its detalleInventarioList field has a non-nullable cdProducto field.");
            }
            List<Inventario> inventarioListOrphanCheck = producto.getInventarioList();
            for (Inventario inventarioListOrphanCheckInventario : inventarioListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Producto (" + producto + ") cannot be destroyed since the Inventario " + inventarioListOrphanCheckInventario + " in its inventarioList field has a non-nullable idProducto field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Categoria idCategoria = producto.getIdCategoria();
            if (idCategoria != null) {
                idCategoria.getProductoList().remove(producto);
                idCategoria = em.merge(idCategoria);
            }
            List<Venta> ventaList = producto.getVentaList();
            for (Venta ventaListVenta : ventaList) {
                ventaListVenta.setCd1Producto(null);
                ventaListVenta = em.merge(ventaListVenta);
            }
            em.remove(producto);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Producto> findProductoEntities() {
        return findProductoEntities(true, -1, -1);
    }

    public List<Producto> findProductoEntities(int maxResults, int firstResult) {
        return findProductoEntities(false, maxResults, firstResult);
    }

    private List<Producto> findProductoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Producto.class));
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

    public Producto findProducto(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Producto.class, id);
        } finally {
            em.close();
        }
    }

    public int getProductoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Producto> rt = cq.from(Producto.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
