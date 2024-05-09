package beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hesap {
	private int sayi1;
	private int sayi2;
	private Islem islem;
}
