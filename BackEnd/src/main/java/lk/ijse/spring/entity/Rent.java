package lk.ijse.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Rent {
    @Id
    private String rentId;

    // CascadeType.REFRESH : the associated entities in the relationship will also be refreshed

    @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "nic",referencedColumnName = "nic", nullable = false)
    private Customer nic;
    private LocalDate pickUpDate;
    private LocalTime pickUpTime;
    private LocalDate returnDate;
    private LocalTime returnTime;
    private String driverRequest;
    private String status;
    private BigDecimal cost;
    private String description;

    @OneToMany(mappedBy = "rent",cascade = CascadeType.ALL)
    private List<RentDetails> rentDetails;
}
