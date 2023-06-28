package com.perscholas.service;

import com.perscholas.exception.UserNotFoundException;
import com.perscholas.persistence.model.Appoinments;
import com.perscholas.persistence.repo.AppoinmentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppoinmentsService {
    @Autowired
    private AppoinmentsRepository appoinmentsRepository;

    public Appoinments createAppoinments(Appoinments appoinments){
        return appoinmentsRepository.save(appoinments);
    }
public Iterable<Appoinments>findAll(){
        return appoinmentsRepository.findAll();
}
public Appoinments findAppoinments(Long id)throws UserNotFoundException {
        return appoinmentsRepository.findById(id) .orElseThrow(UserNotFoundException::new);
}

}

