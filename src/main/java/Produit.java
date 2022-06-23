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
@Table(name = "PRODUIT",
  uniqueConstraints = { @UniqueConstraint(columnNames = { "PRO_NO" }) })
public class Produit {

	private Integer proId;
	private double proPrix;

	private Set<Produit> produits = new HashSet<Produit>(0);
	
	public Produit() {
	}
	
	public Produit(Integer proId, double proPrix) {
	   this.proId = proId;
	   this.proPrix = proPrix;
	}
	
	@Id
	@Column(name = "PRO_ID")
	public Integer getProId() {
	   return proId;
	}
	
	public void setProId(Integer proId) {
	   this.proId = proId;
	}
	
	@Column(name = "PRO_NO", length = 30, nullable = false)
	public double getProNo() {
	   return proPrix;
	}
	
	public void setProNo(double proPrix) {
	   this.proPrix = proPrix;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "produit")
	public Set<Produit> getProduits() {
	   return produits;
	}
	
	public void setProduits(Set<Produit> produits) {
	   this.produits = produits;
	}
}