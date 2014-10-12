/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import jpa.example.DbuserFacade;
import jpa.interceptors.Login;

/**
 *
 * @author Pawel
 */
@Named
@RequestScoped
public class LoginBean {
    @EJB
    private DbuserFacade dbuserFacade;
    private String name;
    private String pass;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    @Login
    public String authentificate() {
        List<String> dbPass = 
                dbuserFacade.executeQuery("SELECT d.password FROM Dbuser d WHERE d.username ='"+name+"'" );
        System.out.println("Authenticate for user : "+name+", pass : "+pass);
        if(dbPass.size() > 0 && dbPass.get(0).equals(pass)) {
           
                return "cars.xhtml?faces-redirect=true";
       }
       else {
            System.out.println("False");
                FacesContext.getCurrentInstance().addMessage(null,
                   new FacesMessage(FacesMessage.SEVERITY_ERROR, "Incorrect password", "Incorrect passsword"));
                return "";   
            }
    }
    public String test() {
        System.out.println("test");
        return "welcomePrimefaces.xhtml?faces-redirect=true";
    }
    
    
}
