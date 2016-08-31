var cdt;
function ycdialog(fid){
	var dialog = $('<div title="Confirm">Are you sure?</div>').dialog({
		autoOpen: false,
        modal: true,
    buttons: {
    	"Cancel":  function() {
            dialog.dialog('close');
        },
        "Yes": function() {
        	dialog.dialog('close');
        	document.getElementById(fid).submit();
        	}
    }
});
	dialog.dialog('open');
}
function ddialog(id){
	var dialog = $('#'+id).dialog({
		autoOpen: false,
        modal: true,
        width: 270,
        height: 550,
        //minWidth: 270,
        //maxWidth: 700,
        resizable: false,
        //maxHeight: 500,
        dialogClass: 'ui-dg'
        
    
});
	dialog.dialog('open');
}
function test(){
	var d=new Date();
	var ed=new Date('2015/6/26');
	var t=ed.getTime()-d.getTime();
	d.setTime(t);
	alert(d);
}
function msgbox(msg){
	if(msg!=''){
		var dialog = $('<div title="Message">'+ msg + '</div>').dialog({
			autoOpen: false,
	        modal: true,
	    buttons: {
	    	"OK":  function() {
	            dialog.dialog('close');
	    	}
	    }
	});
		dialog.dialog('open');
	}
}
function timers(id,edt){
	var d=new Date();
	var ed=new Date(edt);
	var t=ed.getTime()-d.getTime();
	d.setTime(t-7*3600000);
	getid(id).innerHTML= d + "";
	if(t<1000) clearInterval(cdt);
}
function countdownTimer(id,edt){
	cdt = setInterval(timers, 1000,id,edt);
	//alert("ok?");
}

function getid(id){
	return document.getElementById(id);
}
function valreg(id,ider,field){
	var name=getid(id).value.trim();
	if(name.length>=6 && name.length<=15){
		var regex=/^[a-zA-Z0-9]+$/;
		if (!regex.test(name)){
			getid(ider).innerHTML=field+" must be alphanumeric with no spaces";
			return false;
		}
		getid(ider).innerHTML="";
		getid(id).value=name;
		return true;
	}
	else if(name==""){
		getid(ider).innerHTML=field+" cannot empty";
		return false;
	}
	else{
		getid(ider).innerHTML=field+" must be between 6 and 15 characters long";
		return false;
	}
	
}
function valid(){
	return valreg("ipid","ider","Username");
}
function valpass(){
	return valreg("ippass","passer","Password");
}
function valrepass(){
	var pass=getid("ippass").value.trim();
	var repass=getid("iprps").value.trim();
	if(repass!=pass){
		getid("rpser").innerHTML="Password not the same";
		return false;
	}
	getid("rpser").innerHTML="";
	return true;
}
function valemail(){
	var email=getid("ipemail").value.trim();
	if(email.length>0){
		var regex=/^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,4}$/;
		if (!regex.test(email)){
			getid("emailer").innerHTML="Email Invalid";
			return false;
		}
		getid("emailer").innerHTML="";
		return true;
	}
	getid("emailer").innerHTML="Email cannot empty";
	return false;
}
function chkformrs(){
	chkid=valid();
	chkpass=valpass();
	chkrepass=valrepass();
	chkemail=valemail();
	return chkid && chkpass && chkrepass && chkemail;
}
function chkformcs(){
	chkcname=valcname();
	chkdesc=valdesc();
	return chkcname && chkdesc;
}
function valcname(){
	return validname("ipcname","cnamer",5,30,"Category Name");
}
function valdesc(){
	return true;
}
function validname(ipname,nameer,ml,mxl,field){
	var name=getid(ipname).value.trim();
	if(name.length>=ml && name.length<=mxl){
		var regex=/^[a-zA-Z ]+$/;
		if (!regex.test(name)){
			getid(nameer).innerHTML=field+" must be alphabetic with any spaces";
			return false;
		}
		getid(nameer).innerHTML="";
		getid(ipname).value=name;
		return true;
	}
	else if(name==""){
		getid(nameer).innerHTML=field+" cannot empty";
		return false;
	}
	else{
		getid(nameer).innerHTML=field+" must be between "+ml+" and "+mxl+" characters long";
		return false;
	}
}
function validfname(){
	return validname("ipfname","fnameer",3,15,"First Name");
}
function validlname(){
	return validname("iplname","lnameer",2,15,"Last Name");
}
function validbday(){
	var date=getid("ipbirthday").value.trim();
	if(date.length>0){
		var rg1 = /^(0?[1-9]|[12]\d|30)\/(0?[13-9]|1[0-2])\/((19|20)\d\d)$/;
		var rg2 = /^(31)\/(0?[13578]|1[02])\/((19|20)\d\d)$/;
		var rg3 = /^(0?[1-9]|1\d|2[0-8])\/(02|2)\/((19|20)\d\d)$/;
		var rg4 = /^(29)\/(02|2)\/(((19|20)(0[48]|[13579][26]|[2468][480]))|2000)$/;
		if (rg1.test(date) || rg2.test(date) || rg3.test(date) || rg4.test(date)){
			cyear=new Date().getFullYear();
			iyear=date.substr(date.length-4,4);
			if(cyear-iyear<18){
				getid("birthdayer").innerHTML="chưa đủ 18 tuổi";
				return false;
			}
			getid("birthdayer").innerHTML="";
			getid("ipbirthday").value=date;
			return true;
			
		}
		getid("birthdayer").innerHTML="dd/MM/yyyy";
		return false;
	}
	else {
		getid("birthdayer").innerHTML="";
		return true;
	}
}
function chkeform(){
	chkfname=validfname();
	chklname=validlname();
	//chkbday=validbday();
	return chkfname && chklname && chkbday;
}
function chkforms(){
	//chkid=valid();
	chkid=true;
	chkef=chkeform();
	return chkid && chkef;
}
function classtoggle(id,classname){
	var re = new RegExp(classname, "g");
	if(getid(id).className.match(re)){
		getid(id).className=getid(id).className.replace( re , '' );
		return 0;
	}else{
		getid(id).className+=(" "+classname);
		return 1;
	}
}
function searchtoggle(){
	if(classtoggle("search-container","hide")==0)
		getid("sf-s").focus();
	
}
function menutoggle(){	
	classtoggle("primary-navigation","toggled-on");		
}
function togglecat(id){
	classtoggle(id,"cat_item_children");
}
