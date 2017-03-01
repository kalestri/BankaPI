package model;

public class PravnaLica {

	private int pib;
	private String naziv;
	private String adresa;
	private String email;
	private String webSite;
	private int telefon;
	private int fax;
	private String banka;
	
	
	public PravnaLica(int pib, String naziv, String adresa, String email, String webSite, int telefon, int fax,
			String banka) {
		super();
		this.pib = pib;
		this.naziv = naziv;
		this.adresa = adresa;
		this.email = email.toLowerCase();
		this.webSite = webSite;
		this.telefon = telefon;
		this.fax = fax;
		this.banka = banka;
	}


	public int getPib() {
		return pib;
	}


	public void setPib(int pib) {
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


	public int getTelefon() {
		return telefon;
	}


	public void setTelefon(int telefon) {
		this.telefon = telefon;
	}


	public int getFax() {
		return fax;
	}


	public void setFax(int fax) {
		this.fax = fax;
	}


	public String getBanka() {
		return banka;
	}


	public void setBanka(String banka) {
		this.banka = banka;
	}
	
}
