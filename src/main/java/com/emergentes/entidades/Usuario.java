/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.emergentes.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
<<<<<<< HEAD
 
=======
 * @author 999ma
>>>>>>> 6de98de038e78f12fc33a55da64efc7007d73909
 */
@Entity
@Table(name = "usuario")
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByIdUsuario", query = "SELECT u FROM Usuario u WHERE u.idUsuario = :idUsuario"),
    @NamedQuery(name = "Usuario.findByNombreUsu", query = "SELECT u FROM Usuario u WHERE u.nombreUsu = :nombreUsu"),
<<<<<<< HEAD
    @NamedQuery(name = "Usuario.findByContraseña", query = "SELECT u FROM Usuario u WHERE u.contraseña = :contraseña"),
    @NamedQuery(name = "Usuario.findByCorreo", query = "SELECT u FROM Usuario u WHERE u.correo = :correo"),
    @NamedQuery(name = "Usuario.findByDireccion", query = "SELECT u FROM Usuario u WHERE u.direccion = :direccion"),
    @NamedQuery(name = "Usuario.findByTelefonoUsu", query = "SELECT u FROM Usuario u WHERE u.telefonoUsu = :telefonoUsu"),
    @NamedQuery(name = "Usuario.findByRol", query = "SELECT u FROM Usuario u WHERE u.rol = :rol")})
public class Usuario implements Serializable {

    @Size(max = 10)
    @Column(name = "rol")
    private String rol;

=======
    @NamedQuery(name = "Usuario.findByContrase\u00f1a", query = "SELECT u FROM Usuario u WHERE u.contrase\u00f1a = :contrase\u00f1a"),
    @NamedQuery(name = "Usuario.findByCorreo", query = "SELECT u FROM Usuario u WHERE u.correo = :correo"),
    @NamedQuery(name = "Usuario.findByDireccion", query = "SELECT u FROM Usuario u WHERE u.direccion = :direccion"),
    @NamedQuery(name = "Usuario.findByTelefonoUsu", query = "SELECT u FROM Usuario u WHERE u.telefonoUsu = :telefonoUsu")})
public class Usuario implements Serializable {

>>>>>>> 6de98de038e78f12fc33a55da64efc7007d73909
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_usuario")
    private Integer idUsuario;
    @Size(max = 100)
    @Column(name = "nombre_usu")
    private String nombreUsu;
    @Size(max = 100)
<<<<<<< HEAD
    @Column(name = "contraseña")
=======
    @Column(name = "contrase\u00f1a")
>>>>>>> 6de98de038e78f12fc33a55da64efc7007d73909
    private String contraseña;
    @Size(max = 100)
    @Column(name = "correo")
    private String correo;
    @Size(max = 100)
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "telefono_usu")
    private Integer telefonoUsu;
    @OneToMany(mappedBy = "idUsuario")
    private List<Venta> ventaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codUsuario")
    private List<Pedido> pedidoList;

    public Usuario() {
        this.idUsuario=0;
        this.nombreUsu="";
        this.contraseña="";
        this.correo="";
        this.direccion="";
        this.telefonoUsu=0;
<<<<<<< HEAD
        this.rol="";
=======
>>>>>>> 6de98de038e78f12fc33a55da64efc7007d73909
        ventaList=new ArrayList<Venta>();
        pedidoList= new ArrayList<Pedido>(); 
    }

    public Usuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsu() {
        return nombreUsu;
    }

    public void setNombreUsu(String nombreUsu) {
        this.nombreUsu = nombreUsu;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getTelefonoUsu() {
        return telefonoUsu;
    }

    public void setTelefonoUsu(Integer telefonoUsu) {
        this.telefonoUsu = telefonoUsu;
    }

    public List<Venta> getVentaList() {
        return ventaList;
    }

    public void setVentaList(List<Venta> ventaList) {
        this.ventaList = ventaList;
    }

    public List<Pedido> getPedidoList() {
        return pedidoList;
    }

    public void setPedidoList(List<Pedido> pedidoList) {
        this.pedidoList = pedidoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.emergentes.entidades.Usuario[ idUsuario=" + idUsuario + " ]";
    }
<<<<<<< HEAD

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
=======
>>>>>>> 6de98de038e78f12fc33a55da64efc7007d73909
    
}
