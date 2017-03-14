package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "KursUValuti")
public class KursUValuti {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "redni_broj", columnDefinition="INT", unique = true, nullable = false)
	private Integer redniBroj;
	
	@Column(name = "kupovni", columnDefinition="DECIMAL(9,4)", unique = false, nullable = false)
	private Float kupovni;
	
	@Column(name = "srednji", columnDefinition="DECIMAL(9,4)", unique = false, nullable = false)
	private Float srednji;
	
	@Column(name = "prodajni", columnDefinition="DECIMAL(9,4)", unique = false, nullable = false)
	private Float prodajni;
	
	@ManyToOne
	@JoinColumn(name = "datum", referencedColumnName = "datum", nullable = false)
	private KursnaLista valuteUListi;
	
	@ManyToOne
	@JoinColumn(name = "sifra_valute_osnovna", referencedColumnName = "sifra_valute", nullable = false)
	private Valute osnovnaValuta;
	
	@ManyToOne
	@JoinColumn(name = "sifra_valute_pv", referencedColumnName = "sifra_valute", nullable = false)
	private Valute premaValuti;
	
	

	public KursUValuti() {
		super();
		// TODO Auto-generated constructor stub
	}

	public KursUValuti(Integer redniBroj, Float kupovni, Float srednji,
			Float prodajni, KursnaLista valuteUListi, Valute osnovnaValuta,
			Valute premaValuti) {
		super();
		this.redniBroj = redniBroj;
		this.kupovni = kupovni;
		this.srednji = srednji;
		this.prodajni = prodajni;
		this.valuteUListi = valuteUListi;
		this.osnovnaValuta = osnovnaValuta;
		this.premaValuti = premaValuti;
	}

	public Integer getRedniBroj() {
		return redniBroj;
	}

	public void setRedniBroj(Integer redniBroj) {
		this.redniBroj = redniBroj;
	}

	public Float getKupovni() {
		return kupovni;
	}

	public void setKupovni(Float kupovni) {
		this.kupovni = kupovni;
	}

	public Float getSrednji() {
		return srednji;
	}

	public void setSrednji(Float srednji) {
		this.srednji = srednji;
	}

	public Float getProdajni() {
		return prodajni;
	}

	public void setProdajni(Float prodajni) {
		this.prodajni = prodajni;
	}

	public KursnaLista getValuteUListi() {
		return valuteUListi;
	}

	public void setValuteUListi(KursnaLista valuteUListi) {
		this.valuteUListi = valuteUListi;
	}

	public Valute getOsnovnaValuta() {
		return osnovnaValuta;
	}

	public void setOsnovnaValuta(Valute osnovnaValuta) {
		this.osnovnaValuta = osnovnaValuta;
	}

	public Valute getPremaValuti() {
		return premaValuti;
	}

	public void setPremaValuti(Valute premaValuti) {
		this.premaValuti = premaValuti;
	}
	
	
	
}
