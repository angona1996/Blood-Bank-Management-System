/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.sun.xml.ws.client.RequestContext;
import entity.Donor;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.Alert;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.DonorFacade;

/**
 *
 * @author Acer
 */
@Named(value = "donorSearch")
@RequestScoped
public class donorSearch implements Serializable {

    @EJB
    private DonorFacade donorFacade;
    Donor d = new Donor();
    List<Donor> sr =new ArrayList<Donor>();
    String prb;

    public String getPrb() {
        return prb;
    }

    public void setPrb(String prb) {
        this.prb = prb;
    }
    

    public List<Donor> getSr() {
        return sr;
    }

    public void setSr(List<Donor> sr) {
        this.sr = sr;
    }
    
    public Donor getD() {
        return d;
    }

    public void setD(Donor d) {
        this.d = d;
    }
    
    /**
     * Creates a new instance of donorSearch
     */
    public donorSearch() {
    }
    
     public String search() throws IOException{
         setPrb("");
       List<Donor> kk1 = new ArrayList<Donor>();
         kk1 = searchresult();
        if(kk1.size()==0){
            return "search_result";
        }
        else {
            
            return "search_result";
        }
        
    }
     
    public List<Donor> searchresult() throws IOException {
    List<Donor> ss,kk = new ArrayList<Donor>();
                
        ss = this.donorFacade.findAll();
        int l = ss.size();
        for(int i=0;i<l;i++){
           String bg = ss.get(i).getDonorBloodGroup();
           if(bg.equalsIgnoreCase(this.d.getDonorBloodGroup()) && ss.get(i).getDonorAvailability().equalsIgnoreCase("yes") ){
               kk.add(ss.get(i));
           }
        }
        setSr(kk);
        if(kk.size()==0){
            setPrb("No Result Found");
            //this.prb="No Result Found";
           
           
        }
        else {
            setPrb("");
        }
        return kk;
    }
   

 
    
}
