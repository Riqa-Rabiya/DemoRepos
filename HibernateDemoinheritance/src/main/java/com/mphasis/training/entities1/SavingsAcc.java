package com.mphasis.training.entities1;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
//@DiscriminatorValue(value="SA")
@PrimaryKeyJoinColumn(name="accno")
public class SavingsAcc extends Account {

	private long adharnum;

	public long getAdharnum() {
		return adharnum;
	}

	public void setAdharnum(long adharnum) {
		this.adharnum = adharnum;
	}
	
	
}
