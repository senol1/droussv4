/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.drouss.apidrouss.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author MANE
 */
@Entity
@Table(name = "publication")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Publication.findAll", query = "SELECT p FROM Publication p"),
    @NamedQuery(name = "Publication.findById", query = "SELECT p FROM Publication p WHERE p.id = :id"),
    @NamedQuery(name = "Publication.findByTitle", query = "SELECT p FROM Publication p WHERE p.title = :title"),
    @NamedQuery(name = "Publication.findBySubTitle", query = "SELECT p FROM Publication p WHERE p.subTitle = :subTitle"),
    @NamedQuery(name = "Publication.findByBlanketPath", query = "SELECT p FROM Publication p WHERE p.blanketPath = :blanketPath"),
    @NamedQuery(name = "Publication.findByEdition", query = "SELECT p FROM Publication p WHERE p.edition = :edition"),
    @NamedQuery(name = "Publication.findByAuthor", query = "SELECT p FROM Publication p WHERE p.author = :author"),
    @NamedQuery(name = "Publication.findByStatus", query = "SELECT p FROM Publication p WHERE p.status = :status"),
    @NamedQuery(name = "Publication.findByOnline", query = "SELECT p FROM Publication p WHERE p.online = :online")})
public class Publication implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "title")
    private String title;
    @Size(max = 255)
    @Column(name = "subTitle")
    private String subTitle;
    @Size(max = 255)
    @Column(name = "blanketPath")
    private String blanketPath;
    @Size(max = 255)
    @Column(name = "edition")
    private String edition;
    @Size(max = 255)
    @Column(name = "author")
    private String author;
    @Column(name = "status")
    private Boolean status;
    @Size(max = 255)
    @Column(name = "online")
    private String online;
    @JoinTable(name = "format_to_publication", joinColumns = {
        @JoinColumn(name = "publicationId", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "formatId", referencedColumnName = "id")})
    @ManyToMany
    private Collection<Format> formatCollection;
    @JoinTable(name = "language_to_publication", joinColumns = {
        @JoinColumn(name = "publicationId", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "languageId", referencedColumnName = "id")})
    @ManyToMany
    private Collection<Language> languageCollection;

    public Publication() {
    }

    public Publication(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getBlanketPath() {
        return blanketPath;
    }

    public void setBlanketPath(String blanketPath) {
        this.blanketPath = blanketPath;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getOnline() {
        return online;
    }

    public void setOnline(String online) {
        this.online = online;
    }

    @XmlTransient
    public Collection<Format> getFormatCollection() {
        return formatCollection;
    }

    public void setFormatCollection(Collection<Format> formatCollection) {
        this.formatCollection = formatCollection;
    }

    @XmlTransient
    public Collection<Language> getLanguageCollection() {
        return languageCollection;
    }

    public void setLanguageCollection(Collection<Language> languageCollection) {
        this.languageCollection = languageCollection;
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
        if (!(object instanceof Publication)) {
            return false;
        }
        Publication other = (Publication) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Publication[ id=" + id + " ]";
    }
    
}
