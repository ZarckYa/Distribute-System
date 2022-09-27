/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package myEJB;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceUnit;
import entities.Provider;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import java.util.List;
/**
 *
 * @author Administrator
 */
@Stateless
public class ProviderProcess {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    //@PersistenceUnit(unitName = "GroupProjectPU")
    @PersistenceContext(unitName = "GroupProjectPU")
    private EntityManager em;
    private Provider provider;
    //EntityManagerFactory emf = Persistence.createEntityManagerFactory("GroupProjectPU");
    //private EntityManager em = emf.createEntityManager();
    
    public void persist(Object object) {
        em.persist(object);
    }
    
    /**
     *  Use to create a new job
     *  Parameter is ID and password
     * */
    public void createProvider(int ID, String PW) {
        Provider provider = new Provider(ID, PW);
        persist(provider);
    }
    
    /*
    *  Used to remove provider by provider ID
    */
    public void removeProvider(int ID) {
        this.provider = em.find(Provider.class, ID);
        em.remove(provider);
    }
    
    
    public List<Provider> findById(int ID) {
            TypedQuery<Provider> query = em.createNamedQuery("Provider.findById", Provider.class);
            query.setParameter("id", ID);
            List<Provider> provider = null;
            try {
                    provider = query.getResultList();
            } catch (Exception e) {
                    // getSingleResult throws NoResultException in case there is no user in DB
                    // ignore exception and return NULL for user instead
            }
            return provider;  
    }
    
        public List<Provider> findALL() {
            TypedQuery<Provider> query = em.createNamedQuery("Provider.findAll", Provider.class);
            //query.setParameter("id", ID);
            List<Provider> provider = null;
            try {
                    provider = query.getResultList();
            } catch (Exception e) {
                    // getSingleResult throws NoResultException in case there is no user in DB
                    // ignore exception and return NULL for user instead
            }
            return provider;
    }
    

    public Provider findPasswordById(int ID) {
        TypedQuery<Provider> query = em.createNamedQuery("Provider.getProvidePasswordById", Provider.class);
        query.setParameter("id", ID);
        Provider pw = null;
        try {
                    pw = query.getSingleResult();
            } catch (Exception e) {
                    // getSingleResult throws NoResultException in case there is no user in DB
                    // ignore exception and return NULL for user instead
            }
        return pw;
    }
    
}
