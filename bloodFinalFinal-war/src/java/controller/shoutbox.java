/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import model.ShoutboxFacade;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import entity.*;
import java.io.IOException;
import model.DonorFacade;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
/**
 *
 * @author User
 */
@Named(value = "shoutbox")
@RequestScoped
public class shoutbox {
    

    @EJB
    private DonorFacade donorFacade;

    @EJB
    private ShoutboxFacade shoutboxFacade;
    
    static Properties mailServerProperties;
	static Session getMailSession;
	static MimeMessage generateMailMessage;
Shoutbox s = new Shoutbox();
Donor d= new Donor();

    public Donor getD() {
        return d;
    }

    public void setD(Donor d) {
        this.d = d;
    }


    public Shoutbox getS() {
        return s;
    }

    public void setS(Shoutbox s) {
        this.s = s;
    }

    
    public shoutbox() {
    }
     public String addShout() throws IOException, MessagingException{
               
       this.shoutboxFacade.create(this.s);
       searchDonor();
        return "shoutbox";
       
    }
    
    public List<Shoutbox> findAll() {
        List<Shoutbox> ss =  this.shoutboxFacade.findAll();
       Collections.reverse(ss);
       return ss;        
//return this.shoutboxFacade.findAll();
        
    }
    
     public String searchDonor() throws IOException, AddressException, MessagingException {
    List<Donor> ss,kk = new ArrayList<Donor>();
                
        ss = this.donorFacade.findAll();
        int l = ss.size();
        for(int i=0;i<l;i++){
           String bg = ss.get(i).getDonorBloodGroup();
           if(bg.equalsIgnoreCase(this.s.getBloodGroup()) ){
               kk.add(ss.get(i));
           }
        }
      for(int i=0;i<kk.size();i++)
      {
          String to =kk.get(i).getDonorEmail();
        
          System.out.println("\n 1st ===> setup Mail Server Properties..");
		mailServerProperties = System.getProperties();
		mailServerProperties.put("mail.smtp.port", "587");
		mailServerProperties.put("mail.smtp.auth", "true");
		mailServerProperties.put("mail.smtp.starttls.enable", "true");
		System.out.println("Mail Server Properties have been setup successfully..");
 
		// Step2
		System.out.println("\n\n 2nd ===> get Mail Session..");
		getMailSession = Session.getDefaultInstance(mailServerProperties, null);
		generateMailMessage = new MimeMessage(getMailSession);
		generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
		generateMailMessage.addRecipient(Message.RecipientType.CC, new InternetAddress("siamrahman5@gmail.com"));
		generateMailMessage.setSubject("Donate blood save life.....");
		String emailBody = "Greetings from BloodFInder...Someone needs your help..."+"Required blood Group :" + this.s.getBloodGroup()+
                            "...Address: " + this.s.getAddress()+"....Contact no: " +this.s.getContactNo()+"...msg from the patient: "+this.s.getMessage() ;
		generateMailMessage.setContent(emailBody, "text/html");
		System.out.println("Mail Session has been created successfully..");
 
		// Step3
		System.out.println("\n\n 3rd ===> Get Session and Send mail");
        // Enter your correct gmail UserID and Password
        // if you have 2FA enabled then provide App Specific Password
        try (Transport transport = getMailSession.getTransport("smtp")) {
            // Enter your correct gmail UserID and Password
            // if you have 2FA enabled then provide App Specific Password
            transport.connect("smtp.gmail.com", "tapotoshghosh@gmail.com", "tapu_soma1996");
            transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
        }
        

      }
        return "shoutbox";
    }
    
}
