package API.Custom.Queries1.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Flight")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long flightId;
    private String description;
    private String fromAirport;
    private String toairport;
    @Enumerated(EnumType.STRING)
    private FlightEnum status;
}