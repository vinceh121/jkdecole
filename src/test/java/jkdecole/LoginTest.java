package jkdecole;

import javax.swing.JOptionPane;

import org.junit.Test;

import me.vinceh121.jkdecole.Endpoints;
import me.vinceh121.jkdecole.JKdecole;

public class LoginTest {

	@Test
	public void test() {
		final JKdecole api = new JKdecole();
		api.setEndpoint(Endpoints.getEndpoint("EN"));
		api.login(JOptionPane.showInputDialog("Username"), JOptionPane.showInputDialog("Password (visible)"), true);
		System.out.println("You have " + api.getNumberOfUnreadEmails() + " unread emails");
	}

}
