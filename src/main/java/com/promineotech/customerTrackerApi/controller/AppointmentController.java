package com.promineotech.customerTrackerApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.customerTrackerApi.entity.Appointment;
import com.promineotech.customerTrackerApi.service.AppointmentService;

@RestController
public class AppointmentController {
	
	@Autowired
	AppointmentService service;
	
	@RequestMapping(value="/appointments", method=RequestMethod.POST)
	public Appointment createAppointment(@RequestBody Appointment appointment) {
		return service.createAppointment(appointment);
	}
	
	@RequestMapping(value="/appointments/{id}")
	public Appointment getAppointment(@PathVariable Long id) {
		return service.getAppointment(id);
	}
	
	@RequestMapping(value="/appointments/{id}", method=RequestMethod.PUT)
	public Appointment updateAppointment(@PathVariable Long id, @RequestBody Appointment appointment) {
		return service.updateAppointment(id, appointment);
	}
	
	@RequestMapping(value="/appointments/{id}", method=RequestMethod.DELETE)
	public void deleteAppointment(@PathVariable Long id) {
		service.deleteAppointment(id);
	}

}
