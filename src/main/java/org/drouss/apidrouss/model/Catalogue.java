/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.drouss.apidrouss.model;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author MANE
 */
@Entity
@Table(name = "catalogue")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Catalogue.findAll", query = "SELECT c FROM Catalogue c"),
    @NamedQuery(name = "Catalogue.findById", query = "SELECT c FROM Catalogue c WHERE c.id = :id"),
    @NamedQuery(name = "Catalogue.findByTitre", query = "SELECT c FROM Catalogue c WHERE c.titre = :titre"),
    @NamedQuery(name = "Catalogue.findBySoustitre", query = "SELECT c FROM Catalogue c WHERE c.soustitre = :soustitre"),
    @NamedQuery(name = "Catalogue.findByType", query = "SELECT c FROM Catalogue c WHERE c.type = :type"),
    @NamedQuery(name = "Catalogue.findByEdition", query = "SELECT c FROM Catalogue c WHERE c.edition = :edition"),
    @NamedQuery(name = "Catalogue.findByDatepub", query = "SELECT c FROM Catalogue c WHERE c.datepub = :datepub"),
    @NamedQuery(name = "Catalogue.findByAutres", query = "SELECT c FROM Catalogue c WHERE c.autres = :autres"),
    @NamedQuery(name = "Catalogue.findByLangue", query = "SELECT c FROM Catalogue c WHERE c.langue = :langue")})
public class Catalogue implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "titre")
    private String titre;
    @Size(max = 255)
    @Column(name = "soustitre")
    private String soustitre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "type")
    private String type;
    @Size(max = 255)
    @Column(name = "edition")
    private String edition;
    @Size(max = 255)
    @Column(name = "datepub")
    private String datepub;
    @Size(max = 255)
    @Column(name = "autres")
    private String autres;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "langue")
    private String langue;
    @JoinColumn(name = "auteur_id", referencedColumnName = "id")
    @ManyToOne
    private Auteurcatalogue auteurId;

    public Catalogue() {
    }

    public Catalogue(Integer id) {
        this.id = id;
    }

    public Catalogue(Integer id, String titre, String type, String langue) {
        this.id = id;
        this.titre = titre;
        this.type = type;
        this.langue = langue;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getSoustitre() {
        return soustitre;
    }

    public void setSoustitre(String soustitre) {
        this.soustitre = soustitre;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public String getDatepub() {
        return datepub;
    }

    public void setDatepub(String datepub) {
        this.datepub = datepub;
    }

    public String getAutres() {
        return autres;
    }

    public void setAutres(String autres) {
        this.autres = autres;
    }

    public String getLangue() {
        return langue;
    }

    public void setLangue(String langue) {
        this.langue = langue;
    }

    public Auteurcatalogue getAuteurId() {
        return auteurId;
    }

    public void setAuteurId(Auteurcatalogue auteurId) {
        this.auteurId = auteurId;
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
        if (!(object instanceof Catalogue)) {
            return false;
        }
        Catalogue other = (Catalogue) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Catalogue[ id=" + id + " ]";
    }
    
}
