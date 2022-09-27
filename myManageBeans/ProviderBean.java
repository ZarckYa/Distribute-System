/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package myManageBeans;

import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import entities.Provider;
import jakarta.ejb.EJB;
import java.util.List;
import myEJB.ProviderProcess;
/**
 *
 * @author Administrator
 */
@Named(value = "providerBean")
@SessionScoped
public class ProviderBean implements Serializable {

    @EJB
    private ProviderProcess pps;

    private int ID;
    private String password;
    private String comfirmPassword;
    private boolean comfirm;
    List<Provider> provider;
    private String returnvalue;
    private String providerString;
    private boolean registed;
    private boolean noregisted;
    private boolean showTable;
    private Provider Aprovider;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getPassword() {
        return password;
    }

    /**
     * Creates a new instance of ProviderBean
     */
    public void setPassword(String password) {
        this.password = password;
    }


    public List<Provider> getProvider() {
        return provider;
    }

    public void setProvider(List<Provider> provider) {
        this.provider = provider;
    }

    public String getReturnvalue() {
        return returnvalue;
    }

    public void setReturnvalue(String returnvalue) {
        this.returnvalue = returnvalue;
    }

    public String getComfirmPassword() {
        return comfirmPassword;
    }

    public boolean isComfirm() {
        return comfirm;
    }

    public boolean isRegisted() {
        return registed;
    }

    public boolean isNoregisted() {
        return noregisted;
    }

    public void showTable() {
        this.showTable = true;
    }

    public boolean isShowTable() {
        return showTable;
    }
    
    public void setComfirmPassword(String comfirmPassword) {
        this.comfirmPassword = comfirmPassword;
    }

    
    
    public void registerProvider() {
        comfirmPW();
        if (comfirm == true) {
            Provider provider = null;
            pps.createProvider(ID, password);
            this.registed = true;
        }else {
            this.noregisted = true;
        }
    }
    
    public boolean comfirmPW() {
        if (password == null ? comfirmPassword == null : password.equals(comfirmPassword)){
            this.comfirm = true;
        }
        return comfirm;
    }
    
    
    public List<Provider> findByProviderId() {
        //List<Provider> provider = null;
        this.provider = pps.findById(ID);
        return provider;
    }
    
    public void findByProviderID(int ID) {
        this.Aprovider = pps.findPasswordById(ID);
    }

    public Provider getAprovider() {
        return Aprovider;
    }

    
    public List<Provider> findALL() {
        //List<Provider> provider = null;
        this.provider = pps.findALL();
        
        return provider;
    }
   
    public String notification() {
        if (provider != null) {
            this.returnvalue = "Successful";
        }
        return returnvalue;
    }

    public void removeProvider() {
        
    }
    
    
    public ProviderBean() {
    }
    
}
