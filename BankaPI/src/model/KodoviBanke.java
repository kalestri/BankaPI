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
@Table(name = "KodoviBanke")
public class KodoviBanke {

	@Id
	@Column(name = "sifra_banke", columnDefinition="INT", unique = true, nullable = false)
	private Integer sifraBanke;
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "swift_code", columnDefinition="CHAR(8)", unique = true, nullable = false)
	private Integer swiftCode;
	
	@ManyToOne
	@JoinColumn(name = "pib", referencedColumnName = "pib", nullable = false)
	private PravnaLica pravnoLice;

	
	
	public KodoviBanke() {
		super();
		// TODO Auto-generated constructor stub
	}

	public KodoviBanke(Integer sifraBanke, Integer swiftCode,
			PravnaLica pravnoLice) {
		super();
		this.sifraBanke = sifraBanke;
		this.swiftCode = swiftCode;
		this.pravnoLice = pravnoLice;
	}

	public Integer getSifraBanke() {
		return sifraBanke;
	}

	public void setSifraBanke(Integer sifraBanke) {
		this.sifraBanke = sifraBanke;
	}

	public Integer getSwiftCode() {
		return swiftCode;
	}

	public void setSwiftCode(Integer swiftCode) {
		this.swiftCode = swiftCode;
	}

	public PravnaLica getPravnoLice() {
		return pravnoLice;
	}

	public void setPravnoLice(PravnaLica pravnoLice) {
		this.pravnoLice = pravnoLice;
	}
	
	
	
	
}
