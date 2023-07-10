package jsp15_java_mail;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class GoogleMailAuthenticator extends Authenticator {
	private PasswordAuthentication passwordAuthentication;

	public GoogleMailAuthenticator() {
		passwordAuthentication = new PasswordAuthentication("definitionhyo", "hekjbdgpfuebugjc");
	}

	@Override
	protected PasswordAuthentication getPasswordAuthentication() {
		return passwordAuthentication;
	}
	
	
	
	
	

}
