/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import model.AdminLoginFacade;
import entity.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.context.FacesContext;
/**
 *
 * @author User
 */
@Named(value = "adminLogin")
@SessionScoped
public class AdminLoginController implements Serializable {

    @EJB
    private AdminLoginFacade adminLoginFacade;

  AdminLogin a= new AdminLogin();

    public AdminLogin getA() {
        return a;
    }

    public void setA(AdminLogin a) {
        this.a = a;
    }
  
String prb;

    public String getPrb() {
        return prb;
    }

    public void setPrb(String prb) {
        this.prb = prb;
    }
    
   
  
    public AdminLoginController() {
    }
    public String login() throws IOException{
        
        
        List<AdminLogin> ss,kk = new ArrayList<AdminLogin>();
                
        ss = this.adminLoginFacade.findAll();
        int l = ss.size();
        int flag = 0;
        System.out.println(l);
        for(int i=0;i<l;i++){
           String em = ss.get(i).getAdminEmail();
           String pass = ss.get(i).getAdminPassword();
           System.out.println(em);
           if(em.equalsIgnoreCase(this.a.getAdminEmail()) && pass.equalsIgnoreCase((this.a.getAdminPassword()))){
               flag = 1;
               FacesContext context = FacesContext.getCurrentInstance();
              context.getExternalContext().getSessionMap().put("email", em);
              this.a = ss.get(i);
              return "admin.xhtml";
              
           }
          
        }
        if(flag==0){
             this.setPrb("Email or Password is wrong !!!!");
             FacesContext context = FacesContext.getCurrentInstance();
            context.getExternalContext().redirect("adminloginView.xhtml");

        }
       return "adminloginView.xhtml"; 
    }
      public void logout(){
        FacesContext context = FacesContext.getCurrentInstance();
	    	context.getExternalContext().invalidateSession();
	        try {
				context.getExternalContext().redirect("adminloginView.xhtml");
			} catch (IOException e) {
				e.printStackTrace();
			}
    }
}
