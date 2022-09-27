/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.io.Serializable;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "FREELANCER_PROFILE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FreelancerProfile.findAll", query = "SELECT f FROM FreelancerProfile f"),
    @NamedQuery(name = "FreelancerProfile.findByUniqueid", query = "SELECT f FROM FreelancerProfile f WHERE f.uniqueid = :uniqueid"),
    @NamedQuery(name = "FreelancerProfile.findByName", query = "SELECT f FROM FreelancerProfile f WHERE f.name = :name"),
    @NamedQuery(name = "FreelancerProfile.findByCvinfo", query = "SELECT f FROM FreelancerProfile f WHERE f.cvinfo = :cvinfo"),
    @NamedQuery(name = "FreelancerProfile.findByFreelancerid", query = "SELECT f FROM FreelancerProfile f WHERE f.freelancerid = :freelancerid")
})
    
public class FreelancerProfile implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "UNIQUEID")
    private Integer uniqueid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NAME")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10000)
    @Column(name = "CVINFO")
    private String cvinfo;
    @Basic(optional = false)
    @Column(name = "ACCOUNT")
    private double account; 
    
    
    @jakarta.validation.constraints.NotNull
    @JoinColumn(name = "FREELANCERID", referencedColumnName = "FREELANCERID")
    @ManyToOne(optional = false)
    private Freelancer freelancerid;
    
    public FreelancerProfile() {
    }

    public FreelancerProfile(Integer uniqueid) {
        this.uniqueid = uniqueid;
    }

    public FreelancerProfile(String name, String cvinfo, Freelancer freelancerid) {
        this.name = name;
        this.cvinfo = cvinfo;
        this.freelancerid = freelancerid;
    }

    public Integer getUniqueid() {
        return uniqueid;
    }

    public void setUniqueid(Integer uniqueid) {
        this.uniqueid = uniqueid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCvinfo() {
        return cvinfo;
    }

    public void setCvinfo(String cvinfo) {
        this.cvinfo = cvinfo;
    }

    public double getAccount() {
        return account;
    }

    public void setAccount(double account) {
        this.account = account;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (uniqueid != null ? uniqueid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FreelancerProfile)) {
            return false;
        }
        FreelancerProfile other = (FreelancerProfile) object;
        if ((this.uniqueid == null && other.uniqueid != null) || (this.uniqueid != null && !this.uniqueid.equals(other.uniqueid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.FreelancerProfile[ uniqueid=" + uniqueid + " ]";
    }

    public Freelancer getFreelancerid() {
        return freelancerid;
    }

    public int getFreelanceridList() {
        int ID = freelancerid.getFreelancerid();
        return ID;
    }
    
    public void setFreelancerid(Freelancer freelancerid) {
        this.freelancerid = freelancerid;
    }
    
    
    
}
