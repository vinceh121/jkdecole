package jkdecole;

import java.awt.HeadlessException;
import java.io.IOException;

import javax.swing.JOptionPane;

import org.apache.http.client.ClientProtocolException;
import org.junit.Test;

import me.vinceh121.jkdecole.Endpoints;
import me.vinceh121.jkdecole.JKdecole;

public class LoginTest {

	@Test
	public void test() throws HeadlessException, ClientProtocolException, IOException {
		final JKdecole api = new JKdecole();
		api.setEndpoint(Endpoints.getEndpoint("EN"));
		api.login(JOptionPane.showInputDialog("Username"), JOptionPane.showInputDialog("Password (visible)"), true);
		System.out.println("Token: " + api.getToken());
		System.out.println("You have " + api.getNumberOfUnreadEmails() + " unread emails");
	}

}
