package mk.finki.ukim.mk.demo.service.impl;

import mk.finki.ukim.mk.demo.model.Location;
import mk.finki.ukim.mk.demo.repository.LocationRepository;
import mk.finki.ukim.mk.demo.service.LocationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationServiceImpl implements LocationService {
    private LocationRepository locationRepository;
    public LocationServiceImpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public Optional<Location> find_by_ID(long id) {
        return locationRepository.find_by_ID(id);
    }

    @Override
    public List<Location> findAll() {
        return locationRepository.findAll();
    }
}
