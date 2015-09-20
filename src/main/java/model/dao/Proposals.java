package model.dao;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "proposal")
public class Proposals {
	
	 @Id
	  @GeneratedValue
	  private int id;
	 @ManyToOne
	 @JoinColumn(name="person_id", nullable=false, updatable=false)
	  private Person person;
	  private double basedProposedPrice;
	  private String proposalName;
	  private String description;
	  private String category; 
	  private Timestamp creationDate;
	  private Timestamp updateDate;
	  private boolean isActive;
	  
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	public String getProposalName() {
		return proposalName;
	}
	public void setProposalName(String proposalName) {
		this.proposalName = proposalName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public Timestamp getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}
	
	public Timestamp getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public double getBasedProposedPrice() {
		return basedProposedPrice;
	}
	public void setBasedProposedPrice(double basedProposedPrice) {
		this.basedProposedPrice = basedProposedPrice;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
}
