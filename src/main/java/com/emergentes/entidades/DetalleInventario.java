/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.emergentes.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author 999ma
 */
@Entity
@Table(name = "detalle_inventario")
@NamedQueries({
    @NamedQuery(name = "DetalleInventario.findAll", query = "SELECT d FROM DetalleInventario d"),
    @NamedQuery(name = "DetalleInventario.findByIdDetalle", query = "SELECT d FROM DetalleInventario d WHERE d.idDetalle = :idDetalle"),
    @NamedQuery(name = "DetalleInventario.findByCantidad", query = "SELECT d FROM DetalleInventario d WHERE d.cantidad = :cantidad"),
    @NamedQuery(name = "DetalleInventario.findByFechaDet", query = "SELECT d FROM DetalleInventario d WHERE d.fechaDet = :fechaDet")})
public class DetalleInventario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_detalle")
    private Integer idDetalle;
    @Column(name = "cantidad")
    private Integer cantidad;
    @Column(name = "fecha_det")
    private String fechaDet;
    @JoinColumn(name = "cd_producto", referencedColumnName = "id_producto")
    @ManyToOne(optional = false)
    private Producto cdProducto;
    @JoinColumn(name = "id_inventario", referencedColumnName = "id_inventario")
    @ManyToOne
    private Inventario idInventario;

    public DetalleInventario() {
        this.idDetalle=0;
        this.cantidad=0;
        this.fechaDet="";
        this.cdProducto= new Producto();
        this.idInventario= new Inventario();        
    }

    public DetalleInventario(Integer idDetalle) {
        this.idDetalle = idDetalle;
    }

    public Integer getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(Integer idDetalle) {
        this.idDetalle = idDetalle;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getFechaDet() {
        return fechaDet;
    }

    public void setFechaDet(String fechaDet) {
        this.fechaDet = fechaDet;
    }

    public Producto getCdProducto() {
        return cdProducto;
    }

    public void setCdProducto(Producto cdProducto) {
        this.cdProducto = cdProducto;
    }

    public Inventario getIdInventario() {
        return idInventario;
    }

    public void setIdInventario(Inventario idInventario) {
        this.idInventario = idInventario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetalle != null ? idDetalle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleInventario)) {
            return false;
        }
        DetalleInventario other = (DetalleInventario) object;
        if ((this.idDetalle == null && other.idDetalle != null) || (this.idDetalle != null && !this.idDetalle.equals(other.idDetalle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DetalleInventario{" + "idDetalle=" + idDetalle + ", cantidad=" + cantidad + ", fechaDet=" + fechaDet + ", cdProducto=" + cdProducto + ", idInventario=" + idInventario + '}';
    }

    
}
