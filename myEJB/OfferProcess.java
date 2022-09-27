/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package myEJB;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;


import entities.Offer;
import entities.Provider;
import entities.Freelancer;
import entities.Jobdescription;
import jakarta.persistence.TypedQuery;
import java.util.List;
/**
 *
 * @author Administrator
 */
@Stateless
public class OfferProcess {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @PersistenceContext(unitName = "GroupProjectPU")
    private EntityManager em;
    private Offer offer;
    
    public void persist(Object object) {
        em.persist(object);
    }
    
    /*
    * create a offer.
    */
    public void createOffer(Jobdescription jobId, Provider providerId,Freelancer freelancerId, boolean offerstatu) {
        Offer offer = new Offer(jobId, providerId, freelancerId, offerstatu);
        persist(offer);
    }
    
    /*
    * revoke a application
    */
    public void removeOffer(Jobdescription jobID, Freelancer freelancerid) {
        
        TypedQuery<Offer> query = em.createNamedQuery("Offer.findByJobIdAndFreelancerId", Offer.class);
        query.setParameter("jobid", jobID);
        query.setParameter("freelancerid", freelancerid);
        Offer offers = null;
        offers = query.getSingleResult();
        em.remove(offers);
    }    
    
    /*
    * Remove offers by Job ID
    */
    public void removeManyoffersByJob(Jobdescription jobID) {
        List<Offer> offers = findByJobID(jobID);
        if (offers != null) {
        for (int i = 0; i < offers.size(); i++){
            em.remove(offers.get(i));
        }
        }
    }    

    /*
    * Remove offers by freelancer id
    */
    public void removeManyoffersByFreelancer(Freelancer freelancerid) {
        List<Offer> offers = findByFreelancerID(freelancerid);
        if (offers != null) {
        for (int i = 0; i < offers.size(); i++){
            em.remove(offers.get(i));
        }
        }
    } 
    
    /*
    * Remove offers by provider id.
    */
    public void removeManyoffersByProvider(Provider providerid) {
        List<Offer> offers = findByProviderID(providerid);
        if (offers != null) {
        for (int i = 0; i < offers.size(); i++){
            em.remove(offers.get(i));
        }
        }
    } 
    
    public List<Offer> findByJobID(Jobdescription ID) {
        
        TypedQuery<Offer> query = em.createNamedQuery("Offer.findByJobId", Offer.class);
            query.setParameter("jobid", ID);
            List<Offer> offers = null;
            try {
                    offers = query.getResultList();
            } catch (Exception e) {
                    // getSingleResult throws NoResultException in case there is no user in DB
                    // ignore exception and return NULL for user instead
            }
            return offers;       
    }
    
    
    public List<Offer> findByFreelancerID(Freelancer ID) {
        
        TypedQuery<Offer> query = em.createNamedQuery("Offer.findByFreelancerId", Offer.class);
            query.setParameter("freelancerid", ID);
            List<Offer> offers = null;
            try {
                    offers = query.getResultList();
            } catch (Exception e) {
                    // getSingleResult throws NoResultException in case there is no user in DB
                    // ignore exception and return NULL for user instead
            }
            return offers;       
    }
    
    public Offer findAFreelancerByID(Freelancer ID) {
        
        TypedQuery<Offer> query = em.createNamedQuery("Offer.findByFreelancerId", Offer.class);
            query.setParameter("freelancerid", ID);
            Offer offers = null;
            try {
                    offers = query.getSingleResult();
            } catch (Exception e) {
                    // getSingleResult throws NoResultException in case there is no user in DB
                    // ignore exception and return NULL for user instead
            }
            return offers;       
    }
    
    /*
    * Use to find offer by provider ID
    */
    public List<Offer> findByProviderID(Provider ID) {
        TypedQuery<Offer> query = em.createNamedQuery("Offer.findByProviderid", Offer.class);
            query.setParameter("providerid", ID);
            List<Offer> offers = null;
            try {
                    offers = query.getResultList();
            } catch (Exception e) {
                    // getSingleResult throws NoResultException in case there is no user in DB
                    // ignore exception and return NULL for user instead
            }
            return offers; 
    }
    
    /*
    * Use to accept a application.
    */
    public void MarkAsAccepted(Jobdescription job, Freelancer freelancerid) {
       /* TypedQuery<Jobdescription> queryjob = em.createNamedQuery("Jobdescription.findByJobid", Jobdescription.class);
            queryjob.setParameter("jobid", ID);
            Jobdescription job = null;
            job = queryjob.getSingleResult();*/
        TypedQuery<Offer> query = em.createNamedQuery("Offer.findByJobIdAndFreelancerId", Offer.class);
            query.setParameter("jobid", job);
            query.setParameter("freelancerid", freelancerid);
            Offer offers = null;
            offers = query.getSingleResult();
            offers.setAcceptstatu(Boolean.TRUE);
    }
    
}
