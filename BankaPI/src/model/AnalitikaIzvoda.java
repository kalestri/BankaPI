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
@Table(name = "AnalitikaIzvoda")
public class AnalitikaIzvoda {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "broj_stavke", columnDefinition="INT", unique = true, nullable = false)
	private Integer brojStavke;
	
	@Column(name = "duznik", columnDefinition="VARCHAR(256)",length=256, unique = false, nullable = false)
	private String duznik;
	
	@Column(name = "poverilac", columnDefinition="VARCHAR(256)",length=256, unique = false, nullable = false)
	private String poverilac;
	
	@Column(name = "svrha_placanja", columnDefinition="VARCHAR(256)",length=256, unique = false, nullable = false)
	private String svrhaPlacanja;
	
	@Column(name = "datum_prijema", columnDefinition="DATE",  unique = false, nullable = false)
	private Date datumPrijema;
	
	@Column(name = "datum_valute", columnDefinition="DATE",  unique = false, nullable = false)
	private Date datumValute;
	
	@Column(name = "racun_duznika", columnDefinition="VARCHAR(20)",length=20, unique = false, nullable = true)
	private String racunDuznika;
	
	@Column(name = "model_zaduzenja", columnDefinition="CHAR(2)", unique = false, nullable = true)
	private Integer modelZaduzenja;
	
	@Column(name = "poziv_na_broj_zaduzenja", columnDefinition="VARCHAR(20)",length=20, unique = false, nullable = true)
	private String pozivNaBrojZaduzenja;
	
	@Column(name = "racun_poverioca", columnDefinition="VARCHAR(20)",length=20, unique = false, nullable = true)
	private String racunPoverioca;
	
	@Column(name = "model_odobrenja", columnDefinition="CHAR(2)", unique = false, nullable = true)
	private Integer modelOdobrenja;
	
	@Column(name = "poziv_na_broj_odobrenja", columnDefinition="VARCHAR(20)",length=20, unique = false, nullable = true)
	private String pozivNaBrojOdobrenja;
	
	@Column(name = "hitno", columnDefinition="BIT", unique = false, nullable = false)
	private Boolean hitno;
	
	@Column(name = "iznos", columnDefinition="DECIMAL(15,2)", unique = false, nullable = false)
	private Float iznos;
	
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "smer", columnDefinition="CHAR(1)", unique = false, nullable = false)
	private Integer smer;
	
	@Column(name = "tip_greske", columnDefinition="CHAR(1)", unique = false, nullable = false)
	private Integer tipGreske;
	
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "status", columnDefinition="CHAR(1)", unique = false, nullable = false)
	private Integer status;
	
	@ManyToOne
	@JoinColumn(name = "broj_izvoda", referencedColumnName = "broj_izvoda", nullable = true)
	private DnevnoStanjeRacuna analitikaIzvodaBanke;
	
	@ManyToOne
	@JoinColumn(name = "sifra_mesta", referencedColumnName = "sifra_mesta", nullable = true)
	private NaseljenoMesto mestoPrijema;
	
	@ManyToOne
	@JoinColumn(name = "oznaka_vrste", referencedColumnName = "oznaka_vrste", nullable = true)
	private VrstePlacanja vrstaPlacanja;
	
	@ManyToOne
	@JoinColumn(name = "sifra_valute", referencedColumnName = "sifra_valute", nullable = true)
	private Valute valutaPlacanja;

	public AnalitikaIzvoda() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AnalitikaIzvoda(Integer brojStavke, String duznik, String poverilac,
			String svrhaPlacanja, Date datumPrijema, Date datumValute,
			String racunDuznika, Integer modelZaduzenja,
			String pozivNaBrojZaduzenja, String racunPoverioca,
			Integer modelOdobrenja, String pozivNaBrojOdobrenja, Boolean hitno,
			Float iznos, Integer smer, Integer tipGreske, Integer status,
			DnevnoStanjeRacuna analitikaIzvodaBanke,
			NaseljenoMesto naseljenoMesto, VrstePlacanja vrstaPlacanja,
			Valute valutaPlacanja) {
		super();
		this.brojStavke = brojStavke;
		this.duznik = duznik;
		this.poverilac = poverilac;
		this.svrhaPlacanja = svrhaPlacanja;
		this.datumPrijema = datumPrijema;
		this.datumValute = datumValute;
		this.racunDuznika = racunDuznika;
		this.modelZaduzenja = modelZaduzenja;
		this.pozivNaBrojZaduzenja = pozivNaBrojZaduzenja;
		this.racunPoverioca = racunPoverioca;
		this.modelOdobrenja = modelOdobrenja;
		this.pozivNaBrojOdobrenja = pozivNaBrojOdobrenja;
		this.hitno = hitno;
		this.iznos = iznos;
		this.smer = smer;
		this.tipGreske = tipGreske;
		this.status = status;
		this.analitikaIzvodaBanke = analitikaIzvodaBanke;
		this.mestoPrijema = naseljenoMesto;
		this.vrstaPlacanja = vrstaPlacanja;
		this.valutaPlacanja = valutaPlacanja;
	}

	public Integer getBrojStavke() {
		return brojStavke;
	}

	public void setBrojStavke(Integer brojStavke) {
		this.brojStavke = brojStavke;
	}

	public String getDuznik() {
		return duznik;
	}

	public void setDuznik(String duznik) {
		this.duznik = duznik;
	}

	public String getPoverilac() {
		return poverilac;
	}

	public void setPoverilac(String poverilac) {
		this.poverilac = poverilac;
	}

	public String getSvrhaPlacanja() {
		return svrhaPlacanja;
	}

	public void setSvrhaPlacanja(String svrhaPlacanja) {
		this.svrhaPlacanja = svrhaPlacanja;
	}

	public Date getDatumPrijema() {
		return datumPrijema;
	}

	public void setDatumPrijema(Date datumPrijema) {
		this.datumPrijema = datumPrijema;
	}

	public Date getDatumValute() {
		return datumValute;
	}

	public void setDatumValute(Date datumValute) {
		this.datumValute = datumValute;
	}

	public String getRacunDuznika() {
		return racunDuznika;
	}

	public void setRacunDuznika(String racunDuznika) {
		this.racunDuznika = racunDuznika;
	}

	public Integer getModelZaduzenja() {
		return modelZaduzenja;
	}

	public void setModelZaduzenja(Integer modelZaduzenja) {
		this.modelZaduzenja = modelZaduzenja;
	}

	public String getPozivNaBrojZaduzenja() {
		return pozivNaBrojZaduzenja;
	}

	public void setPozivNaBrojZaduzenja(String pozivNaBrojZaduzenja) {
		this.pozivNaBrojZaduzenja = pozivNaBrojZaduzenja;
	}

	public String getRacunPoverioca() {
		return racunPoverioca;
	}

	public void setRacunPoverioca(String racunPoverioca) {
		this.racunPoverioca = racunPoverioca;
	}

	public Integer getModelOdobrenja() {
		return modelOdobrenja;
	}

	public void setModelOdobrenja(Integer modelOdobrenja) {
		this.modelOdobrenja = modelOdobrenja;
	}

	public String getPozivNaBrojOdobrenja() {
		return pozivNaBrojOdobrenja;
	}

	public void setPozivNaBrojOdobrenja(String pozivNaBrojOdobrenja) {
		this.pozivNaBrojOdobrenja = pozivNaBrojOdobrenja;
	}

	public Boolean getHitno() {
		return hitno;
	}

	public void setHitno(Boolean hitno) {
		this.hitno = hitno;
	}

	public Float getIznos() {
		return iznos;
	}

	public void setIznos(Float iznos) {
		this.iznos = iznos;
	}

	public Integer getSmer() {
		return smer;
	}

	public void setSmer(Integer smer) {
		this.smer = smer;
	}

	public Integer getTipGreske() {
		return tipGreske;
	}

	public void setTipGreske(Integer tipGreske) {
		this.tipGreske = tipGreske;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public DnevnoStanjeRacuna getDnevnoStanjeRacuna() {
		return analitikaIzvodaBanke;
	}

	public void setDnevnoStanjeRacuna(DnevnoStanjeRacuna dnevnoStanjeRacuna) {
		this.analitikaIzvodaBanke = dnevnoStanjeRacuna;
	}

	public NaseljenoMesto getNaseljenoMesto() {
		return mestoPrijema;
	}

	public void setNaseljenoMesto(NaseljenoMesto naseljenoMesto) {
		this.mestoPrijema = naseljenoMesto;
	}

	public VrstePlacanja getVrstaPlacanja() {
		return vrstaPlacanja;
	}

	public void setVrstaPlacanja(VrstePlacanja vrstaPlacanja) {
		this.vrstaPlacanja = vrstaPlacanja;
	}

	public Valute getValuta() {
		return valutaPlacanja;
	}

	public void setValuta(Valute valuta) {
		this.valutaPlacanja = valuta;
	}
}
