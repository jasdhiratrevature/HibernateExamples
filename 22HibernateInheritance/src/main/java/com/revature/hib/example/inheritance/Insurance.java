package com.revature.hib.example.inheritance;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

@Entity
@Table(name="INSURANCE")

//@Inheritance(strategy=InheritanceType.SINGLE_TABLE) 

//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

@Inheritance(strategy = InheritanceType.JOINED)
public class Insurance {
	 @Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
	 @Column(name="INSURANCE_ID")
	private Integer id;
	 @Column(name="client")
    private String client;
	 @Column(name="premium")
    private double premium;
    Insurance()
    {
    	
    }
    Insurance(int id,String client,double premium)
    {
    	this.id=id;
    	this.client=client;
    	this.premium=premium;
    }
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}
	public double getPremium() {
		return premium;
	}
	public void setPremium(double premium) {
		this.premium = premium;
	}
    

}
