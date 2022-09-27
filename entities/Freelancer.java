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
@Entity
@Table(name = "FREELANCER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Freelancer.findAll", query = "SELECT f FROM Freelancer f"),
    @NamedQuery(name = "Freelancer.findByFreelancerid", query = "SELECT f FROM Freelancer f WHERE f.freelancerid = :freelancerid"),
    @NamedQuery(name = "Freelancer.findByPassword", query = "SELECT f FROM Freelancer f WHERE f.password = :password"),
    @NamedQuery(name = "Freelancer.getFreelancerID", query = "SELECT f.freelancerid FROM Freelancer f"),
    @NamedQuery(name = "Freelancer.getFreelancerPassword", query = "SELECT f.password FROM Freelancer f"),
    @NamedQuery(name = "Freelancer.getFreelancerPasswordById", query = "SELECT f FROM Freelancer f WHERE f.freelancerid = :freelancerid")

})
public class Freelancer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "FREELANCERID")
    private Integer freelancerid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "PASSWORD")
    private String password;

    @OneToMany(mappedBy = "freelancerid")
    private Collection<Offer> offerCollection;
  
    @OneToMany(mappedBy = "freelancerid")
    private Collection<FreelancerProfile> freelancerProfileCollection;
    
    public Freelancer() {
    }

    public Freelancer(Integer freelancerid) {
        this.freelancerid = freelancerid;
    }

    public Freelancer(Integer freelancerid, String password) {
        this.freelancerid = freelancerid;
        this.password = password;
    }

    public Integer getFreelancerid() {
        return freelancerid;
    }

    public void setFreelancerid(Integer freelancerid) {
        this.freelancerid = freelancerid;
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
        hash += (freelancerid != null ? freelancerid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Freelancer)) {
            return false;
        }
        Freelancer other = (Freelancer) object;
        if ((this.freelancerid == null && other.freelancerid != null) || (this.freelancerid != null && !this.freelancerid.equals(other.freelancerid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Freelancer[ freelancerid=" + freelancerid + " ]";
    }
    
}
