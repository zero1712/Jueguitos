/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author CYNTIA OSORNO
 */
@Entity
@Table(name = "TIPOS_USUARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TiposUsuario.findAll", query = "SELECT t FROM TiposUsuario t")
    , @NamedQuery(name = "TiposUsuario.findByClave", query = "SELECT t FROM TiposUsuario t WHERE t.clave = :clave")
    , @NamedQuery(name = "TiposUsuario.findByTipo", query = "SELECT t FROM TiposUsuario t WHERE t.tipo = :tipo")})
public class TiposUsuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CLAVE")
    private Integer clave;
    @Size(max = 30)
    @Column(name = "TIPO")
    private String tipo;
    @OneToMany(mappedBy = "tipo")
    private Collection<Usuarios> usuariosCollection;

    public TiposUsuario() {
    }

    public TiposUsuario(Integer clave) {
        this.clave = clave;
    }

    public Integer getClave() {
        return clave;
    }

    public void setClave(Integer clave) {
        this.clave = clave;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @XmlTransient
    public Collection<Usuarios> getUsuariosCollection() {
        return usuariosCollection;
    }

    public void setUsuariosCollection(Collection<Usuarios> usuariosCollection) {
        this.usuariosCollection = usuariosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clave != null ? clave.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TiposUsuario)) {
            return false;
        }
        TiposUsuario other = (TiposUsuario) object;
        if ((this.clave == null && other.clave != null) || (this.clave != null && !this.clave.equals(other.clave))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.TiposUsuario[ clave=" + clave + " ]";
    }
    
}
