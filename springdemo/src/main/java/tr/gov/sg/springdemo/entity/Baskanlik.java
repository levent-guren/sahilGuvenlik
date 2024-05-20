package tr.gov.sg.springdemo.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;

@Entity
@Data
@Table
@ToString(exclude = { "personeller" })
public class Baskanlik {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String ad;
	private String il;

	@OneToMany(mappedBy = "baskanlik")
	private List<Personel> personeller;
}
