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
import jakarta.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "OFFER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Offer.findAll", query = "SELECT o FROM Offer o"),
    @NamedQuery(name = "Offer.findByOfferid", query = "SELECT o FROM Offer o WHERE o.offerid = :offerid"),
    @NamedQuery(name = "Offer.findByProviderid", query = "SELECT o FROM Offer o WHERE o.providerid = :providerid"),
    @NamedQuery(name = "Offer.findByFreelancerId", query = "SELECT o FROM Offer o WHERE o.freelancerid = :freelancerid"),
    @NamedQuery(name = "Offer.findByJobId", query = "SELECT o FROM Offer o WHERE o.jobid = :jobid"),
    @NamedQuery(name = "Offer.findByJobIdAndFreelancerId", query = "SELECT o FROM Offer o WHERE o.jobid = :jobid AND o.freelancerid = :freelancerid")
})
public class Offer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "OFFERID")
    private Integer offerid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ACCEPTSTATU")
    private Boolean acceptstatu;
   
    
    
    @NotNull
    @JoinColumn(name = "PROVIDERID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Provider providerid;
    @NotNull
    @JoinColumn(name = "FREELANCERID", referencedColumnName = "FREELANCERID")
    @ManyToOne(optional = false)
    private Freelancer freelancerid;
    @NotNull
    @JoinColumn(name = "JOBID", referencedColumnName = "JOBID")
    @ManyToOne(optional = false)
    private Jobdescription jobid;    
    
    
    public Offer() {
    }

    public Offer(Integer offerid) {
        this.offerid = offerid;
    }

    public Offer(Jobdescription jobid, Provider providerid, Freelancer freelancerid, Boolean openstatu) {
        this.jobid = jobid;
        this.acceptstatu = openstatu;
        this.freelancerid = freelancerid;
        this.providerid = providerid;
    }

    public Integer getOfferid() {
        return offerid;
    }

    public void setOfferid(Integer offerid) {
        this.offerid = offerid;
    }


    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (offerid != null ? offerid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Offer)) {
            return false;
        }
        Offer other = (Offer) object;
        if ((this.offerid == null && other.offerid != null) || (this.offerid != null && !this.offerid.equals(other.offerid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Offer[ offerid=" + offerid + " ]";
    }

    public Provider getProviderid() {
        return providerid;
    }

    public int getProvideridList() {
        int id = providerid.getId();
        return id;
    }    
    
    public void setProviderid(Provider providerid) {
        this.providerid = providerid;
    }

    public Freelancer getFreelancerid() {
        return freelancerid;
    }

    public int getFreelanceridList() {
        int id = freelancerid.getFreelancerid();
        return id;
    }    
    
    public void setFreelancerid(Freelancer freelancerid) {
        this.freelancerid = freelancerid;
    }

    public Boolean getAcceptstatu() {
        return acceptstatu;
    }
 
    
    public void setAcceptstatu(Boolean acceptstatu) {
        this.acceptstatu = acceptstatu;
    }

    public Jobdescription getJobid() {
        return jobid;
    }

    public int getJobidList() {
        int id = jobid.getJobid();
        return id;
    }
    
    public void setJobid(Jobdescription jobid) {
        this.jobid = jobid;
    }

    
    
    
}
