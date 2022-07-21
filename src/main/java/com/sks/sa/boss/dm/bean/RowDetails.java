package com.sks.sa.boss.dm.bean;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@MappedSuperclass
public class RowDetails implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonIgnore
	@CreatedDate
	@Column(name = "created_dte", updatable = false)
	private Date createdDate;
	
	@JsonIgnore
	@CreatedBy
	@Column(name="created_by" , updatable = false)
	private String createdBy;
	
	@JsonIgnore
	@LastModifiedDate
	@Column(name="updated_dte")
	private Date updatedDate;
	
	@JsonIgnore
	@LastModifiedBy
	@Column(name = "updated_by")
	private String updatedBy;
	
	@PrePersist
	@PreUpdate
	public void onUpdateOrPersist() {
		createdDate = Calendar.getInstance().getTime();
		createdBy = "owner"; //SecurityUtils.getCurrentPrenciple().getUserId();
		updatedDate = createdDate;
		updatedBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	
	

}
