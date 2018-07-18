/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.drouss.apidrouss.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author MANE
 */
@Entity
@Table(name = "book")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Book.findAll", query = "SELECT b FROM Book b"),
    @NamedQuery(name = "Book.findById", query = "SELECT b FROM Book b WHERE b.id = :id"),
    @NamedQuery(name = "Book.findByTitle", query = "SELECT b FROM Book b WHERE b.title = :title"),
    @NamedQuery(name = "Book.findByOnline", query = "SELECT b FROM Book b WHERE b.online = :online"),
    @NamedQuery(name = "Book.findBySubTitle", query = "SELECT b FROM Book b WHERE b.subTitle = :subTitle"),
    @NamedQuery(name = "Book.findByBlanketPath", query = "SELECT b FROM Book b WHERE b.blanketPath = :blanketPath"),
    @NamedQuery(name = "Book.findByStatus", query = "SELECT b FROM Book b WHERE b.status = :status"),
    @NamedQuery(name = "Book.findByForward", query = "SELECT b FROM Book b WHERE b.forward = :forward")})
public class Book implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "title")
    private String title;

    @Size(max = 255)
    @Column(name = "online")
    private String online;

    @Size(max = 255)
    @Column(name = "subTitle")
    private String subTitle;

    @Lob
    @Size(max = 2147483647)
    @Column(name = "extract")
    private String extract;

    @Size(max = 255)
    @Column(name = "blanketPath")
    private String blanketPath;

    @Column(name = "status")
    private Boolean status;

    @Column(name = "forward")
    private Boolean forward;

    @ManyToMany(mappedBy = "bookCollection")
    private Collection<Science> scienceCollection;
    @ManyToMany(mappedBy = "bookCollection")
    private Collection<Language> languageCollection;
    @ManyToMany(mappedBy = "bookCollection")
    private Collection<Format> formatCollection;
    @ManyToMany(mappedBy = "bookCollection")
    private Collection<Month> monthCollection;
    @JoinColumn(name = "categoryId2", referencedColumnName = "id")
    @ManyToOne
    private Category categoryId2;
    @JoinColumn(name = "subCategoryId", referencedColumnName = "id")
    @ManyToOne
    private Subcategory subCategoryId;
    @JoinColumn(name = "authorId", referencedColumnName = "id")
    @ManyToOne
    private Author authorId;

    public Book() {
    }

    public Book(Integer id) {
        this.id = id;
    }

    public Book(Integer id, String title) {
        this.id = id;
        this.title = title;
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

    public String getOnline() {
        return online;
    }

    public void setOnline(String online) {
        this.online = online;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getExtract() {
        return extract;
    }

    public void setExtract(String extract) {
        this.extract = extract;
    }

    public String getBlanketPath() {
        return blanketPath;
    }

    public void setBlanketPath(String blanketPath) {
        this.blanketPath = blanketPath;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Boolean getForward() {
        return forward;
    }

    public void setForward(Boolean forward) {
        this.forward = forward;
    }

    @XmlTransient
    public Collection<Science> getScienceCollection() {
        return scienceCollection;
    }

    public void setScienceCollection(Collection<Science> scienceCollection) {
        this.scienceCollection = scienceCollection;
    }

    @XmlTransient
    public Collection<Language> getLanguageCollection() {
        return languageCollection;
    }

    public void setLanguageCollection(Collection<Language> languageCollection) {
        this.languageCollection = languageCollection;
    }

    @XmlTransient
    public Collection<Format> getFormatCollection() {
        return formatCollection;
    }

    public void setFormatCollection(Collection<Format> formatCollection) {
        this.formatCollection = formatCollection;
    }

    @XmlTransient
    public Collection<Month> getMonthCollection() {
        return monthCollection;
    }

    public void setMonthCollection(Collection<Month> monthCollection) {
        this.monthCollection = monthCollection;
    }

    public Category getCategoryId2() {
        return categoryId2;
    }

    public void setCategoryId2(Category categoryId2) {
        this.categoryId2 = categoryId2;
    }

    public Subcategory getSubCategoryId() {
        return subCategoryId;
    }

    public void setSubCategoryId(Subcategory subCategoryId) {
        this.subCategoryId = subCategoryId;
    }

    public Author getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Author authorId) {
        this.authorId = authorId;
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
        if (!(object instanceof Book)) {
            return false;
        }
        Book other = (Book) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Book{ id=" + id + " }";
    }
    
}
