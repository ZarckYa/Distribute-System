/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package myEJB;

import entities.Freelancer;
import entities.Jobdescription;
import entities.FreelancerProfile;
import entities.Offer;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import java.util.List;

/**
 *
 * @author zhoux
 */
@Stateless
public class FrelancerProcess {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @PersistenceContext(unitName = "GroupProjectPU")
    private EntityManager em;
    private Freelancer freelancer;
    //private Jobdescription job;
    
    public void persist(Object object) {
        em.persist(object);
    }
    
    /*
    * Register a freelancer
    */
    public void createFreelancer(int ID, String PW) {
        Freelancer freelancer = new Freelancer(ID, PW);
        persist(freelancer);
    }
    
    /*
    * Create a freelancer profile
    */
    public void createFreelancerProfile(String name, String cv, Freelancer freelancerid) {
        FreelancerProfile freelancerprofile = new FreelancerProfile(name, cv, freelancerid);
        persist(freelancerprofile);
    }
    
    public void updataFreelancerAccount(int jobID) {
        TypedQuery<Jobdescription> query1 = em.createNamedQuery("Jobdescription.findByJobid", Jobdescription.class);
        query1.setParameter("jobid", jobID);
        Jobdescription job = null;   
        job = query1.getSingleResult();

        TypedQuery<Offer> query2 = em.createNamedQuery("Offer.findByJobId", Offer.class);        
        query2.setParameter("jobid", job);        
        Offer offer = null;
        offer = query2.getSingleResult();
        Freelancer freelancer = offer.getFreelancerid();
        
        TypedQuery<FreelancerProfile> query3 = em.createNamedQuery("FreelancerProfile.findByFreelancerid", FreelancerProfile.class);        
        query3.setParameter("freelancerid", freelancer);
        FreelancerProfile profile = null;
        profile = query3.getSingleResult();
        
        double payment1 = job.getPayment();
        double payment2 = profile.getAccount();
        double account = payment1 + payment2;
        
        profile.setAccount(account);
    }
    
    /*
    * Remove a profile
    */
    public void removeProfile(int ID) {
        Freelancer freelancer = findPasswordById(ID);
        FreelancerProfile profile = findByFreelancerID(freelancer);
        if (profile != null){
        em.remove(profile);
        }
    }
    
    /*
    * remove a freelancer
    */
    public void removeFreelancer(int ID) {
        this.freelancer = em.find(Freelancer.class, ID);
        em.remove(freelancer);
    }
    
    
    public List<Freelancer> findById(int ID) {
        TypedQuery<Freelancer> query = em.createNamedQuery("Freelancer.findByFreelancerid", Freelancer.class);
        query.setParameter("freelancerid", ID);
        List<Freelancer> freelancer= null;
        try {
            freelancer = query.getResultList();
        }catch (Exception e) {
                    // getSingleResult throws NoResultException in case there is no user in DB
                    // ignore exception and return NULL for user instead
            }
        return freelancer;
    }
    
    public List<Freelancer> findByAll() {
        TypedQuery<Freelancer> query = em.createNamedQuery("Freelancer.findAll", Freelancer.class);
        List<Freelancer> freelancer= null;
        try {
            freelancer = query.getResultList();
        }catch (Exception e) {
                    // getSingleResult throws NoResultException in case there is no user in DB
                    // ignore exception and return NULL for user instead
            }
        return freelancer;
    }   
    
    /*
    *
    */
    public Freelancer findPasswordById(int ID) {
        TypedQuery<Freelancer> query = em.createNamedQuery("Freelancer.getFreelancerPasswordById", Freelancer.class);
        query.setParameter("freelancerid", ID);
        Freelancer freelancer= null;
        try {
            freelancer = query.getSingleResult();
        }catch (Exception e) {
                    // getSingleResult throws NoResultException in case there is no user in DB
                    // ignore exception and return NULL for user instead
            }
        return freelancer;
    }
    
   /*
    public Freelancer findAFreelancerByJobId(int JobID) {
        TypedQuery<Freelancer> query = em.createNamedQuery("Freelancer.getFreelancerPasswordById", Freelancer.class);
        query.setParameter("freelancerid", ID);
        Freelancer freelancer= null;
        try {
            freelancer = query.getSingleResult();
        }catch (Exception e) {
                    // getSingleResult throws NoResultException in case there is no user in DB
                    // ignore exception and return NULL for user instead
            }
        return freelancer;
    }    
    */
    
    /*
    * Find freelancer profile by freelancer ID
    */
    public FreelancerProfile findByFreelancerID(Freelancer ID) {
        TypedQuery<FreelancerProfile> query = em.createNamedQuery("FreelancerProfile.findByFreelancerid", FreelancerProfile.class);
        query.setParameter("freelancerid", ID);
        FreelancerProfile freelancerprofile= null;
        try {
            freelancerprofile = query.getSingleResult();
        }catch (Exception e) {
                    // getSingleResult throws NoResultException in case there is no user in DB
                    // ignore exception and return NULL for user instead
            }
        return freelancerprofile;
    }
    
}
