//register
$( "#register" ).on( "submit", function( event ) {
	chkid=valreg("ipid","ider","Username");
	chkpass=valreg("ippass","passer","Password");
	chkrepass=valrepass();
	chkemail=valemail();
	return chkid && chkpass && chkrepass && chkemail;
	});
$( "#ipid" ).on( "blur", function( event ) {
	valreg("ipid","ider","Username");
	});
$( "#ipemail" ).on( "blur", function( event ) {
	valemail();
	});
$( "#ippass" ).on( "blur", function( event ) {
	valreg("ippass","passer","Password");
	});
$( "#iprps" ).on( "blur", function( event ) {
	valrepass();
	});
//--------