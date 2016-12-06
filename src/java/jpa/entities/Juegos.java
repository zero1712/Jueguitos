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
@Table(name = "JUEGOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Juegos.findAll", query = "SELECT j FROM Juegos j")
    , @NamedQuery(name = "Juegos.findByClave", query = "SELECT j FROM Juegos j WHERE j.clave = :clave")
    , @NamedQuery(name = "Juegos.findByNombre", query = "SELECT j FROM Juegos j WHERE j.nombre = :nombre")
    , @NamedQuery(name = "Juegos.findByDescripcion", query = "SELECT j FROM Juegos j WHERE j.descripcion = :descripcion")
    , @NamedQuery(name = "Juegos.findByReglas", query = "SELECT j FROM Juegos j WHERE j.reglas = :reglas")})
public class Juegos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CLAVE")
    private Integer clave;
    @Size(max = 30)
    @Column(name = "NOMBRE")
    private String nombre;
    @Size(max = 200)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Size(max = 200)
    @Column(name = "REGLAS")
    private String reglas;
    @OneToMany(mappedBy = "cveJuego")
    private Collection<Records> recordsCollection;
    @OneToMany(mappedBy = "cveJuego")
    private Collection<Torneos> torneosCollection;
    @OneToMany(mappedBy = "cveJuego")
    private Collection<Misiones> misionesCollection;

    public Juegos() {
    }

    public Juegos(Integer clave) {
        this.clave = clave;
    }

    public Integer getClave() {
        return clave;
    }

    public void setClave(Integer clave) {
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getReglas() {
        return reglas;
    }

    public void setReglas(String reglas) {
        this.reglas = reglas;
    }

    @XmlTransient
    public Collection<Records> getRecordsCollection() {
        return recordsCollection;
    }

    public void setRecordsCollection(Collection<Records> recordsCollection) {
        this.recordsCollection = recordsCollection;
    }

    @XmlTransient
    public Collection<Torneos> getTorneosCollection() {
        return torneosCollection;
    }

    public void setTorneosCollection(Collection<Torneos> torneosCollection) {
        this.torneosCollection = torneosCollection;
    }

    @XmlTransient
    public Collection<Misiones> getMisionesCollection() {
        return misionesCollection;
    }

    public void setMisionesCollection(Collection<Misiones> misionesCollection) {
        this.misionesCollection = misionesCollection;
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
        if (!(object instanceof Juegos)) {
            return false;
        }
        Juegos other = (Juegos) object;
        if ((this.clave == null && other.clave != null) || (this.clave != null && !this.clave.equals(other.clave))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return clave + ","+ nombre ;
    }
    
}
