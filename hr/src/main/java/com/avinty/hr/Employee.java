package com.avinty.hr;

import java.sql.Timestamp;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Employee{
	private @Id @GeneratedValue(strategy=GenerationType.AUTO) @OneToMany 
	int id;
	private String eEmail;
	private String ePassword;
	private String eName;
	private @ManyToOne Department depId;
	private java.sql.Timestamp createdAt;
	private int createdBy;
	private java.sql.Timestamp updatedAt;
	private int updatedBy;

	public Employee() {}
	
	public Employee(String eEmail, String ePassword, String eName, Timestamp createdAt,
			int createdBy, Timestamp updatedAt, int updatedBy) {
		super();
		this.eEmail = eEmail;
		this.ePassword = ePassword;
		this.eName = eName;
		this.createdAt = createdAt;
		this.createdBy = createdBy;
		this.updatedAt = updatedAt;
		this.updatedBy = updatedBy;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String geteEmail() {
		return eEmail;
	}

	public void seteEmail(String eEmail) {
		this.eEmail = eEmail;
	}

	public String getePassword() {
		return ePassword;
	}

	public void setePassword(String ePassword) {
		this.ePassword = ePassword;
	}

	public String geteName() {
		return eName;
	}

	public void seteName(String eName) {
		this.eName = eName;
	}

	public Department getDepId() {
		return depId;
	}

	public void setDepId(Department depId) {
		this.depId = depId;
	}

	public java.sql.Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(java.sql.Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public int getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	public java.sql.Timestamp getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(java.sql.Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

	public int getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(int updatedBy) {
		this.updatedBy = updatedBy;
	}

	@Override
	public int hashCode() {
		return Objects.hash(createdAt, createdBy, depId, eEmail, id, eName, ePassword, updatedAt, updatedBy);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(createdAt, other.createdAt) && createdBy == other.createdBy && depId == other.depId
				&& Objects.equals(eEmail, other.eEmail) && id == other.id && Objects.equals(eName, other.eName)
				&& Objects.equals(ePassword, other.ePassword) && Objects.equals(updatedAt, other.updatedAt)
				&& updatedBy == other.updatedBy;
	}

	@Override
	public String toString() {
		return "Employee [eId=" + id + ", eEmail=" + eEmail + ", ePassword=" + ePassword + ", eName=" + eName
				+ ", depId=" + depId + ", createdAt=" + createdAt + ", createdBy=" + createdBy + ", updatedAt="
				+ updatedAt + ", updatedBy=" + updatedBy + "]";
	}
	
}
