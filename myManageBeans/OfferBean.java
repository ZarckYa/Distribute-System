/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package myManageBeans;

import jakarta.ejb.EJB;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import myEJB.OfferProcess;
import myEJB.FrelancerProcess;
import myEJB.ProviderProcess;
import entities.Offer;
import entities.Freelancer;
import entities.Provider;
import entities.Jobdescription;
import jakarta.persistence.TypedQuery;
import java.util.List;

/**
 *
 * @author Administrator
 */
@Named(value = "offerBean")
@SessionScoped
public class OfferBean implements Serializable {

    /**
     * Creates a new instance of OfferBean
     */
    
    @EJB
    private OfferProcess ops;
    @EJB
    private FrelancerProcess fps;
    @EJB
    private ProviderProcess pps;
    
    private boolean showTableAll;
    private Offer offer;
    
    private int providerID;
    private int freelancerID;
    private int jobID;
    private boolean offerstatu;
    private boolean showTable;
    private Provider ProviderID;
    private Freelancer FreelancerID;
    private List<Offer> offers;
    private String submitsuccessful;
    
    public boolean isShowTableAll() {
        return showTableAll;
    }

    public void showTableAll() {
        this.showTableAll = true;
    }

    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }

    public int getProviderID() {
        return providerID;
    }

    public void setProviderID(int providerID) {
        this.providerID = providerID;
    }

    public int getFreelancerID() {
        return freelancerID;
    }

    public void setFreelancerID(int freelancerID) {
        this.freelancerID = freelancerID;
    }

    public boolean isOfferstatu() {
        return offerstatu;
    }

    public void setOfferstatu(boolean offerstatu) {
        this.offerstatu = offerstatu;
    }

    public int getJobID() {
        return jobID;
    }

    public void setJobID(int jobID) {
        this.jobID = jobID;
    }

    public boolean isShowTable() {
        return showTable;
    }

    public void setShowTable() {
        this.showTable = !showTable;
    }

    public String getSubmitsuccessful() {
        return submitsuccessful;
    }
    
    
    public void  proposeOffer(Jobdescription JobID, Provider ProviderID, Freelancer FreelancerID) {
        offerstatu = false;
        ops.createOffer(JobID, ProviderID, FreelancerID, offerstatu);
        this.submitsuccessful = "Successful";
    }
    
    public void removeOffer(Jobdescription jobID, int freelancerid) {
        Freelancer freelancer = fps.findPasswordById(freelancerid);
        ops.removeOffer(jobID, freelancer);
    }
    
    public List<Offer> findByFreelancerID(int freelancerid) {
        Freelancer freelancer = fps.findPasswordById(freelancerid);
        this.offers = ops.findByFreelancerID(freelancer);
        return offers;
    }
    
    public List<Offer> findByProviderID(int providerid) {
        Provider provider = pps.findPasswordById(providerid);
        this.offers = ops.findByProviderID(provider);
        return offers;
    }
    
    
    public void acceptApplication(Jobdescription job, Freelancer freelancerid) {
        ops.MarkAsAccepted(job, freelancerid);    
    }
    
    public OfferBean() {
    }
    
}
