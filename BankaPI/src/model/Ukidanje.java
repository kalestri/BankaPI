package model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "Ukidanje")
public class Ukidanje {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", columnDefinition="INT", unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "datum_ukidanja", columnDefinition="DATE", unique = false, nullable = false)
	private Date datumUkidanja;
	
	@Column(name = "racun_za_prenos", columnDefinition="VARCHAR(20)", unique = false, nullable = false)
	private String racunZaPrenos;
	
	@ManyToOne
	@JoinColumn(name = "broj_racuna", referencedColumnName = "broj_racuna", nullable = false)
	private RacuniPravnihLica ukidanjeRacuna;
	
	

	public Ukidanje() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Ukidanje(Integer id, Date datumUkidanja, String racunZaPrenos,
			RacuniPravnihLica ukidanjeRacuna) {
		super();
		this.id = id;
		this.datumUkidanja = datumUkidanja;
		this.racunZaPrenos = racunZaPrenos;
		this.ukidanjeRacuna = ukidanjeRacuna;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDatumUkidanja() {
		return datumUkidanja;
	}

	public void setDatumUkidanja(Date datumUkidanja) {
		this.datumUkidanja = datumUkidanja;
	}

	public String getRacunZaPrenos() {
		return racunZaPrenos;
	}

	public void setRacunZaPrenos(String racunZaPrenos) {
		this.racunZaPrenos = racunZaPrenos;
	}

	public RacuniPravnihLica getUkidanjeRacuna() {
		return ukidanjeRacuna;
	}

	public void setUkidanjeRacuna(RacuniPravnihLica ukidanjeRacuna) {
		this.ukidanjeRacuna = ukidanjeRacuna;
	}
	
	
}
