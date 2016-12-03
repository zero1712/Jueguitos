/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author CYNTIA OSORNO
 */
@Entity
@Table(name = "MISIONES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Misiones.findAll", query = "SELECT m FROM Misiones m")
    , @NamedQuery(name = "Misiones.findByClave", query = "SELECT m FROM Misiones m WHERE m.clave = :clave")
    , @NamedQuery(name = "Misiones.findByNombre", query = "SELECT m FROM Misiones m WHERE m.nombre = :nombre")
    , @NamedQuery(name = "Misiones.findByFechaIni", query = "SELECT m FROM Misiones m WHERE m.fechaIni = :fechaIni")
    , @NamedQuery(name = "Misiones.findByFechaFin", query = "SELECT m FROM Misiones m WHERE m.fechaFin = :fechaFin")
    , @NamedQuery(name = "Misiones.findByObjetivo", query = "SELECT m FROM Misiones m WHERE m.objetivo = :objetivo")})
public class Misiones implements Serializable {

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
    @Column(name = "OBJETIVO")
    private Integer objetivo;
    @JoinColumn(name = "CVE_JUEGO", referencedColumnName = "CLAVE")
    @ManyToOne
    private Juegos cveJuego;

    public Misiones() {
    }

    public Misiones(Integer clave) {
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

    public Integer getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(Integer objetivo) {
        this.objetivo = objetivo;
    }

    public Juegos getCveJuego() {
        return cveJuego;
    }

    public void setCveJuego(Juegos cveJuego) {
        this.cveJuego = cveJuego;
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
        if (!(object instanceof Misiones)) {
            return false;
        }
        Misiones other = (Misiones) object;
        if ((this.clave == null && other.clave != null) || (this.clave != null && !this.clave.equals(other.clave))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Misiones[ clave=" + clave + " ]";
    }
    
}
