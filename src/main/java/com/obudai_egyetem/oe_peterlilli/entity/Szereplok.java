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
@Table(name = "szereplok")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Szereplok.findAll", query = "SELECT s FROM Szereplok s")
    , @NamedQuery(name = "Szereplok.findById", query = "SELECT s FROM Szereplok s WHERE s.id = :id")
    , @NamedQuery(name = "Szereplok.findByEletkor", query = "SELECT s FROM Szereplok s WHERE s.eletkor = :eletkor")
    , @NamedQuery(name = "Szereplok.findByFilmId", query = "SELECT s FROM Szereplok s WHERE s.filmId = :filmId")
    , @NamedQuery(name = "Szereplok.findByJellem", query = "SELECT s FROM Szereplok s WHERE s.jellem = :jellem")
    , @NamedQuery(name = "Szereplok.findByNem", query = "SELECT s FROM Szereplok s WHERE s.nem = :nem")
    , @NamedQuery(name = "Szereplok.findByNev", query = "SELECT s FROM Szereplok s WHERE s.nev = :nev")})
public class Szereplok implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "eletkor")
    private int eletkor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "film_id")
    private int filmId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "jellem")
    private String jellem;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(name = "leiras")
    private String leiras;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nem")
    private String nem;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nev")
    private String nev;

    public Szereplok() {
    }

    public Szereplok(Integer id) {
        this.id = id;
    }

    public Szereplok(Integer id, int eletkor, int filmId, String jellem, String leiras, String nem, String nev) {
        this.id = id;
        this.eletkor = eletkor;
        this.filmId = filmId;
        this.jellem = jellem;
        this.leiras = leiras;
        this.nem = nem;
        this.nev = nev;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getEletkor() {
        return eletkor;
    }

    public void setEletkor(int eletkor) {
        this.eletkor = eletkor;
    }

    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public String getJellem() {
        return jellem;
    }

    public void setJellem(String jellem) {
        this.jellem = jellem;
    }

    public String getLeiras() {
        return leiras;
    }

    public void setLeiras(String leiras) {
        this.leiras = leiras;
    }

    public String getNem() {
        return nem;
    }

    public void setNem(String nem) {
        this.nem = nem;
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
        if (!(object instanceof Szereplok)) {
            return false;
        }
        Szereplok other = (Szereplok) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.obudai_egyetem.oe_peterlilli.entity.Szereplok[ id=" + id + " ]";
    }
    
}
