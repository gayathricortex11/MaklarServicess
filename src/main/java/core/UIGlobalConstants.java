package core;

public class UIGlobalConstants {
	public static String BROWSER = browse();
	 public static String browse(){
	  	String default_browser = "chrome";
	 	try{
			if(!System.getProperty("browser").equals(null)){
			  	BROWSER = System.getProperty("browser").toString();
			  	} 	
			  	}catch(NullPointerException e){
			  		BROWSER = default_browser;
			  	}catch(ExceptionInInitializerError e){
			  		BROWSER = default_browser;	
			  	}
			return BROWSER;
			}
	 public static String country =site(); 
		public static String site(){
	        String defaultSite = "https://vardrapport.herokuapp.com/";
		    return defaultSite;
		}
		
		public static String uiBaseUrl = "https://vardrapport.herokuapp.com/";
		public static String CHROMEpATH = "C:\\chromedriver.exe";
		public static String UserName="gayathri.balagopal@cortexcraft.com";
		public static String Password="venkigayu";
		
		public static int index=getIndex();
		public static int getIndex(){
			int index=-1;
			uiBaseUrl.contains("https://vardrapport.herokuapp.com/");
				index=0; //Sweden
			return index;
		}
		
		public static String[] RegisterMyAccount={"Registrer ny konto","Registrera nytt konto"};
		public static String[] RegistrationEmailSubjectText={"Registrering Ikano DK","Registrering Ikano Klipp"};
		public static String[] forgotPasswordEmailSubjectText={"Skift adgangskode Ikano Bank Fordelsprogram","Återställ lösenord Ikano Klipp"};
		public static String[] loginText={"Log ind","Logga in"};
		public static String[] mypages={"MINE SIDER","MINA SIDOR"};
		public static String[] logout={"Log ud","Logga ut"};
		public static String[] ErrorMessageForWrongCredentialsInLoginForm={"Log ind mislykkedes. Tjek at du har indtastet de rigtige oplysninger og forsøg igen","Ogiltligt användarnamn eller lösenord."};
		public static String[] logoText={"Penge tilbage når du handler på nettet!","Nya klipp varje dag!"};
		public static String[] placeholderTextOfSearchBox={"Søg rabatkoder, tilbud, butikker","sök rabattkoder, erbjudanden, butiker, ..."};
		public static String[] homeTextInMenuBar={"Hjem","Hem"};
		public static String[] categoryTextInMenuBar={"kategorier","Kategorier"};
		public static String[] buttikerTextInMenuBar={"butikker","Butiker"};
		public static String[] loginsignupTextInMenuBar={"Log ind, opret konto","Logga in, registrera dig"};
		public static String[] forgotPasswordText={"Glemt adgangskode","Glömt lösenord"};
		public static String[] forgotYourPasswordText={"Glemt din adgangskode","Glömt ditt lösenord"};
		public static String[] loginIntoYourAccountText={"Log ind på din konto","Logga in på ditt konto"};
		public static String[] resetPasswordButton={"Skift adgangskode","Återställ lösenord"};
		public static String[] successMessageForSendingEmailOfForgotPassword={"E-mail for at ændre adgangskode er blevet sendt","E-mail för att ändra lösenord har skickats"};
		
		
		//reset password page
		public static String[] chooseAPasswordText={"Vælg en adgangskode","Välj ett lösenord"};
		public static String[] confirmNewPasswordText={"Bekræft adgangskode","Bekräfta lösenord"};
		public static String[] sendText={"Send","Skicka"};
		public static String[] errorMessageForPasswordDoesntMatch={"Adgangskoderne er ikke ens","Lösenorden matchar inte"};
		public static String[] successMessageAfterChangingThePassword={"Adgangskode ændret","Ditt lösenord är nu ändrat"};
		
		//Footer
		public static String[] howItWorksText={"Sådan fungerer det","Så funkar det"};
		public static String[] questionAnswersText={"FAQ","Vanliga frågor & svar"};
		public static String[] termsAndConditionsText={"Generelle vilkår","Allmänna villkor"};
		public static String[] policyText={"Fortrolighed","Sekretess"};
		public static String[] cookiesText={"Cookies","Cookies"};
		
		//support page
		public static String[] headingInSupportPage={"Kontakt","Skapa ärende"};
		public static String[] categoryLabel={"Type af henvendelse","Ämne"};
		public static String[] firstName={"Fornavn","Förnamn"};
		public static String[] lastName={"Efternavn","Efternamn"};
		public static String[] emaill={"E-Mail","Epost"};
		public static String[] description={"Beskrivelse","Beskrivning"};
		public static String[] attachFile={"Vedhæft ordrebekræftelse:","Bifoga orderbekräftelse:"};
		public static String[] attach={"Vedhæft","Bifoga"};
		public static String[] chooseFile={"Vælg fil","Välj fil"};
		public static String[] typeSecurityCode={"Indtast sikkerhedskode:","Skriv in säkerhetskoden:"};
		public static String[] getAnotherCapthca={"Få en anden CAPTCHA","Få en annan kombination"};
		
		//profile page
		public static String[] selectBankText={"Vælg bank","Välj bank"};
		public static String[] cashoutSuccessMessage={"Din bonus vil blive udbetalt til din bankkonto","Din återbäring kommer att betalas ut till ditt bankkonto"};
		public static String[] cashoutErrorMessageForLessThan50={"Udbetalingen er ikke mulig. Du skal have minimum 100 kr. i bekræftet bonus for at kunne gennemføre en udbetaling til din bankkonto.","Utbetalning är ej möjlig. Du behöver minst 100 kr i bekräftad återbäring på ditt konto för att kunna genomföra utbetalning till ditt bankkonto."};
		public static String[] newPasswordText={"Ny adgangskode","Nytt lösenord"};
		public static String[] confirmPasswordText={"Gentag adgangskode","Repetera lösenord"};
		public static String[] saveText={"Gem","SPARA"};
		public static String[] passwordNotMatchedErrorMessage={"Adgangskoderne er ikke ens","Lösenorden matchar inte"};
		public static String[] successMessageAfterChangingPasswordInProfilePage={"Adgangskoden er ændret","Lösenord har ändrats"};
		public static String[] contactInfoText={"kontaktoplysninger","Kontaktuppgifter"};
		public static String[] contactDetailsUpdatedSuccessMessage={"Kontaktoplysninger opdateret","Kontouppgifter uppdaterade"};
		public static String[] firstNameText={"Fornavn","Förnamn"};
		public static String[] lastNameText={"Efternavn","Efternamn"};
		public static String[] mobileText={"Mobil","Mobil"};
		public static String[] address={"adresse","Adress"};
		public static String[] postNumber={"postnummer","Postnr"};
		public static String[] town={"by","Ort"};
		public static String[] newsLetter={"nyhedsbrev","Nyhetsbrev"};
		public static String[] newsLetterCheckboxStaticText={"Jeg ønsker nyhedsbrevet og rabatter","jag vill ha nyhetsbrev med erbjudanden och rabatter"};
		
		
		
		
		
		
		
}
