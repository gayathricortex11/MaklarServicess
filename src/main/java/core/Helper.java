package core;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.ContentType;
import javax.mail.internet.MimeMultipart;

public class Helper {
	/*
     * This method returns the link which matches the content form the html string
     */
    public static String getLinkWithContentInMail( String subject,String linkContent, String accountName ,String passWord) throws Exception{
         String mailContent = getMail( subject,  accountName , passWord);
         String s = mailContent.replaceAll("\"", " ");
            // separete input by spaces ( URLs don't have spaces )
            String [] parts = s.split("\\s");
	        // Attempt to convert each item into an URL.   
	        for( String item : parts )
	        try {
	            URL url = new URL(item);
	            // If possible then replace with anchor...
	            if(url.toString().contains(linkContent))
	             return url.toString();    
	        } catch (MalformedURLException e) {
	            // If there was an URL that was not it!...
	           // System.out.print( item + " " );
	        }
		 return null;
	}
    /*
	 * @Desc: This function is used to connect to gmail and search the mail with subject in gmail account
	 */
     public static String getMail( String subject, String accountName ,String passWord) throws Exception{
            System.out.println("Searching for Email with subject:"+subject.trim());
            Properties props = System.getProperties();
            props.setProperty("mail.store.protocol", "imaps");
            Session session = Session.getDefaultInstance(props, null);
            Store store = session.getStore("imaps");
            try {
                        store.connect("imap.gmail.com",accountName, passWord);
                        //store.connect("dev.slando.com",993, "build", "Ruo7aidu1maNgoovailahngai");
                        //System.out.println(store);
                        /*
                         * If the mail is found then the loop below terminates with the return statement
                         * If the mail is not in the in box then it pauses for few seconds and check again
                         * It repeats for 20 times before it confirms that there is not mail in the inbox
                         */
                        for( int count=0; count<60;){
                                Folder inbox = store.getFolder("Inbox");
                                inbox.open(Folder.READ_WRITE);
                                Message messages[] = inbox.getMessages();
                                System.out.println(messages.length);
                                /*
                                 * this for loop Starts with the latest mails in the inbox and goes on.
                                 */
                                for (int i=messages.length-1;i>=0; i--) {
                                    //System.out.print(messages[i].getSubject());
                                    //This if condition checks for the mail with the given subject
                                	System.out.println(messages[i].getSubject());
                                    if(messages[i].getSubject().contains(subject)){
                                        System.out.println(i + ": " + messages[i].getFrom()[0]+ "\t" + messages[i].getSubject());
                                        //System.out.println(messages[i].getContent());
                                        String contentStr = null;
                                         ContentType ct = new ContentType(messages[i].getContentType() );
                                        if(ct.getPrimaryType().equals("multipart")) {
                                            contentStr = getMultiPart(messages[i]);
                                        } else {
                                            contentStr = messages[i].getContent().toString();
                                        }
                                        return messages[i].getSubject().toString()+ " " + contentStr;
                                    }
                                }
                                Action.waitTill(200);
                                count++;
                        return "";
                    }
                } catch (NoSuchProviderException e) {
                    e.printStackTrace();
                    return "";
                } catch (MessagingException e) {
                    e.printStackTrace();
                    return "";
                }
                catch(NullPointerException e)
                {
                    System.out.println("in null catch");
                }
                catch (Exception e) {
                    System.out.println("The error is " + e.toString());
                    return "";
                }
                finally{
                    store.close();
                }
                return "";
    }
     
     /*
      * @Author : 
      * @Desc: getMultiPart is used to get MultiPart content
      */
      public static String getMultiPart(Message m) {
      StringBuffer stringBuffer = new StringBuffer();
      try {
      MimeMultipart content = ( MimeMultipart )m.getContent();
      for( int i = 0; i < content.getCount(); i++ ) {
      BodyPart part = content.getBodyPart( i );
      stringBuffer.append(part.getContent());
      }
      }
      catch(Exception e) {
      e.printStackTrace();
      }
      return stringBuffer.toString();
      }
      
      /*
       * @Desc: This function is used to delete the email in gmail account with subject
       */
      public static String deleteEmail( String subject,String accountName,String passWord) throws Exception{
      System.out.println("Deleting Email with subject:"+subject);
      Properties props = System.getProperties();
      props.setProperty("mail.store.protocol", "imaps");
      try {
      Session session = Session.getDefaultInstance(props, null);
      Store store = session.getStore("imaps");
      store.connect("imap.gmail.com",accountName.trim(),passWord.trim());
      //store.connect("dev.slando.com",993, "build", "Ruo7aidu1maNgoovailahngai");
      //System.out.println(store);
      Folder inbox = store.getFolder("Inbox");
      inbox.open(Folder.READ_WRITE);
      Message messages[] = inbox.getMessages();
      int count=0;
      for (int i=messages.length-1; i>=0; i--) {
      	count++;
      	if(count==20)
      		break;
      if(messages[i].getSubject().replace(" ","").contains(subject.replace(" ",""))){
            //System.out.println(i + ": " + messages[i].getFrom()[0]+ "\t" + messages[i].getSubject());
            //System.out.println(messages[i].getContent());
            messages[i].setFlag(Flags.Flag.DELETED, true);
      }
      }
      } catch (NoSuchProviderException e) {
      e.printStackTrace();
      System.out.println("Error");
      //System.exit(1);
      } catch (MessagingException e) {
      e.printStackTrace();
      System.out.println("Error");
      //System.exit(2);
      } catch (Exception e) {
      System.out.println("The error is " + e.toString());
      return "";
      }
      return "";
      }
      
    public static void log(String msg){
  		System.out.println(msg);
  	}
}
