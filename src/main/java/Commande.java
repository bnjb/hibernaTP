import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "COMMANDE",
  uniqueConstraints = { @UniqueConstraint(columnNames = { "COM_NO" }) })
public class Commande {

	private Integer comId;
	private Date comDate;
	private Date comHeure;
	
	private Set<Produit> produits = new HashSet<Produit>(0);

	private Client client;
	
	public Commande() {
	}
	
	public Commande(Integer cliId, Date comDate, Date comHeure) {
		this.comDate = comDate;
		this.comHeure = comHeure;
	}
	
	@Id
	@Column(name = "COM_ID")
	public Integer getComId() {
	   return comId;
	}
	
	public void setComId(Integer comId) {
	   this.comId = comId;
	}
	
	@Column(name = "COM_DATE", length = 30, nullable = false)
	public Date getComDate() {
	   return comDate;
	}
	
	public void setComDate(Date comDate) {
	   this.comDate = comDate;
	}
	
	@Column(name = "COM_HEURE", length = 30, nullable = false)
	public Date getComHeure() {
	   return comHeure;
	}
	
	public void setComHeure(Date comHeure) {
	   this.comHeure = comHeure;
	}

	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "client")
	public Client getClient() {
	   return client;
	}
	
	public void setClient(Client client) {
	   this.client = client;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "produit")
	public Set<Produit> getProduits() {
	   return produits;
	}
	
	public void setProduits(Set<Produit> produits) {
	   this.produits = produits;
	}
}