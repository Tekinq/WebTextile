/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validation;

import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.validator.ValidatorException;
import jakarta.inject.Named;
import java.io.Serializable;

/**
 *
 * @author yalci
 */
@Named(value = "validationBean")
@SessionScoped
public class ValidationBean implements Serializable {

    private String username;
    private String password;
    int deger = 0;

    public boolean validatePassword(FacesContext context, UIComponent component, Object value) throws ValidatorException {//Bean icinde validate metodu "true-false" degerler dondurur

        String v = (String) value;//cast islemi

        if (v.isEmpty()) {
            throw new ValidatorException(new FacesMessage("Şifre Alanı Boş Olamaz !!! "));
        } else if (v.length() < 8) {
            throw new ValidatorException(new FacesMessage("Şifre Uzunluğu En az 8 Karakterli Olmalıdır !!! "));
        }
        return true;

    }
    public boolean validatePassword2(FacesContext context, UIComponent component, Object value) throws ValidatorException {//Bean icinde validate metodu "true-false" degerler dondurur

        String v = (String) value;//cast islemi

        if (!v.equals("admin")) {
            throw new ValidatorException(new FacesMessage("Kullanıcı Adı Yanlış !!! "));
        } 
        return true;

    }

    public void register() {//herhangi bir islem yapilmayacak 
        if (username.equals("admin") && password.equals("12345678")) {
            deger = 1;

        } else {
            deger = 0;
        }
        System.out.println( deger );
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
