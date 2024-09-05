package com.revature.hib.example.inheritance;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name="HOME_INSURANCE")
@DiscriminatorValue("HOME")
@PrimaryKeyJoinColumn(name="INSURANCE_ID")
public class HomeInsurance extends  Insurance
{
	@Column(name="address")
	private String address;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
