package com.example.invoiceapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Invoice {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String description;
	private double amount;
	private boolean paid;

	public Invoice() {
	}

	public Invoice(String description, double amount, boolean paid) {
		this.description = description;
		this.amount = amount;
		this.paid = paid;
	}

	public Long getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public double getAmount() {
		return amount;
	}

	public boolean isPaid() {
		return paid;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public void setPaid(boolean paid) {
		this.paid = paid;
	}
}
