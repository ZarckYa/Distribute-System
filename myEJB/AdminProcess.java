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
import jakarta.persistence.TypedQuery;

import entities.Admin;
import jakarta.persistence.PersistenceContext;
import java.util.List;
/**
 *
 * @author Administrator
 */
@Stateless
public class AdminProcess {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
        // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    //@PersistenceUnit(unitName = "GroupProjectPU")
    //EntityManagerFactory emf = Persistence.createEntityManagerFactory("GroupProjectPU");
    @PersistenceContext(unitName = "GroupProjectPU")
    private EntityManager em;
    //private final EntityManager em = emf.createEntityManager();
    
    public void persist(Object object) {
        em.persist(object);
    }
    
    public void createAdmin(int ID, String Password) {
        Admin ad = new Admin(ID, Password);
        persist(ad);
    
    }
    
    public List<Admin> findByID(int ID) {
        TypedQuery<Admin> query = em.createNamedQuery("Admin.findByAdminid", Admin.class);
        query.setParameter("adminid", ID);
        List<Admin> admin = null;
        try {
               admin = query.getResultList();
            } catch (Exception e) {
                    // getSingleResult throws NoResultException in case there is no user in DB
                    // ignore exception and return NULL for user instead
            }
            return admin;  
    }
    
    public List<Admin> findAll() {
        TypedQuery<Admin> query = em.createNamedQuery("Admin.findAll", Admin.class);
        //query.setParameter("adminid", ID);
        List<Admin> admin = null;
        try {
               admin = query.getResultList();
            } catch (Exception e) {
                    // getSingleResult throws NoResultException in case there is no user in DB
                    // ignore exception and return NULL for user instead
            }
            return admin;  
    }
    
    public Admin findPasswordById(int ID) {
        TypedQuery<Admin> query = em.createNamedQuery("Admin.getAdminPasswordById", Admin.class);
        query.setParameter("adminid", ID);
        Admin pw = null;
        //String password = "";
        try {
                    pw = query.getSingleResult();
                    //password = pw.toString();
            } catch (Exception e) {
                    // getSingleResult throws NoResultException in case there is no user in DB
                    // ignore exception and return NULL for user instead
            }
        return pw;
    }
    
}
