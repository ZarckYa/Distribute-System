/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package myEJB;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import entities.Jobdescription;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceUnit;
import java.util.List;



/**
 *
 * @author Administrator
 */
@Stateless
public class JobProcess {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @PersistenceContext(unitName = "GroupProjectPU")
    private EntityManager em;
    private Jobdescription job;
    //private final EntityManager em = emf.createEntityManager();
    
    /*
    * Use to write a new entry into database
    */
    public void persist(Object object) {
        em.persist(object);
    }
    
    /*
    *  Use to create a job description.  
    */
    public void createJob(String title, String keywords, String description, double payment, int provoderID, boolean openstatus, boolean completedstatus) {
        Jobdescription job = new Jobdescription(title, keywords, description, payment, provoderID, openstatus, completedstatus);
        persist(job);
    }
    
    
    /*
    * Use to remove a job by the current ID, so it will not be null.
    * do not to do a null judgement
    */
    public void removeJob(int ID) {
        this.job = em.find(Jobdescription.class, ID);
        em.remove(job);
    }

    /*
    * Mark a job as close status
    */
    public void markAsCompleted(int ID) {
        TypedQuery<Jobdescription> query = em.createNamedQuery("Jobdescription.findByJobid", Jobdescription.class);
            query.setParameter("jobid", ID);
            Jobdescription jobs = null;
            jobs = query.getSingleResult();
            jobs.setCompletedstatu(Boolean.TRUE);
    }
    
    /*
    * Mark a job as close status
    */
    public void markAsClose(int ID) {
        TypedQuery<Jobdescription> query = em.createNamedQuery("Jobdescription.findByJobid", Jobdescription.class);
            query.setParameter("jobid", ID);
            Jobdescription jobs = null;
            jobs = query.getSingleResult();
            jobs.setOpenstatu(Boolean.FALSE);        
    }
    
    /*
    * Find a job by keywords.
    */
    public List<Jobdescription> findBykeywords(String keywords) {
        TypedQuery<Jobdescription> query = em.createNamedQuery("Jobdescription.findByKeyword", Jobdescription.class);
            query.setParameter("keyword", keywords);
            List<Jobdescription> jobs = null;
            try {
                    jobs = query.getResultList();
            } catch (Exception e) {
                    // getSingleResult throws NoResultException in case there is no user in DB
                    // ignore exception and return NULL for user instead
            }
            return jobs;    
    }
    
    /*
    * Search job by job ID
    */
    public List<Jobdescription> findById(int jobID) {
        TypedQuery<Jobdescription> query = em.createNamedQuery("Jobdescription.findByJobid", Jobdescription.class);
            query.setParameter("jobid", jobID);
            List<Jobdescription> jobs = null;
            try {
                    jobs = query.getResultList();
            } catch (Exception e) {
                    // getSingleResult throws NoResultException in case there is no user in DB
                    // ignore exception and return NULL for user instead
            }
            return jobs;
    }
    
    /*
    * Find A job by job ID
    */
    public Jobdescription findByJobID(int jobID) {
        TypedQuery<Jobdescription> query = em.createNamedQuery("Jobdescription.findByJobid", Jobdescription.class);
            query.setParameter("jobid", jobID);
            Jobdescription jobs = null;
            try {
                    jobs = query.getSingleResult();
            } catch (Exception e) {
                    // getSingleResult throws NoResultException in case there is no user in DB
                    // ignore exception and return NULL for user instead
            }
            return jobs;   
    }
    
    
    /*
    * Search job by Provider ID
    */
    public List<Jobdescription> findByProviderId(int providerID) {
        TypedQuery<Jobdescription> query = em.createNamedQuery("Jobdescription.findByProvideid", Jobdescription.class);
            query.setParameter("provideid", providerID);
            List<Jobdescription> jobs = null;
            try {
                    jobs = query.getResultList();
            } catch (Exception e) {
                    // getSingleResult throws NoResultException in case there is no user in DB
                    // ignore exception and return NULL for user instead
            }
            return jobs;    
    }
    
    public Jobdescription findAJobByProviderId(int providerID) {
        TypedQuery<Jobdescription> query = em.createNamedQuery("Jobdescription.findByProvideid", Jobdescription.class);
            query.setParameter("provideid", providerID);
            Jobdescription jobs = null;
            try {
                    jobs = query.getSingleResult();
            } catch (Exception e) {
                    // getSingleResult throws NoResultException in case there is no user in DB
                    // ignore exception and return NULL for user instead
            }
            return jobs;    
    }    
    
    /*
    * Find job by open status
    */
    public List<Jobdescription> findByOpenstatu(boolean openstatu) {
        TypedQuery<Jobdescription> query = em.createNamedQuery("Jobdescription.findByOpenstatu", Jobdescription.class);
            query.setParameter("openstatu", openstatu);
            List<Jobdescription> jobs = null;
            try {
                    jobs = query.getResultList();
            } catch (Exception e) {
                    // getSingleResult throws NoResultException in case there is no user in DB
                    // ignore exception and return NULL for user instead
            }
            return jobs;    
    }
    
    
    public List<Jobdescription> findByALL() {
        TypedQuery<Jobdescription> query = em.createNamedQuery("Jobdescription.findAll", Jobdescription.class);
            //query.setParameter("openstatu", openstatu);
            List<Jobdescription> jobs = null;
            try {
                    jobs = query.getResultList();
            } catch (Exception e) {
                    // getSingleResult throws NoResultException in case there is no user in DB
                    // ignore exception and return NULL for user instead
            }
            return jobs;    
    }
    
    
    
    
}
