package model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.LAZY;

@Entity
@Table(name = "KursnaLista")
public class KursnaLista {

	@Id
	@Column(name = "datum", columnDefinition="DATE", unique = true, nullable = false)
	private Date datum;
	
	@Column(name = "broj_kursne_liste", columnDefinition="CHAR(3)", unique = true, nullable = false)
	private Integer brojKursneListe;
	
	@Column(name = "primenjuje_se_od", columnDefinition="DATE", unique = true, nullable = false)
	private Date primenjujeSeOd;
	
	@ManyToOne
	@JoinColumn(name = "pib", referencedColumnName = "pib", nullable = false)
	private PravnaLica pravnoLice;
	
	@OneToMany(cascade = { ALL }, fetch = LAZY, mappedBy = "valuteUListi")
	private Set<KursUValuti> kursUValuti = new HashSet<KursUValuti>();

	
	
	public KursnaLista() {
		super();
		// TODO Auto-generated constructor stub
	}

	public KursnaLista(Date datum, Integer brojKursneListe,
			Date primenjujeSeOd, PravnaLica pravnoLice,
			Set<KursUValuti> kursUValuti) {
		super();
		this.datum = datum;
		this.brojKursneListe = brojKursneListe;
		this.primenjujeSeOd = primenjujeSeOd;
		this.pravnoLice = pravnoLice;
		this.kursUValuti = kursUValuti;
	}

	public Date getDatum() {
		return datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public Integer getBrojKursneListe() {
		return brojKursneListe;
	}

	public void setBrojKursneListe(Integer brojKursneListe) {
		this.brojKursneListe = brojKursneListe;
	}

	public Date getPrimenjujeSeOd() {
		return primenjujeSeOd;
	}

	public void setPrimenjujeSeOd(Date primenjujeSeOd) {
		this.primenjujeSeOd = primenjujeSeOd;
	}

	public PravnaLica getPravnoLice() {
		return pravnoLice;
	}

	public void setPravnoLice(PravnaLica pravnoLice) {
		this.pravnoLice = pravnoLice;
	}

	public Set<KursUValuti> getKursUValuti() {
		return kursUValuti;
	}

	public void setKursUValuti(Set<KursUValuti> kursUValuti) {
		this.kursUValuti = kursUValuti;
	}
	
	
	
}
