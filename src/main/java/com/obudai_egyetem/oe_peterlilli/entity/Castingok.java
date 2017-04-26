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
@Table(name = "castingok")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Castingok.findAll", query = "SELECT c FROM Castingok c")
    , @NamedQuery(name = "Castingok.findById", query = "SELECT c FROM Castingok c WHERE c.id = :id")
    , @NamedQuery(name = "Castingok.findByDatumStart", query = "SELECT c FROM Castingok c WHERE c.datumStart = :datumStart")
    , @NamedQuery(name = "Castingok.findByDatumVeg", query = "SELECT c FROM Castingok c WHERE c.datumVeg = :datumVeg")
    , @NamedQuery(name = "Castingok.findByFerohely", query = "SELECT c FROM Castingok c WHERE c.ferohely = :ferohely")
    , @NamedQuery(name = "Castingok.findByFilmId", query = "SELECT c FROM Castingok c WHERE c.filmId = :filmId")
    , @NamedQuery(name = "Castingok.findByHelyszin", query = "SELECT c FROM Castingok c WHERE c.helyszin = :helyszin")
    , @NamedQuery(name = "Castingok.findByIdopontStart", query = "SELECT c FROM Castingok c WHERE c.idopontStart = :idopontStart")
    , @NamedQuery(name = "Castingok.findByIdopontVeg", query = "SELECT c FROM Castingok c WHERE c.idopontVeg = :idopontVeg")
    , @NamedQuery(name = "Castingok.findByNev", query = "SELECT c FROM Castingok c WHERE c.nev = :nev")})
public class Castingok implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "datum_start")
    private String datumStart;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "datum_veg")
    private String datumVeg;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ferohely")
    private int ferohely;
    @Basic(optional = false)
    @NotNull
    @Column(name = "film_id")
    private int filmId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "helyszin")
    private String helyszin;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "idopont_start")
    private String idopontStart;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "idopont_veg")
    private String idopontVeg;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(name = "leiras")
    private String leiras;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nev")
    private String nev;

    public Castingok() {
    }

    public Castingok(Integer id) {
        this.id = id;
    }

    public Castingok(Integer id, String datumStart, String datumVeg, int ferohely, int filmId, String helyszin, String idopontStart, String idopontVeg, String leiras, String nev) {
        this.id = id;
        this.datumStart = datumStart;
        this.datumVeg = datumVeg;
        this.ferohely = ferohely;
        this.filmId = filmId;
        this.helyszin = helyszin;
        this.idopontStart = idopontStart;
        this.idopontVeg = idopontVeg;
        this.leiras = leiras;
        this.nev = nev;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDatumStart() {
        return datumStart;
    }

    public void setDatumStart(String datumStart) {
        this.datumStart = datumStart;
    }

    public String getDatumVeg() {
        return datumVeg;
    }

    public void setDatumVeg(String datumVeg) {
        this.datumVeg = datumVeg;
    }

    public int getFerohely() {
        return ferohely;
    }

    public void setFerohely(int ferohely) {
        this.ferohely = ferohely;
    }

    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public String getHelyszin() {
        return helyszin;
    }

    public void setHelyszin(String helyszin) {
        this.helyszin = helyszin;
    }

    public String getIdopontStart() {
        return idopontStart;
    }

    public void setIdopontStart(String idopontStart) {
        this.idopontStart = idopontStart;
    }

    public String getIdopontVeg() {
        return idopontVeg;
    }

    public void setIdopontVeg(String idopontVeg) {
        this.idopontVeg = idopontVeg;
    }

    public String getLeiras() {
        return leiras;
    }

    public void setLeiras(String leiras) {
        this.leiras = leiras;
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
        if (!(object instanceof Castingok)) {
            return false;
        }
        Castingok other = (Castingok) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.obudai_egyetem.oe_peterlilli.entity.Castingok[ id=" + id + " ]";
    }
    
}
