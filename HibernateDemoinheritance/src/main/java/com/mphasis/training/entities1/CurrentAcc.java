package com.mphasis.training.entities1;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
//@DiscriminatorValue(value="CA")
@PrimaryKeyJoinColumn(name="accno")
public class CurrentAcc extends Account {

	@Column(length=10)
	private String gstin;

	public String getGstin() {
		return gstin;
	}

	public void setGstin(String gstin) {
		this.gstin = gstin;
	}
	
	
}
