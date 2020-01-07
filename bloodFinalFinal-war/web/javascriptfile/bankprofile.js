/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function validateform(){  
        
     var name=document.getElementById("myform:name");
     var contact=document.getElementById("myform:contactno");
        if(name.value===""){
          alert('Name cant be blank');
         return false; 
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
      
     var ave=document.getElementById("myform:ave");
     var anv=document.getElementById("myform:anv");
      var addr =   document.getElementById("myform:address");
        var bve=document.getElementById("myform:bve");
        var bnv=document.getElementById("myform:bnv");
        var abve=document.getElementById("myform:abve");
        var abnv=document.getElementById("myform:abnv");
        var ove=document.getElementById("myform:ove");
        var onv=document.getElementById("myform:onv");  
        
       
    if(addr.value===""){
          alert('Adress cant be blank');
         return false; 
      } 
        
      if(ave.value.match(numbers) )
      {
  
      }
      else{
         alert('Blood bank status fields must be numeric');
         return false;
 
      }  
      
      if(anv.value.match(numbers) )
      {
  
      }
      else{
         alert('Blood bank status fields must be numeric');
         return false;
 
      }   


if(bve.value.match(numbers) )
      {
  
      }
      else{
         alert('Blood bank status fields must be numeric');
         return false;
 
      }   
      if(bnv.value.match(numbers) )
      {
  
      }
      else{
         alert('Blood bank status fields must be numeric');
         return false;
 
      }   
      if(abve.value.match(numbers) )
      {
  
      }
      else{
         alert('Blood bank status fields must be numeric');
         return false;
 
      }   
      if(abnv.value.match(numbers) )
      {
  
      }
      else{
         alert('Blood bank status fields must be numeric');
         return false;
 
      }   
       
       if(ove.value.match(numbers) )
      {
  
      }
      else{
         alert('Blood bank status fields must be numeric');
         return false;
 
      }   
      if(onv.value.match(numbers) )
      {
  
      }
      else{
         alert('Blood bank status fields must be numeric');
         return false;
 
      }    
      
      
    alert("edit Succesful"); 
   return true;  
  }  