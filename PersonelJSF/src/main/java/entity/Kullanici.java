package entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;

@Entity
@Data
public class Kullanici {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String tcNo;
	private String sifre;

	@ManyToMany
	// @formatter:off
	/*@JoinTable(name = "kullanici_yetki", 
				joinColumns = { @JoinColumn(name = "kullanici_id") }, 
				inverseJoinColumns = { @JoinColumn(name = "yetki_id") })*/
	// @formatter:on

	private List<Yetki> yetkiler;
}
