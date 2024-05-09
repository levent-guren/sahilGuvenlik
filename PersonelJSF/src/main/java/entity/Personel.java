package entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
@Table
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

	@ManyToOne
	// @JoinColumn(name = "baskanlik_id", referencedColumnName = "id")
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
