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
import javax.xml.bind.annotation.XmlRootElement;

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
@Table(name = "INSCRIPCIONES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Inscripciones.findAll", query = "SELECT i FROM Inscripciones i")
    , @NamedQuery(name = "Inscripciones.findByClave", query = "SELECT i FROM Inscripciones i WHERE i.clave = :clave")
    , @NamedQuery(name = "Inscripciones.findByFecha", query = "SELECT i FROM Inscripciones i WHERE i.fecha = :fecha")})
public class Inscripciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CLAVE")
    private Integer clave;
    @Column(name = "FECHA")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @JoinColumn(name = "CVE_TORNEO", referencedColumnName = "CLAVE")
    @ManyToOne
    private Torneos cveTorneo;
    @JoinColumn(name = "CVE_USUARIO", referencedColumnName = "CLAVE")
    @ManyToOne
    private Usuarios cveUsuario;

    public Inscripciones() {
    }

    public Inscripciones(Integer clave) {
        this.clave = clave;
    }

    public Integer getClave() {
        return clave;
    }

    public void setClave(Integer clave) {
        this.clave = clave;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Torneos getCveTorneo() {
        return cveTorneo;
    }

    public void setCveTorneo(Torneos cveTorneo) {
        this.cveTorneo = cveTorneo;
    }

    public Usuarios getCveUsuario() {
        return cveUsuario;
    }

    public void setCveUsuario(Usuarios cveUsuario) {
        this.cveUsuario = cveUsuario;
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
        if (!(object instanceof Inscripciones)) {
            return false;
        }
        Inscripciones other = (Inscripciones) object;
        if ((this.clave == null && other.clave != null) || (this.clave != null && !this.clave.equals(other.clave))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Inscripciones[ clave=" + clave + " ]";
    }
    
}
