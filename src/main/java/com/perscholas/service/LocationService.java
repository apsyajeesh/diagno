package com.perscholas.service;

import com.perscholas.dto.LocationDto;
import com.perscholas.exception.DataNotFoundException;
import com.perscholas.persistence.model.Location;
import com.perscholas.persistence.repo.LocationRepository;
import org.springframework.stereotype.Service;

@Service
public class LocationService {

    private final LocationRepository locationRepository;

    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public void create(LocationDto locationDto) {
        Location location = new Location();
        location.setId(locationDto.getId());
        location.setLocation(locationDto.getLocation());
        locationRepository.save(location);
    }

    public LocationDto edit(Long id) {
        LocationDto locationDto = new LocationDto();
        Location location = findLocation(id);
        locationDto.setId(location.getId());
        locationDto.setLocation(location.getLocation());
        return locationDto;
    }

    public Iterable<Location> findAll() {
        return locationRepository.findAll();
    }

    public Location findLocation(Long id) throws DataNotFoundException {
        return locationRepository.findById(id)
                .orElseThrow(DataNotFoundException::new);
    }

    public void delete(Long id) throws DataNotFoundException {
        locationRepository.findById(id)
                .orElseThrow(DataNotFoundException::new);
        locationRepository.deleteById(id);
    }
}

