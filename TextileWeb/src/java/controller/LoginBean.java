/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import entity.UserManager;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.validator.ValidatorException;
import jakarta.inject.Named;
import java.io.Serializable;

/**
 *
 * @author yalci
 */
@Named(value="lc")
@SessionScoped
public class LoginBean implements Serializable{
    
    
    private UserManager user;


    public LoginBean() {


    }

    public void login(){

        if ( user.getUsername().equals("admin") && user.getPassword().equals("12345678")  ) {

            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("validUser",user );

        }else{

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Username or password is Wrong !"));

        }
    }

    public UserManager getUser() {
        if( user == null ){
            user = new UserManager();

        }
        return user;
    }

    public void setUser(UserManager user) {
        this.user = user;
    }
    
}
