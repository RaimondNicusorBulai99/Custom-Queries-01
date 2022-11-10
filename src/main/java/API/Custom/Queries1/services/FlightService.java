package API.Custom.Queries1.services;

import API.Custom.Queries1.entities.Flight;
import static API.Custom.Queries1.entities.FlightEnum.ON_TIME;
import API.Custom.Queries1.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;
@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    public ResponseEntity generate() {
        Random rd = new Random();

        for (int i=0; i<50; i++){
            Flight flight = new Flight();
            flight.setDescription(rd.ints(100,5000).toString());
            flight.setFromAirport(rd.ints(300,8000).toString());
            flight.setToairport(rd.ints(500,10000).toString());
            flight.setStatus(ON_TIME);
            flightRepository.save(flight);
        }
        return ResponseEntity.status(HttpStatus.OK).body("50 flights have been added.");
    }

    public Optional<Flight> singleFlight(long id) { return flightRepository.findById(id); }

    public List<Flight> flight() {
        return flightRepository.findAll();
    }
}