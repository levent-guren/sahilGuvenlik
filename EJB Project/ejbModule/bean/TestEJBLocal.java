package bean;

import jakarta.ejb.Local;

@Local
public interface TestEJBLocal {
	public int topla(int sayi1, int sayi2);
}
