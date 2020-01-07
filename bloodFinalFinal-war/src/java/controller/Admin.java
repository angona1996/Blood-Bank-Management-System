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
import model.ShoutboxFacade;
import entity.*;
import java.util.ArrayList;
import java.util.List;
import model.AdminLoginFacade;
import model.BloodBankFacade;
/**
 *
 * @author User
 */
@Named(value = "admin")
@SessionScoped
public class Admin implements Serializable {

    public BloodBankFacade getBloodBankFacade() {
        return bloodBankFacade;
    }

    public void setBloodBankFacade(BloodBankFacade bloodBankFacade) {
        this.bloodBankFacade = bloodBankFacade;
    }

    @EJB
    private BloodBankFacade bloodBankFacade;

    @EJB
    private AdminLoginFacade adminLoginFacade;

    @EJB
    private ShoutboxFacade shoutboxFacade;

    public AdminLoginFacade getAdminLoginFacade() {
        return adminLoginFacade;
    }

    public void setAdminLoginFacade(AdminLoginFacade adminLoginFacade) {
        this.adminLoginFacade = adminLoginFacade;
    }

    public ShoutboxFacade getShoutboxFacade() {
        return shoutboxFacade;
    }

    public void setShoutboxFacade(ShoutboxFacade shoutboxFacade) {
        this.shoutboxFacade = shoutboxFacade;
    }
     String prb = "";

    public String getPrb() {
        return prb;
    }

    public void setPrb(String prb) {
        this.prb = prb;
    }
Shoutbox s=new Shoutbox();
AdminLogin a=new AdminLogin();
BloodBank b=new BloodBank();

    public BloodBank getB() {
        return b;
    }

    public void setB(BloodBank b) {
        this.b = b;
    }

    public AdminLogin getA() {
        return a;
    }

    public void setA(AdminLogin a) {
        this.a = a;
    }

    public Admin(AdminLoginFacade adminLoginFacade, ShoutboxFacade shoutboxFacade) {
        this.adminLoginFacade = adminLoginFacade;
        this.shoutboxFacade = shoutboxFacade;
    }

   public List<Shoutbox> findAll() {
        return this.shoutboxFacade.findAll();
        
    }
   public void delete(Shoutbox p)
   {
       this.shoutboxFacade.remove(p);
   }
    public String addAdmin(){
       
       List<AdminLogin> ss,kk = new ArrayList<AdminLogin>();
                
        ss = this.adminLoginFacade.findAll();
        int l = ss.size();
        int flag = 0;
        System.out.println(l);
        for(int i=0;i<l;i++){
           String em = ss.get(i).getAdminEmail();
           System.out.println(em);
           if(em.equalsIgnoreCase(this.a.getAdminEmail())){
               flag = 1;
           }
          
        }
        
        if(flag==1){
            this.setPrb("Registered with this email already!!!!");
            
                return "adminCreate";
        }
        else{
        
        
         
        
       this.adminLoginFacade.create(this.a);
        return "adminloginView";
       }
    }
    public List<BloodBank> findAll2() {
        return this.bloodBankFacade.findAll();
        
    }
    public List<AdminLogin> findAll3() {
        return this.adminLoginFacade.findAll();
        
    }
    public Admin() {
    }
    
}
