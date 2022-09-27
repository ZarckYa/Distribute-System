/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package myManageBeans;

import jakarta.ejb.EJB;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import myEJB.FrelancerProcess;
import entities.Freelancer;
import entities.FreelancerProfile;
import java.util.List;
/**
 *
 * @author zhoux
 */
@Named(value = "freelancerBean")
@SessionScoped
public class FreelancerBean implements Serializable {

    /**
     * Creates a new instance of FreelancerBean
     */
    @EJB
    private FrelancerProcess fp;
    
    private int ID;
    private String password;
    private String comfirmPassword;
    private boolean comfirm;
    private List<Freelancer> freelancer;
    private boolean registed;
    private boolean noregisted;
    private boolean showTable;
    private Freelancer Afreelancer;

    private String cv;
    private String name;
    private String returnvalue;
    private FreelancerProfile profile;
    
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

    public String getComfirmPassword() {
        return comfirmPassword;
    }

    public void setComfirmPassword(String comfirmPassword) {
        this.comfirmPassword = comfirmPassword;
    }

    public String getCv() {
        return cv;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
    
    public List<Freelancer> getFreelancer() {
        return freelancer;
    }

    public void setFreelancer(List<Freelancer> freelancer) {
        this.freelancer = freelancer;
    }
    
    public void showTable() {
        this.showTable = true;
    }

    public boolean isShowTable() {
        return showTable;
    }

    
    public void registerFreelancer() {
        comfirmPW();
        if (comfirm == true) {
            fp.createFreelancer(ID, password);
            this.registed = true;
        }else {
            this.noregisted = true;
        }
    }
    
    public void editFreelancerProfile(int ID) {
        findByFreelancerID(ID);
        fp.createFreelancerProfile(name, cv, Afreelancer);
        this.returnvalue = "Edit sucessful";
    }
    
    public void updataFreelancerAccount(int ID) {
        fp.updataFreelancerAccount(ID);
    }
    
    
    public List<Freelancer> findById() {
        this.freelancer = fp.findById(ID);
        return freelancer;
    }
    
    public List<Freelancer> findByALL() {
        this.freelancer = fp.findByAll();
        return freelancer;
    }
    
    public void findByFreelancerID(int ID) {
        this.Afreelancer = fp.findPasswordById(ID);
    }

    public Freelancer getAfreelancer() {
        return Afreelancer;
    }

    public void setAfreelancer(Freelancer Afreelancer) {
        this.Afreelancer = Afreelancer;
    }
    
    public FreelancerProfile findProfileByID(int ID) {
       findByFreelancerID(ID);
       this.profile = fp.findByFreelancerID(Afreelancer);
       return profile;
    }

    public FreelancerProfile getProfile() {
        return profile;
    }
     
    
    public boolean comfirmPW() {
        if (password == null ? comfirmPassword == null : password.equals(comfirmPassword)){
            this.comfirm = true;
        }
        return comfirm;
    }

    public boolean isRegisted() {
        return registed;
    }

    public boolean isNoregisted() {
        return noregisted;
    }

    
    public String notification() {
        return returnvalue;
    }
      
    public FreelancerBean() {
    }
    
}
