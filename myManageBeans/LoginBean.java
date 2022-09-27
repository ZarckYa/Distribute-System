/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package myManageBeans;

import jakarta.ejb.EJB;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

import myEJB.AdminProcess;
import myEJB.JobProcess;
import myEJB.ProviderProcess;
import myEJB.FrelancerProcess;

import entities.Admin;
import entities.Provider;
import entities.Freelancer;
/**
 *
 * @author Administrator
 */
@Named(value = "loginBean")
@SessionScoped
public class LoginBean implements Serializable {

    /**
     * Creates a new instance of LoginBean
     */
    private static final long serialVersionUID = 3254181235309041386L;
    
    private static Logger log = Logger.getLogger(LoginBean.class.getName());
    
    @EJB
    private AdminProcess ap;
    @EJB
    private JobProcess jp;
    @EJB
    private ProviderProcess pp;
    @EJB
    private FrelancerProcess fp;
    
    private int ID;
    private String password;
    private int recordId;
    private String goToPage = "";
    private String loginResult = "";
    
    public String Login() {
        Provider pwProvider = pp.findPasswordById(ID);
        Admin pwAdmin = ap.findPasswordById(ID);
        Freelancer pwFreelancer = fp.findPasswordById(ID);
        // For Freelancer to get password;
        if (pwProvider == null ? password == null : pwProvider.getPassword().equals(password)) {
            this.goToPage = "Provider";
            //this.loginResult = "Successful";
        }else if (pwAdmin == null ? password == null : pwAdmin.getPassword().equals(password)) {
            this.goToPage = "Admin";
            //this.loginResult = "Successful";
        }else if (pwFreelancer == null ? password == null : pwFreelancer.getPassword().equals(password)) {
            this.goToPage = "Freelancer";
            //this.loginResult = "Successful";
        }else {
            this.goToPage="";
            this.loginResult = "ID or Password is not correctly";
        }
        return goToPage;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getLoginResult() {
        return loginResult;
    }

    
    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getGoToPage() {
        return goToPage;
    }
 
    
    public int getRecordId() {
        return recordId;
    }

    public void setRecordId(int recordId) {
        this.recordId = recordId;
    }
    
    public LoginBean() {
    }
    
}
