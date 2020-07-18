package com.mphasis.training.entities1;

import javax.persistence.Cacheable;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
//@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
//@Inheritance(strategy= InheritanceType.JOINED)
@Inheritance(strategy= InheritanceType.TABLE_PER_CLASS)
//@DiscriminatorColumn(name="type", discriminatorType=DiscriminatorType.STRING)
//@DiscriminatorValue(value="Acc")

//doing second level cache
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
public class Account {

	@Id
	private int accno;
	private double balance;
	private String accholdername;
	public int getAccno() {
		return accno;
	}
	public void setAccno(int accno) {
		this.accno = accno;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getAccholdername() {
		return accholdername;
	}
	public void setAccholdername(String accholdername) {
		this.accholdername = accholdername;
	}
	
	
}
