import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "CLIENT",
  uniqueConstraints = { @UniqueConstraint(columnNames = { "CLI_NO" }) })
public class Client {

	private Integer cliId;
	private String cliNo;
	private String cliName;
	private String cliPhone;
		
	public Client() {
	}
	
	public Client(Integer cliId, String cliName, String cliPhone) {
	   this.cliId = cliId;
	   this.cliNo = "06" + this.cliId;
	   this.cliName = cliName;
	   this.cliPhone = cliPhone;
	}
	
	@Id
	@Column(name = "CLI_ID")
	public Integer getCliId() {
	   return cliId;
	}
	
	public void setCliId(Integer cliId) {
	   this.cliId = cliId;
	}
	
	@Column(name = "CLI_NO", length = 30, nullable = false)
	public String getCliNo() {
	   return cliNo;
	}
	
	public void setCliNo(String cliNo) {
	   this.cliNo = cliNo;
	}
	
	@Column(name = "CLI_NAME", nullable = false)
	public String getCliName() {
	   return cliName;
	}
	
	public void setCliName(String cliName) {
	   this.cliName = cliName;
	}
	
	@Column(name = "CLI_PHONE", nullable = false)
	public String getCliPhone() {
	   return cliPhone;
	}
	
	public void setCliPhone(String cliPhone) {
	   this.cliPhone = cliPhone;
	}

}