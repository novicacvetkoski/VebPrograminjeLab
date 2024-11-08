package mk.finki.ukim.mk.demo.repository;

import mk.finki.ukim.mk.demo.bootstrap.DataHolder;
import mk.finki.ukim.mk.demo.model.Location;

import javax.xml.crypto.Data;
import java.util.List;

public class LocationRepository {
    public List<Location> findAll(){
        return DataHolder.locations.stream().toList();
    }
}
