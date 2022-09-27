/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package myEJB;


import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import entities.Loginfo;
import jakarta.persistence.TypedQuery;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Administrator
 */
@Stateless
public class LogProcess {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @PersistenceContext(unitName = "GroupProjectPU")
    private EntityManager em;
    
    public void persist(Object object) {
        em.persist(object);
    }
    
    /*
    * Create log in the table.
    */
    public void createLog(String loginfo, Date date) {
        Loginfo log = new Loginfo(loginfo,date);
        persist(log);
    }
    
    public List<Loginfo> findLogByAll() {
        TypedQuery<Loginfo> query = em.createNamedQuery("Loginfo.findAll", Loginfo.class);
        List<Loginfo> log = null;
        try {
               log = query.getResultList();
            } catch (Exception e) {
                    // getSingleResult throws NoResultException in case there is no user in DB
                    // ignore exception and return NULL for user instead
            }
            return log;  
    }
}
