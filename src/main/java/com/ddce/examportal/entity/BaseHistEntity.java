package com.ddce.examportal.entity;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.Persistable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@MappedSuperclass
public abstract class BaseHistEntity<K> implements Persistable<K> {

	@LastModifiedBy
	@Column(name = "mod_user")
	private String modUser;
	
	@LastModifiedDate
	@Column(name = "mod_date")
	private Instant modDate;
	
	@Id
	@Column(name = "history_update_date")
	private Instant historyUpdateDate;
	
	@Column(name = "history_update_user")
	private String historyUpdateUser;
}
