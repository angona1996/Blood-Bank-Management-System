/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import static com.sun.faces.facelets.util.Path.context;
import com.sun.faces.util.Util;
import entity.Donor;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.http.HttpSession;
import model.DonorFacade;
import java.io.Serializable;
import javax.faces.context.FacesContext;

/**
 *
 * @author Acer
 */
@Named(value = "donorLogin")
@SessionScoped
public class donorLogin implements Serializable {

    @EJB
    private DonorFacade donorFacade;
    Donor D = new Donor();
    String prb;

    public String getPrb() {
        return prb;
    }

    public void setPrb(String prb) {
        this.prb = prb;
    }
    
    public Donor getD() {
        return D;
    }

    public void setD(Donor D) {
        this.D = D;
    }
    public String login() throws IOException{
        
        
        List<Donor> ss,kk = new ArrayList<Donor>();
                
        ss = this.donorFacade.findAll();
        int l = ss.size();
        int flag = 0;
        System.out.println(l);
        for(int i=0;i<l;i++){
           String em = ss.get(i).getDonorEmail();
           String pass = ss.get(i).getDonorPassword();
           System.out.println(em);
           if(em.equalsIgnoreCase(this.D.getDonorEmail()) && pass.equalsIgnoreCase((this.D.getDonorPassword()))){
               flag = 1;
               FacesContext context = FacesContext.getCurrentInstance();
              context.getExternalContext().getSessionMap().put("email", em);
              this.D = ss.get(i);
              return "donorProfile.xhtml";
              
           }
          
        }
        if(flag==0){
             this.setPrb("Email or Password is wrong !!!!");
             FacesContext context = FacesContext.getCurrentInstance();
            context.getExternalContext().redirect("donorlogin.xhtml");

        }
       return "donorLogins.xhtml"; 
    }
    public void logout(){
        FacesContext context = FacesContext.getCurrentInstance();
	    	context.getExternalContext().invalidateSession();
	        try {
				context.getExternalContext().redirect("index.xhtml");
			} catch (IOException e) {
				e.printStackTrace();
			}
    }
    
    public  String edit(){
        this.donorFacade.edit(this.D);
        return "donorProfile";
    }

    /**
     * Creates a new instance of donorLogin
     */
    public donorLogin() {
    }
    
}
