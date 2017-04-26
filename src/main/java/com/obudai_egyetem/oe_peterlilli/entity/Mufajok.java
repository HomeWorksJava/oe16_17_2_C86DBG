/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.obudai_egyetem.oe_peterlilli.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author hallgato
 */
@Entity
@Table(name = "mufajok")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mufajok.findAll", query = "SELECT m FROM Mufajok m")
    , @NamedQuery(name = "Mufajok.findById", query = "SELECT m FROM Mufajok m WHERE m.id = :id")
    , @NamedQuery(name = "Mufajok.findByNev", query = "SELECT m FROM Mufajok m WHERE m.nev = :nev")})
public class Mufajok implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nev")
    private String nev;

    public Mufajok() {
    }

    public Mufajok(Integer id) {
        this.id = id;
    }

    public Mufajok(Integer id, String nev) {
        this.id = id;
        this.nev = nev;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mufajok)) {
            return false;
        }
        Mufajok other = (Mufajok) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.obudai_egyetem.oe_peterlilli.entity.Mufajok[ id=" + id + " ]";
    }
    
}
