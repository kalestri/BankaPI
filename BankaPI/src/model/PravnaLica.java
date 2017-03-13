package model;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.LAZY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PravnaLica")
public class PravnaLica {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "pib", columnDefinition="INT", unique = true, nullable = false)
	private Integer pib;
	
	@Column(name = "naziv", columnDefinition="VARCHAR(120)", unique = false, nullable = false)
	private String naziv;
	
	@Column(name = "adresa", columnDefinition="VARCHAR(120)", unique = false, nullable = false)	
	private String adresa;
	
	@Column(name = "email", columnDefinition="VARCHAR(128)", unique = false, nullable = true)
	private String email;
	
	@Column(name = "webSite", columnDefinition="VARCHAR(128)", unique = false, nullable = true)
	private String webSite;
	
	@Column(name = "telefon", columnDefinition="VARCHAR(20)", unique = false, nullable = true)
	private Integer telefon;
	
	@Column(name = "fax", columnDefinition="VARCHAR(20)", unique = false, nullable = true)
	private Integer fax;
	
	@Column(name = "banka", columnDefinition="BIT", unique = false, nullable = false)
	private Boolean banka;
	
	@OneToMany(cascade = { ALL }, fetch = LAZY, mappedBy = "poslovnaBanka")
	private Set<RacuniPravnihLica> poslovnaBanka = new HashSet<RacuniPravnihLica>();
	
	@OneToMany(cascade = { ALL }, fetch = LAZY, mappedBy = "vlasnikRacuna")
	private Set<RacuniPravnihLica> vlasnikRacuna = new HashSet<RacuniPravnihLica>();
	
	@OneToMany(cascade = { ALL }, fetch = LAZY, mappedBy = "pravnoLice")
	private Set<KodoviBanke> kodBanke = new HashSet<KodoviBanke>();
	
	@OneToMany(cascade = { ALL }, fetch = LAZY, mappedBy = "pravnoLice")
	private Set<KursnaLista> kursPoslovneBanke = new HashSet<KursnaLista>();
	
	

	public PravnaLica() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PravnaLica(Integer pib, String naziv, String adresa, String email,
			String webSite, Integer telefon, Integer fax, Boolean banka,
			Set<RacuniPravnihLica> poslovnaBanka,
			Set<RacuniPravnihLica> vlasnikRacuna, Set<KodoviBanke> kodBanke,
			Set<KursnaLista> kursPoslovneBanke) {
		super();
		this.pib = pib;
		this.naziv = naziv;
		this.adresa = adresa;
		this.email = email;
		this.webSite = webSite;
		this.telefon = telefon;
		this.fax = fax;
		this.banka = banka;
		this.poslovnaBanka = poslovnaBanka;
		this.vlasnikRacuna = vlasnikRacuna;
		this.kodBanke = kodBanke;
		this.kursPoslovneBanke = kursPoslovneBanke;
	}

	public Integer getPib() {
		return pib;
	}

	public void setPib(Integer pib) {
		this.pib = pib;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWebSite() {
		return webSite;
	}

	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}

	public Integer getTelefon() {
		return telefon;
	}

	public void setTelefon(Integer telefon) {
		this.telefon = telefon;
	}

	public Integer getFax() {
		return fax;
	}

	public void setFax(Integer fax) {
		this.fax = fax;
	}

	public Boolean getBanka() {
		return banka;
	}

	public void setBanka(Boolean banka) {
		this.banka = banka;
	}

	public Set<RacuniPravnihLica> getPoslovnaBanka() {
		return poslovnaBanka;
	}

	public void setPoslovnaBanka(Set<RacuniPravnihLica> poslovnaBanka) {
		this.poslovnaBanka = poslovnaBanka;
	}

	public Set<RacuniPravnihLica> getVlasnikRacuna() {
		return vlasnikRacuna;
	}

	public void setVlasnikRacuna(Set<RacuniPravnihLica> vlasnikRacuna) {
		this.vlasnikRacuna = vlasnikRacuna;
	}

	public Set<KodoviBanke> getKodBanke() {
		return kodBanke;
	}

	public void setKodBanke(Set<KodoviBanke> kodBanke) {
		this.kodBanke = kodBanke;
	}

	public Set<KursnaLista> getKursPoslovneBanke() {
		return kursPoslovneBanke;
	}

	public void setKursPoslovneBanke(Set<KursnaLista> kursPoslovneBanke) {
		this.kursPoslovneBanke = kursPoslovneBanke;
	}
	
	
	
	
}
