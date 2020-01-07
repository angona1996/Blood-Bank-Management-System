package controller;




import entity.BloodBank;
import entity.Donor;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import model.BloodBankFacade;

/**
 *
 * @author Acer
 */
@Named(value = "bankLoginController")
@SessionScoped



public class BankLoginController implements Serializable {

    @EJB
    private BloodBankFacade bloodBankFacade;
    BloodBank bb = new BloodBank();

    public BloodBank getBb() {
        return bb;
    }
   String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
   

    public void setBb(BloodBank bb) {
        this.bb = bb;
    }
    
    

    
    
     String prb;

    public String getPrb() {
        return prb;
    }

    public void setPrb(String prb) {
        this.prb = prb;
    }
    /**
     * Creates a new instance of BankLoginController
     */
    public BankLoginController() {
    }
    
    
    public String login() throws IOException{
        List<BloodBank> ss,kk = new ArrayList<BloodBank>();
                
        ss = this.bloodBankFacade.findAll();
        int l = ss.size();
        int flag = 0;
        System.out.println(l);
        for(int i=0;i<l;i++){
           String em = ss.get(i).getBankEmail();
           String pass = ss.get(i).getPassword();
           System.out.println(em);
           if(em.equalsIgnoreCase(this.bb.getBankEmail()) && pass.equals((this.bb.getPassword()))){
               flag = 1;
               FacesContext context = FacesContext.getCurrentInstance();
              context.getExternalContext().getSessionMap().put("email", em);
               setEmail(em);
              this.bb = ss.get(i);
              return "bloodBankProfile.xhtml";
              
           }
          
        }
        if(flag==0){
             this.setPrb("Email or Password is wrong !!!!");
             FacesContext context = FacesContext.getCurrentInstance();
            context.getExternalContext().redirect("bloodBankLogin.xhtml");

        }
       return "bloodBankLogin.xhtml"; 
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
        this.bloodBankFacade.edit(this.bb);
        
        
        
        return "bloodBankProfile.xhtml";
    }

    
}
