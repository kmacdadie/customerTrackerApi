package com.promineotech.customerTrackerApi.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Appointment {
	
	private Long id;
	private String currentAppointment;
	private String lastAppointment;
	private String nextAppointment;
	private String notes;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getCurrentAppointment() {
		return currentAppointment;
	}

	public void setCurrentAppointment(String currentAppointment) {
		this.currentAppointment = currentAppointment;
	}

	public String getLastAppointment() {
		return lastAppointment;
	}

	public void setLastAppointment(String lastAppointment) {
		this.lastAppointment = lastAppointment;
	}

	public String getNextAppointment() {
		return nextAppointment;
	}

	public void setNextAppointment(String nextAppointment) {
		this.nextAppointment = nextAppointment;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
	
}
