/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Cyntia Yomally Osorno López
 * @author Cesar Gibran Cadena Espinoza
 * @author Hever Luis Alvarez Carmona
 * @author Albaro Tonatihu Fabian Silverio
 * @author Jhonatan Saúl Ramírez Bravo
 * @version 06/12/2016
 * 
 */
@Entity
@Table(name = "TORNEOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Torneos.findAll", query = "SELECT t FROM Torneos t")
    , @NamedQuery(name = "Torneos.findByClave", query = "SELECT t FROM Torneos t WHERE t.clave = :clave")
    , @NamedQuery(name = "Torneos.findByNombre", query = "SELECT t FROM Torneos t WHERE t.nombre = :nombre")
    , @NamedQuery(name = "Torneos.findByFechaIni", query = "SELECT t FROM Torneos t WHERE t.fechaIni = :fechaIni")
    , @NamedQuery(name = "Torneos.findByFechaFin", query = "SELECT t FROM Torneos t WHERE t.fechaFin = :fechaFin")
    , @NamedQuery(name = "Torneos.findByDescripcion", query = "SELECT t FROM Torneos t WHERE t.descripcion = :descripcion")})
public class Torneos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CLAVE")
    private Integer clave;
    @Size(max = 30)
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "FECHA_INI")
    @Temporal(TemporalType.DATE)
    private Date fechaIni;
    @Column(name = "FECHA_FIN")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    @Size(max = 100)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @JoinColumn(name = "CVE_JUEGO", referencedColumnName = "CLAVE")
    @ManyToOne
    private Juegos cveJuego;
    @OneToMany(mappedBy = "cveTorneo")
    private Collection<Inscripciones> inscripcionesCollection;

    public Torneos() {
    }

    public Torneos(Integer clave) {
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

    public Date getFechaIni() {
        return fechaIni;
    }

    public void setFechaIni(Date fechaIni) {
        this.fechaIni = fechaIni;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Juegos getCveJuego() {
        return cveJuego;
    }

    public void setCveJuego(Juegos cveJuego) {
        this.cveJuego = cveJuego;
    }

    @XmlTransient
    public Collection<Inscripciones> getInscripcionesCollection() {
        return inscripcionesCollection;
    }

    public void setInscripcionesCollection(Collection<Inscripciones> inscripcionesCollection) {
        this.inscripcionesCollection = inscripcionesCollection;
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
        if (!(object instanceof Torneos)) {
            return false;
        }
        Torneos other = (Torneos) object;
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
