/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package myManageBeans;

import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import jakarta.ejb.EJB;
import java.util.List;

import myEJB.AdminProcess;
import myEJB.FrelancerProcess;
import myEJB.ProviderProcess;
import myEJB.JobProcess;
import myEJB.OfferProcess;

import entities.Admin;
import entities.Freelancer;
import entities.Provider;
import entities.Jobdescription;
/**
 *
 * @author Administrator
 */
@Named(value = "adminBean")
@SessionScoped
public class AdminBean implements Serializable {

    /**
     * Creates a new instance of AdminBean
     */
    @EJB
    AdminProcess ap;
    @EJB
    FrelancerProcess fp;
    @EJB
    ProviderProcess pps;
    @EJB
    JobProcess jps;
    @EJB
    OfferProcess ops;
    
    private int ID;
    private String password;
    private List<Admin> admin;
    private String returnvalue;
    
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Admin> getAdmin() {
        return admin;
    }

    public void setAdmin(List<Admin> admin) {
        this.admin = admin;
    }

    public String getReturnvalue() {
        return returnvalue;
    }

    
    public void createAdmin() {
        ap.createAdmin(ID, password);
    }
    
    public List<Admin> findByID() {
        this.admin = ap.findByID(ID);
        
        if (admin != null) {
            this.returnvalue = "Sucessful";
        }
        return admin;
    }
    
    public List<Admin> findALL() {
        this.admin = ap.findAll();
        
        if (admin != null) {
            this.returnvalue = "Sucessful";
        }
        return admin;
    }
    
    
    public void removeFreelancer(int ID) {
        fp.removeProfile(ID);
        Freelancer freelancer = fp.findPasswordById(ID);
        ops.removeManyoffersByFreelancer(freelancer);
        fp.removeFreelancer(ID);
    }
    
    public void removeProvider(int ID) {
        Jobdescription job = jps.findAJobByProviderId(ID);
        if (job != null) {
            int jobID = job.getJobid();
            removeJob(jobID);
        }       
        Provider provider = pps.findPasswordById(ID);
        ops.removeManyoffersByProvider(provider);
        pps.removeProvider(ID);

    }
    
    public void removeJob(int ID) {
        Jobdescription job = jps.findByJobID(ID);
        if (job != null) {
            ops.removeManyoffersByJob(job);
        }
        jps.removeJob(ID);
    }
    
    public AdminBean() {
    }
    
}
