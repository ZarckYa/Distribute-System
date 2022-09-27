/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "LOGINFO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Loginfo.findAll", query = "SELECT l FROM Loginfo l"),
    @NamedQuery(name = "Loginfo.findByLogid", query = "SELECT l FROM Loginfo l WHERE l.logid = :logid"),
    @NamedQuery(name = "Loginfo.findByLogentry", query = "SELECT l FROM Loginfo l WHERE l.logentry = :logentry"),
    @NamedQuery(name = "Loginfo.findByDate", query = "SELECT l FROM Loginfo l WHERE l.date = :date")})
public class Loginfo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "LOGID")
    private Integer logid;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "LOGENTRY")
    private String logentry;
    @Column(name = "DATE")
    @Temporal(TemporalType.DATE)
    private Date date;

    public Loginfo() {
    }

    public Loginfo(Integer logid) {
        this.logid = logid;
    }

    public Loginfo(String logentry, Date date) {
        this.logentry = logentry;
        this.date = date;
    }

    public Integer getLogid() {
        return logid;
    }

    public void setLogid(Integer logid) {
        this.logid = logid;
    }

    public String getLogentry() {
        return logentry;
    }

    public void setLogentry(String logentry) {
        this.logentry = logentry;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (logid != null ? logid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Loginfo)) {
            return false;
        }
        Loginfo other = (Loginfo) object;
        if ((this.logid == null && other.logid != null) || (this.logid != null && !this.logid.equals(other.logid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Loginfo[ logid=" + logid + " ]";
    }
    
}
