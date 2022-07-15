package com.ddce.examportal.entity;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.PostLoad;
import javax.persistence.PrePersist;
import javax.persistence.Transient;

import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.Persistable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;


@MappedSuperclass
@EntityListeners(value = {AuditingEntityListener.class})
public abstract class BaseEntity<K> implements Persistable<K> {
	
	@LastModifiedBy
	@Column(name = "mod_user")
	private String modUser;
	
	@LastModifiedDate
	@Column(name = "mod_date")
	private Instant modDate;

	@Transient
	private boolean isNew = true;
	
	public String getModUser() {
		return modUser;
	}

	public void setModUser(String modUser) {
		this.modUser = modUser;
	}

	public Instant getModDate() {
		return modDate;
	}

	public void setModDate(Instant modDate) {
		this.modDate = modDate;
	}

	@JsonIgnore
	@Override
	public boolean isNew() {return isNew;}
	
	@PrePersist
	@PostLoad
	void markNotNew() {this.isNew = false;}
}
