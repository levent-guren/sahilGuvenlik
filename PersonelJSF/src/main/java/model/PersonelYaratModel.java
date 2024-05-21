package model;

import java.time.LocalDate;

import lombok.Data;

@Data
public class PersonelYaratModel {
	private String adi;
	private String soyadi;
	private Integer yas;
	private LocalDate iseGirisTarihi;
	private int baskanlikId;
	private String tcKimlikNo;
}
