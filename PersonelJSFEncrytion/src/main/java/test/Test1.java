package test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Test1 {
	public static void main(String[] args) {
		LocalDate d = LocalDate.now();
		DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		System.out.println(d.format(f));

		String s = "21/05/2024";
		LocalDate d1 = LocalDate.parse(s, f);
		System.out.println(d1);
	}
}
