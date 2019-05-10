package jkdecole;

import javax.swing.JOptionPane;

import org.junit.Test;

import me.vinceh121.jkdecole.Endpoints;
import me.vinceh121.jkdecole.JKdecole;

public class LoginTest {

	@Test
	public void test() {
		JKdecole api = new JKdecole();
		api.setEndpoint(Endpoints.getEndpoint("EN"));
		api.login(JOptionPane.showInputDialog("Token: "));
		System.out.println(api.getCalendar().getDays()[0].getSessions()[1].getInSession()[0].getTitle());
	}

}
