package entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedNativeQueries;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.ToString;

@Entity
@Data
@Table(name = "personel")
@ToString(exclude = { "baskanlik" })
// DAO sınıflarında createQuery yerine createNamedQuery yazarak burada tanımlanan sorgunun name'i verilir ve buradaki sorgu kullanılmış olur.
// Böylece Personel üzerindeki tüm sorgular burada toplanmış olur.
@NamedQueries({
		@NamedQuery(name = "Personel.getPersonellerByBaskanlikId", query = "select p from Personel p where p.baskanlik.id = :baskanlikId"),
		@NamedQuery(name = "Personel.getPersoneller", query = "from Personel") })
@NamedNativeQueries({
		@NamedNativeQuery(name = "Personel.getPersonellerByBaskanlikIdNative", query = "sql", resultClass = Personel.class) })
public class Personel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull
	private String adi;

	@NotNull
	private String soyadi;

	@Column(name = "ise_giris")

	@NotNull

	@Temporal(TemporalType.DATE)
	private Date iseGiris;

	@Min(1)
	private Integer yas;

	@Column(name = "kayit_tarihi")

	@NotNull

	@Temporal(TemporalType.TIMESTAMP)
	private Date kayitTarihi;

	@Column(name = "son_guncelleme")

	@Temporal(TemporalType.TIMESTAMP)
	private Date sonGuncelleme;

	// @Size(min = 11, max = 11)
	@NotNull
	private String tcKimlikNo;

	@ManyToOne // @JoinColumn(name = "baskanlik_id", referencedColumnName = "id")
	private Baskanlik baskanlik;

	@PrePersist
	public void yeniKayit() {
		kayitTarihi = new Date();
	}

	@PreUpdate
	public void kayitGuncelleme() {
		sonGuncelleme = new Date();
	}

}