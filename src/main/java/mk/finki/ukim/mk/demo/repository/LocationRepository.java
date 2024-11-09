package mk.finki.ukim.mk.demo.repository;

import mk.finki.ukim.mk.demo.bootstrap.DataHolder;
import mk.finki.ukim.mk.demo.model.Location;
import org.springframework.stereotype.Repository;

import javax.xml.crypto.Data;
import java.util.List;
import java.util.Optional;

@Repository
public class LocationRepository {
    public List<Location> findAll(){
        return DataHolder.locations.stream().toList();
    }
    public Optional<Location> find_by_ID(long id){
        return DataHolder.locations.stream().filter(i->i.getId().equals(id)).findFirst();
    }
}
