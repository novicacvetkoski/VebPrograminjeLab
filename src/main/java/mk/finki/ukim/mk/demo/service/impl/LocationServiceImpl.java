package mk.finki.ukim.mk.demo.service.impl;

import mk.finki.ukim.mk.demo.model.Location;
import mk.finki.ukim.mk.demo.repository.LocationRepository;
import mk.finki.ukim.mk.demo.service.LocationService;

import java.util.List;

public class LocationServiceImpl implements LocationService {
    private LocationRepository locationRepository;

    public LocationServiceImpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public List<Location> findAll() {
        return locationRepository.findAll();
    }
}
