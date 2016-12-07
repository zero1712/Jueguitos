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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Cyntia Yomally Osorno López
 * @author Cesar Gibran Cadena Espinoza
 * @author Hever Luis Alvarez Carmona
 * @author Albaro Tonatihu Fabian Silverio
 * @author Jhonatan Saúl Ramírez Bravo
 * @version 06/12/2016
 * 
 */
@Entity
@Table(name = "NOTICIAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Noticias.findAll", query = "SELECT n FROM Noticias n")
    , @NamedQuery(name = "Noticias.findByClave", query = "SELECT n FROM Noticias n WHERE n.clave = :clave")
    , @NamedQuery(name = "Noticias.findByTitulo", query = "SELECT n FROM Noticias n WHERE n.titulo = :titulo")
    , @NamedQuery(name = "Noticias.findByFecha", query = "SELECT n FROM Noticias n WHERE n.fecha = :fecha")
    , @NamedQuery(name = "Noticias.findByDescripcion", query = "SELECT n FROM Noticias n WHERE n.descripcion = :descripcion")
    , @NamedQuery(name = "Noticias.findByImagen", query = "SELECT n FROM Noticias n WHERE n.imagen = :imagen")})
public class Noticias implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CLAVE")
    private Integer clave;
    @Size(max = 30)
    @Column(name = "TITULO")
    private String titulo;
    @Column(name = "FECHA")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Size(max = 100)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Size(max = 30)
    @Column(name = "IMAGEN")
    private String imagen;

    public Noticias() {
    }

    public Noticias(Integer clave) {
        this.clave = clave;
    }

    public Integer getClave() {
        return clave;
    }

    public void setClave(Integer clave) {
        this.clave = clave;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
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
        if (!(object instanceof Noticias)) {
            return false;
        }
        Noticias other = (Noticias) object;
        if ((this.clave == null && other.clave != null) || (this.clave != null && !this.clave.equals(other.clave))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Noticias[ clave=" + clave + " ]";
    }
    
}
