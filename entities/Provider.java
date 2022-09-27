/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.io.Serializable;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.Collection;

/**
 *
 * @author Administrator
 */
@Entity @Table(name = "PROVIDER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Provider.findAll", query = "SELECT p FROM Provider p"),
    @NamedQuery(name = "Provider.findById", query = "SELECT p FROM Provider p WHERE p.id = :id"),
    @NamedQuery(name = "Provider.findByPassword", query = "SELECT p FROM Provider p WHERE p.password = :password"),
    @NamedQuery(name = "Provider.getProvideID", query = "SELECT p.id FROM Provider p"),
    @NamedQuery(name = "Provider.getProvidePassword", query = "SELECT p.password FROM Provider p"),
    @NamedQuery(name = "Provider.getProvidePasswordById", query = "SELECT p FROM Provider p WHERE p.id = :id")
})
    
public class Provider implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    //@Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    //@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "PASSWORD")
    private String password;

    @OneToMany(mappedBy = "providerid")
    private Collection<Offer> offerCollection;
    
    public Provider() {
    }

    public Provider(Integer id) {
        this.id = id;
    }

    public Provider(Integer id, String password) {
        this.id = id;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
        if (!(object instanceof Provider)) {
            return false;
        }
        Provider other = (Provider) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Provider[ id=" + id + " ]";
    }
   
}
