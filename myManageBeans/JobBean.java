/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package myManageBeans;

import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import entities.Jobdescription;
import jakarta.ejb.EJB;
import jakarta.inject.Inject;
import java.util.List;
import myEJB.JobProcess;
/**
 *
 * @author Administrator
 */

@Named(value = "jobBean")
@SessionScoped

public class JobBean implements Serializable {
    
    /**
     * Creates a new instance of JobBean
     */
    //@Inject
    @EJB
    private JobProcess jbp;
    
    private int jobID;
    private String title;
    private String keyword;
    private String description;
    private double payment;
    private int provideid;
    private boolean openstatu;
    private boolean completedstatu;
    private boolean completedstatucontrol;
    private boolean returnvalue;
    private String result;
    private boolean showTableAll;
    private boolean showTableOpen;
    private boolean showTableKeywords;
    private boolean showTableID;
    private List<Jobdescription> job;
    private Jobdescription Ajob;
    
    public int getJobID() {
        return jobID;
    }

    public void setJobID(int jobID) {
        this.jobID = jobID;
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

    public boolean isOpenstatu() {
        return openstatu;
    }

    public void setOpenstatu(boolean openstatu) {
        this.openstatu = openstatu;
    }

    public boolean isCompletedstatu() {
        return completedstatu;
    }

    public void setCompletedstatu(boolean completedstatu) {
        this.completedstatu = completedstatu;
    }

    public List<Jobdescription> getJob() {
        return job;
    }

    public void showTableAll() {
        this.showTableAll = true;
    }

    public boolean isShowTableAll() {
        return showTableAll;
    }
   
    public void showTableOpen() {
        this.showTableOpen = true;
    }

    public boolean isShowTableOpen() {
        return showTableOpen;
    }
    
    public void showTableKeywords() {
        this.showTableKeywords = true;
        this.showTableID = false;
    }

    public boolean isShowTableKeywords() {
        return showTableKeywords;
    }
    public void showTableID() {
        this.showTableID = true;
        this.showTableKeywords = false;
    }

    public boolean isShowTableID() {
        return showTableID;
    }    
    
    public void addJob(int provideid) {
        this.openstatu = true;
        this.completedstatu = false;
        this.provideid = 10;
        jbp.createJob(title, keyword, description, payment, provideid, openstatu, completedstatu);
        this.returnvalue = true;
    }
    
    public List<Jobdescription> findByProviderId(int providerId) {

        this.job = jbp.findByProviderId(providerId);
        this.result = "successful";
        return job;
    }    
    
    public void findByJobID(int providerId) {

        this.Ajob = jbp.findByJobID(providerId);
        this.result = "successful";
    } 

    public Jobdescription getAjob() {
        return Ajob;
    }
    

    public List<Jobdescription> findByKeywords() {

        job = jbp.findBykeywords(keyword);
        return job;
    }
    
    public List<Jobdescription> findByIds() {

        this.job = jbp.findById(jobID);
        this.result = "successful";
        return job;
    }
    
    public List<Jobdescription> findByALL() {

        this.job = jbp.findByALL();
        this.result = "successful";
        return job;
    }
    
    public List<Jobdescription> findByOpenstatu() {
        openstatu = true;
        job = jbp.findByOpenstatu(openstatu);
        return job;
    }
    
    public String notification() {
        if (returnvalue == true) {
            this.result = "Successful";
            job = null;
        }
        if (job != null) {
            this.result = "Successful";
            job = null;
        }
        return result;
    }
    
    public void markAsCompleted(int ID) {
        jbp.markAsCompleted(ID);
    }
    
    public void markAsClose(int jobID) {
        jbp.markAsClose(jobID);
    }
    
 
    
   /*
    transaction-type="JTA">
    <provider>org.eclipse.persistence.jpa.PersistenceProvider</provider>
    <jta-data-source>jdbc/__TimerPool</jta-data-source>
    */
    
    public JobBean() {
    }
    
}
