package bean;

import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;

/**
 * Session Bean implementation class TestEJB
 */
@Stateless
@LocalBean
public class TestEJB implements TestEJBRemote, TestEJBLocal {

	public TestEJB() {
	}

	public int topla(int sayi1, int sayi2) {
		return sayi1 + sayi2;
	}
}
