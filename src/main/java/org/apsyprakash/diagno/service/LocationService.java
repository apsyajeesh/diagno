package org.apsyprakash.diagno.service;

import org.apsyprakash.diagno.dto.LocationDto;
import org.apsyprakash.diagno.exception.DataNotFoundException;
import org.apsyprakash.diagno.persistence.model.Location;
import org.apsyprakash.diagno.persistence.repo.LocationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * manages location management
 */
@Service
public class LocationService {

    private static final Logger logger = LoggerFactory.getLogger(LocationService.class);

    private final LocationRepository locationRepository;

    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public void create(LocationDto locationDto) {
        Location location = new Location();
        location.setId(locationDto.getId());
        location.setLocation(locationDto.getLocation());
        locationRepository.save(location);
        logger.info("Successfully created a location " + location.getLocation());
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

