package service;

import beans.Islem;

public class HesapService {
	public int hesapla(int sayi1, int sayi2, Islem islem) {
		int sonuc = 0;
		switch (islem) {
		case TOPLA:
			sonuc = sayi1 + sayi2;
			break;
		case CIKAR:
			sonuc = sayi1 - sayi2;
			break;
		case CARP:
			sonuc = sayi1 * sayi2;
			break;
		case BOL:
			sonuc = sayi1 / sayi2;
			break;
		}
		return sonuc;
	}
}
