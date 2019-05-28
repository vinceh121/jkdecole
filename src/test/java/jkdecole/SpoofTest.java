package jkdecole;

import org.junit.Test;

import me.vinceh121.jkdecole.Endpoints;
import me.vinceh121.jkdecole.JKdecole;

public class SpoofTest {

	@Test
	public void test() {
		JKdecole api = new JKdecole();
		api.setEndpoint(Endpoints.getEndpoint("EN"));
		for (int i = 0; i < Integer.MAX_VALUE; i++) {
			api.setIdEtablissement(Integer.toString(i));
			System.out.print("Id: " + i + ": ");
			try {
				System.out.println(api.getNumberOfUnreadEmails());
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}
	}

}
