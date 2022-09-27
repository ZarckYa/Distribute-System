/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package myManageBeans;


import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import myEJB.LogProcess;
import entities.Loginfo;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Administrator
 */
@Named(value = "logBean")
@RequestScoped
public class LogBean {

    /**
     * Creates a new instance of LogBean
     */
    
    @EJB
    private LogProcess lps; 
    
    private String log;
    private List<Loginfo> loginfomation;
    private int freelancerid;
    private int providerid;
    private int jobid;
    
    public void createLog() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
        Date date = new Date();
        lps.createLog(log, date);
    }

    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
    }
    
    
    public List<Loginfo> findLogAll() {
        this.loginfomation = lps.findLogByAll();
        return loginfomation;
    }
    
    // Freelancer submit a application
    public void offerLog(int freelancerid, int providerid, int jobid){
        this.log = String.format("Freelancer %d submit a offer to Provider %d, jobID: %d",freelancerid, providerid, jobid);
    }
    
    // Freelancer revoke a application
    public void revokeLog(int freelancerid, int providerid, int jobid){
        this.log = String.format("Freelancer %d revoke a application from Provider %d, jobID: %d",freelancerid, providerid, jobid);
    }    

    // Generate a job cocmpleted log info use this methods    
    public void MarkAsCompletedLog(int providerid, int jobid, double payment){
        this.log = String.format("Provider %d mark the jobID: %d as completed, salary: %.2f euro has been deliveried", providerid, jobid, payment);
    } 
    
    // Generate a log info use this methods
    public void AcceptLog(int providerid, int freelancerid, int jobid){
        this.log = String.format("Provider %d acccept application from Freelancer %d: jobID: %d", providerid, freelancerid, jobid);
    }
    
    public LogBean() {
    }
    
}
