/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.io.Serializable;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
@Table(name = "JOBDESCRIPTION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Jobdescription.findAll", query = "SELECT j FROM Jobdescription j"),
    @NamedQuery(name = "Jobdescription.findByJobid", query = "SELECT j FROM Jobdescription j WHERE j.jobid = :jobid"),
    @NamedQuery(name = "Jobdescription.findByTitle", query = "SELECT j FROM Jobdescription j WHERE j.title = :title"),
    @NamedQuery(name = "Jobdescription.findByKeyword", query = "SELECT j FROM Jobdescription j WHERE j.keyword = :keyword"),
    @NamedQuery(name = "Jobdescription.findByDescription", query = "SELECT j FROM Jobdescription j WHERE j.description = :description"),
    @NamedQuery(name = "Jobdescription.findByPayment", query = "SELECT j FROM Jobdescription j WHERE j.payment = :payment"),
    @NamedQuery(name = "Jobdescription.findByProvideid", query = "SELECT j FROM Jobdescription j WHERE j.provideid = :provideid"),
    @NamedQuery(name = "Jobdescription.findByOpenstatu", query = "SELECT j FROM Jobdescription j WHERE j.openstatu = :openstatu"),
    @NamedQuery(name = "Jobdescription.findByCompletedstatu", query = "SELECT j FROM Jobdescription j WHERE j.completedstatu = :completedstatu")})
public class Jobdescription implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.TABLE)
    @NotNull
    @Column(name = "JOBID")
    private Integer jobid;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "TITLE")
    private String title;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "KEYWORD")
    private String keyword;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20000)
    @Column(name = "DESCRIPTION")
    private String description;
    @Basic(optional = false)
    @NotNull
    //@Size(min = 1, max = 500)
    @Column(name = "PAYMENT")
    private double payment;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PROVIDEID")
    private int provideid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "OPENSTATU")
    private Boolean openstatu;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COMPLETEDSTATU")
    private Boolean completedstatu;

    @OneToMany(mappedBy = "jobid")
    private Collection<Offer> offerCollection;
    
    public Jobdescription() {
    }

    public Jobdescription(Integer jobid) {
        this.jobid = jobid;
    }

    public Jobdescription(String title, String keyword, String description, double payment, int provideid, Boolean openstatu, Boolean completedstatu) {
        this.title = title;
        this.keyword = keyword;
        this.description = description;
        this.payment = payment;
        this.provideid = provideid;
        this.openstatu = openstatu;
        this.completedstatu = completedstatu;
    }

    public Integer getJobid() {
        return jobid;
    }

    public void setJobid(Integer jobid) {
        this.jobid = jobid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPayment() {
        return payment;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }

    public int getProvideid() {
        return provideid;
    }

    public void setProvideid(int provideid) {
        this.provideid = provideid;
    }

    public Boolean getOpenstatu() {
        return openstatu;
    }

    public void setOpenstatu(Boolean openstatu) {
        this.openstatu = openstatu;
    }

    public Boolean getCompletedstatu() {
        return completedstatu;
    }

    public void setCompletedstatu(Boolean completedstatu) {
        this.completedstatu = completedstatu;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (jobid != null ? jobid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Jobdescription)) {
            return false;
        }
        Jobdescription other = (Jobdescription) object;
        if ((this.jobid == null && other.jobid != null) || (this.jobid != null && !this.jobid.equals(other.jobid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Jobdescription[ jobid=" + jobid + " ]";
    }
    
}
