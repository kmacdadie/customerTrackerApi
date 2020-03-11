package com.promineotech.customerTrackerApi.repository;

import org.springframework.data.repository.CrudRepository;

import com.promineotech.customerTrackerApi.entity.Appointment;

public interface AppointmentRepository extends CrudRepository<Appointment, Long> {

}
