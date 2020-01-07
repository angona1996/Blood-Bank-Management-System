/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.BloodBank;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import model.BloodBankFacade;

/**
 *
 * @author Acer
 */
@Named(value = "bankRegistrationController")
@RequestScoped
public class BankRegistrationController implements Serializable {

    @EJB
    private BloodBankFacade bloodBankFacade;
    BloodBank bb = new BloodBank();

    public BloodBank getBb() {
        return bb;
    }

    public void setBb(BloodBank bb) {
        this.bb = bb;
    }
    
      String prb = "";

    public String getPrb() {
        return prb;
    }

    public void setPrb(String prb) {
        this.prb = prb;
    }
      
    

    /**
     * Creates a new instance of BankRegistrationController
     */
    public BankRegistrationController() {
    }
    
    public String addBank(){
       
       List<BloodBank> ss,kk = new ArrayList<BloodBank>();
                
        ss = this.bloodBankFacade.findAll();
        int l = ss.size();
        int flag = 0;
        System.out.println(l);
        for(int i=0;i<l;i++){
           String em = ss.get(i).getBankEmail();
           System.out.println(em);
           if(em.equalsIgnoreCase(this.bb.getBankEmail())){
               flag = 1;
           }
          
        }
        
        if(flag==1){
            this.setPrb("Registered with this email already!!!!");
            
                return "bankregistration";
        }
        else{
        
        
         
        
       this.bloodBankFacade.create(this.bb);
        return "index";
       }
    }
    
    public List<BloodBank> findAll() {
        return this.bloodBankFacade.findAll();
        
    }
}
