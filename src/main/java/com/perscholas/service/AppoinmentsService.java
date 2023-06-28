package com.perscholas.service;

import com.perscholas.exception.UserIdMismatchException;
import com.perscholas.exception.UserNotFoundException;
import com.perscholas.persistence.model.Appointments;
import com.perscholas.persistence.repo.AppoinmentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppoinmentsService {
    @Autowired
    private AppoinmentsRepository appoinmentsRepository;

    public Appointments createAppoinments(Appointments appoinments) {
        return appoinmentsRepository.save(appoinments);
    }

    public Iterable<Appointments> findAll() {
        return appoinmentsRepository.findAll();
    }

    public Appointments findAppoinments(Long id) throws UserNotFoundException {
        return appoinmentsRepository.findById(id).orElseThrow(UserNotFoundException::new);
    }

    public void deleteAppoinments(Long id) throws UserNotFoundException {
        appoinmentsRepository.findById(id)
                .orElseThrow(UserNotFoundException::new);
        appoinmentsRepository.deleteById(id);
    }

    public Appointments updateAppoinments(Appointments appoinments, Long id) throws UserIdMismatchException, UserNotFoundException {
        if (appoinments.getId() != id) {
            throw new UserIdMismatchException();
        }
        appoinmentsRepository.findById(id)
                .orElseThrow(UserNotFoundException::new);
        return appoinmentsRepository.save(appoinments);
    }
}

