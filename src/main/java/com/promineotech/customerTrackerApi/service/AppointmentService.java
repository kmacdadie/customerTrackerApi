package com.promineotech.customerTrackerApi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.promineotech.customerTrackerApi.entity.Appointment;
import com.promineotech.customerTrackerApi.repository.AppointmentRepository;

@Service
public class AppointmentService {
	
	@Autowired
	AppointmentRepository repo;
	
	public Appointment getAppointment(Long id) {
		return repo.findOne(id);
	}
	
	public Iterable<Appointment> GetAppointments() {
		return repo.findAll();
	}
	
	public void deleteAppointment(Long id) {
		repo.delete(id);
	}
	
	public Appointment updateAppointment(Long id, Appointment appointment) {
		Appointment foundAppointment = repo.findOne(id);
		if(foundAppointment != null) {
			foundAppointment.setNextAppointment(appointment.getNextAppointment());
			foundAppointment.setNotes(appointment.getNotes());
			repo.save(foundAppointment);
		}
		return foundAppointment;
	}
	
	public Appointment createAppointment(Appointment appointment) {
		return repo.save(appointment);
	}

}
