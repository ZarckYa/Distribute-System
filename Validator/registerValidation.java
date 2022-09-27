/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Validator;

import com.sun.xml.wss.impl.callback.PasswordValidationCallback.PasswordValidator;
import entities.Admin;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.validator.FacesValidator;
import jakarta.faces.validator.Validator;
import jakarta.faces.validator.ValidatorException;

/**
 *
 * @author Administrator
 */

@FacesValidator(value = "registerValidation")

public class registerValidation implements Validator {
    
    
    @Override
    public void validate(FacesContext fc, UIComponent uic, Object t) throws ValidatorException {
        
        String password = (String) t;
        String information = "";
        
        boolean hasNum = false;
        boolean hasUpper = false;
        boolean hasLower = false;
        boolean validlength = false;
        boolean noWhiteSpace = true;
        
        if(password.length() > 10) {
            validlength = true;
        } else {
            information = "Your password MUST at least 10 characters."; 
        }        
        
        for (int i = 0; i< password.length(); i++) {
            
            char c = password.charAt(i);
            if (Character.isWhitespace(c)) {
                noWhiteSpace = false;   
            } else if (Character.isDigit(c)) {
                hasNum = true;   
            } else if (Character.isUpperCase(c)) {
                hasUpper = true;     
            } else if (Character.isLowerCase(c)) {
                hasLower = true;    
            }
        }
        
        if (!noWhiteSpace) {
            information = "Your password CAN'T contain WHITESPACE."; 
        } else if (!hasNum) {
        information = "Your password MUST contain DIGIT.";  
        } else if (!hasUpper) {
        information = "Your password MUST contain UPPERCHARACTER.";
        } else if (!hasLower) {
        information = "Your password MUST contain LOWERCHARACTER.";
        }
        
        if (!noWhiteSpace | !hasNum | !hasUpper | !hasLower | !validlength) {
            FacesMessage message = new FacesMessage();
            //message.setDetail(information);
            message.setSummary(information);
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(message);
        }
     
}
}
    

