function validateForm()
{
	var proid=document.getElementById("proid").value;
	var proname=document.getElementById("proname").value;
	var proprice=document.getElementById("proprice").value;
	var probrand=document.getElementById("probrand").value;
	
	if(proid.trim()===""||proname.trim()===""||probrand.trim()==="")
	{
		alert("these fields must not be empty")
		 return false;
	}
	 if(parseInt(proprice)<0)
	 {
		 alert("the price must not be negative")
		  return false;
	 }
	 if(proname.length>50 || probrand.length>50)
	 {
		  alert("product name & product brand must be less than50 characters");
		  return false;
	 }
	 //get the mfg & exp dates
	 var mnfDate=document.getElementById("manufactureddate");
	 var expDate=document.getElementById("expirydate");
	 var manifactureingDate=new Date("mnfDate").value;
	 var expiryDate=new Date("expDate").value;
	  if(manifactureingDate>expiryDate)
	  {
		  alert("manifactured date cannpt be greater  than expiry date")
		   return false
	  }
	   return true;
}
   
 validateForm();