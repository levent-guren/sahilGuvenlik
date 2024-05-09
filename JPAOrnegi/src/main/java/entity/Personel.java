package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "employees")
@Data
@NamedQuery(name = "Personel.tumPersoneller", query = "select p from Personel p")
public class Personel {
	@Id
	@Column(name = "employee_id")
	private int id;
	@Column(name = "first_name")
	private String adi;
	@Column(name = "last_name")
	private String lastName;
}
