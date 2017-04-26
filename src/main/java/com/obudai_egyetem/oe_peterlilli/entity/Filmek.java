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
import javax.persistence.Lob;
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
@Table(name = "filmek")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Filmek.findAll", query = "SELECT f FROM Filmek f")
    , @NamedQuery(name = "Filmek.findById", query = "SELECT f FROM Filmek f WHERE f.id = :id")
    , @NamedQuery(name = "Filmek.findByCim", query = "SELECT f FROM Filmek f WHERE f.cim = :cim")
    , @NamedQuery(name = "Filmek.findByMufajId", query = "SELECT f FROM Filmek f WHERE f.mufajId = :mufajId")
    , @NamedQuery(name = "Filmek.findByRendezo", query = "SELECT f FROM Filmek f WHERE f.rendezo = :rendezo")})
public class Filmek implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "cim")
    private String cim;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(name = "leiras")
    private String leiras;
    @Basic(optional = false)
    @NotNull
    @Column(name = "mufaj_id")
    private int mufajId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "rendezo")
    private String rendezo;

    public Filmek() {
    }

    public Filmek(Integer id) {
        this.id = id;
    }

    public Filmek(Integer id, String cim, String leiras, int mufajId, String rendezo) {
        this.id = id;
        this.cim = cim;
        this.leiras = leiras;
        this.mufajId = mufajId;
        this.rendezo = rendezo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCim() {
        return cim;
    }

    public void setCim(String cim) {
        this.cim = cim;
    }

    public String getLeiras() {
        return leiras;
    }

    public void setLeiras(String leiras) {
        this.leiras = leiras;
    }

    public int getMufajId() {
        return mufajId;
    }

    public void setMufajId(int mufajId) {
        this.mufajId = mufajId;
    }

    public String getRendezo() {
        return rendezo;
    }

    public void setRendezo(String rendezo) {
        this.rendezo = rendezo;
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
        if (!(object instanceof Filmek)) {
            return false;
        }
        Filmek other = (Filmek) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.obudai_egyetem.oe_peterlilli.entity.Filmek[ id=" + id + " ]";
    }
    
}
