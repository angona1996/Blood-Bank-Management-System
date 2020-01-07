/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function donorprofilevalidateform(){  
        
     var name=document.getElementById("myform1:name");
     
        if(name.value===""){
          alert('Name cant be blank');
         return false; 
      } 
    

var contact=document.getElementById("myform1:contactno");
     var email = document.getElementById("myform1:email");
     var password = document.getElementById("myform1:password");
     var district = document.getElementById("myform1:district");
     var availability = document.getElementById("myform1:availability");
     var bg=document.getElementById("myform1:bg");






     
       
     if(email.value === "") {
       alert('Email cant be blank');
       return false;
        
    } else {
        // Regular expression for basic email validation
        var regex = /^\S+@\S+\.\S+$/;
        if(regex.test(email.value) === false) {
            
            alert("Please enter a valid email address");
            return false;
        }
    }
       
        
       if(contact.value===""){
          alert('Contact No cant be blank');
         return false; 
      }
      var numbers = /^[0-9]+$/;
      
      if(contact.value.match(numbers)){
          
      }
      else{
         alert('Contact No must be numeric');
         return false;  
      }
      
      if(contact.value.length === 11){
          
      }
      else{
         alert('Contact No must be of 11 digits');
         return false;  
      }
      
      
      if(district.value===""){
          alert('District cant be blank');
         return false; 
      } 
      if(availability.value===""){
          alert('Availability cant be blank');
         return false; 
      } 
      if(bg.value===""){
          alert('BloodGroup cant be blank');
         return false; 
      }     
    
        
    alert("Registration Succesful"); 
   return true;  
  }  