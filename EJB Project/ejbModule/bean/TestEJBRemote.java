package bean;

import jakarta.ejb.Remote;

@Remote
public interface TestEJBRemote {
	public int topla(int sayi1, int sayi2);
}
