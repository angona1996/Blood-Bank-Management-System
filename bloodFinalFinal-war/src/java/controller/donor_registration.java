/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Donor;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.DonorFacade;

/**
 *
 * @author Acer
 */
@Named(value = "donor_registration")
@RequestScoped
public class donor_registration {

   @EJB
    private DonorFacade donorFacade;
    String name;
    String pass;
    String email;
    String district;
    String bg;
    String Availability;
    String contact;
    String prb = "";

    public String getPrb() {
        return prb;
    }

    public void setPrb(String prb) {
        this.prb = prb;
    }
    

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getBg() {
        return bg;
    }

    public void setBg(String bg) {
        this.bg = bg;
    }

    public String getAvailability() {
        return Availability;
    }

    public void setAvailability(String Availability) {
        this.Availability = Availability;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
    
    
    
    Donor D = new Donor();

    public Donor getD() {
        return D;
    }

    public void setD(Donor D) {
        this.D = D;
    }
    
    /**
     * 
     * Creates a new instance of donor_registration
     */
    public donor_registration() {
    }
    
        
    public String addDonor(){
       
       List<Donor> ss,kk = new ArrayList<Donor>();
                
        ss = this.donorFacade.findAll();
        int l = ss.size();
        int flag = 0;
        System.out.println(l);
        for(int i=0;i<l;i++){
           String em = ss.get(i).getDonorEmail();
           System.out.println(em);
           if(em.equalsIgnoreCase(this.D.getDonorEmail())){
               flag = 1;
           }
          
        }
        
        if(flag==1){
            this.setPrb("Registered with this email already!!!!");
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_WARN,
                "Used Email", "Someone is already registered with this email"));
            
                return "donor_registration";
        }
        else{
        
        
         
        
       this.donorFacade.create(this.D);
        return "index";
       }
    }
    
    public List<Donor> findAll() {
        return this.donorFacade.findAll();
        
    }
}
