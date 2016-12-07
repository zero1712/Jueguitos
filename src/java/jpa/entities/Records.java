/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;

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
@Table(name = "RECORDS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Records.findAll", query = "SELECT r FROM Records r")
    , @NamedQuery(name = "Records.findByClave", query = "SELECT r FROM Records r WHERE r.clave = :clave")
    , @NamedQuery(name = "Records.findByRecord", query = "SELECT r FROM Records r WHERE r.record = :record")})
public class Records implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CLAVE")
    private Integer clave;
    @Column(name = "RECORD")
    private Integer record;
    @JoinColumn(name = "CVE_JUEGO", referencedColumnName = "CLAVE")
    @ManyToOne
    private Juegos cveJuego;
    @JoinColumn(name = "CVE_USUARIO", referencedColumnName = "CLAVE")
    @ManyToOne
    private Usuarios cveUsuario;

    public Records() {
    }

    public Records(Integer clave) {
        this.clave = clave;
    }

    public Integer getClave() {
        return clave;
    }

    public void setClave(Integer clave) {
        this.clave = clave;
    }

    public Integer getRecord() {
        return record;
    }

    public void setRecord(Integer record) {
        this.record = record;
    }

    public Juegos getCveJuego() {
        return cveJuego;
    }

    public void setCveJuego(Juegos cveJuego) {
        this.cveJuego = cveJuego;
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
        if (!(object instanceof Records)) {
            return false;
        }
        Records other = (Records) object;
        if ((this.clave == null && other.clave != null) || (this.clave != null && !this.clave.equals(other.clave))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Records[ clave=" + clave + " ]";
    }
    
}
