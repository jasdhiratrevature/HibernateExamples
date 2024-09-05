package com.revature.hib.example.inheritance;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name="CAR_INSURANCE")
@DiscriminatorValue("CAR")
@PrimaryKeyJoinColumn(name="INSURANCE_ID")

public class CarInsurance extends  Insurance
{
	@Column(name="CarNo")
	String  carNo;
	@Column(name="CarModel")
	private String carModel;
	CarInsurance()
	{
		
	}
	public CarInsurance(String carNo, String carModel) {
        this.carNo = carNo;
        this.carModel = carModel;
    }
	public String getCarNo() {
		return carNo;
	}
	public void setCarNo(String carNo) {
		this.carNo = carNo;
	}
	public String getCarModel() {
		return carModel;
	}
	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}
	

}
