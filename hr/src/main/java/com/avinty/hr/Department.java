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
public class Department {
	private @Id @GeneratedValue(strategy=GenerationType.AUTO) @ManyToOne 
	int id;
	private String depName;
	private @OneToMany Employee managerId;
	private java.sql.Timestamp createdAt;
	private int createdBy;
	private java.sql.Timestamp updatedAt;
	private int updatedBy;
	
	public Department() {}
	
	public Department(String depName, Timestamp createdAt, int createdBy, Timestamp updatedAt,
			int updatedBy) {
		super();
		this.depName = depName;
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



	public String getDepName() {
		return depName;
	}



	public void setDepName(String depName) {
		this.depName = depName;
	}



	public Employee getManagerId() {
		return managerId;
	}



	public void setManagerId(Employee managerId) {
		this.managerId = managerId;
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
		return Objects.hash(createdAt, createdBy, depName, id, managerId, updatedAt, updatedBy);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Department other = (Department) obj;
		return Objects.equals(createdAt, other.createdAt) && createdBy == other.createdBy
				&& Objects.equals(depName, other.depName) && id == other.id && managerId == other.managerId
				&& Objects.equals(updatedAt, other.updatedAt) && updatedBy == other.updatedBy;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", depName=" + depName + ", managerId=" + managerId + ", createdAt=" + createdAt
				+ ", createdBy=" + createdBy + ", updatedAt=" + updatedAt + ", updatedBy=" + updatedBy + "]";
	}

	
}
