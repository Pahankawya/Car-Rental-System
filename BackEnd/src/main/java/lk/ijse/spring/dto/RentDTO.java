package lk.ijse.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class RentDTO {
    private String rentId;
    private CustomerDTO nic;
    private LocalDate pickUpDate;
    private LocalTime pickUpTime;
    private LocalDate returnDate;
    private LocalTime returnTime;
    private String driverRequest;
    private String status;
    private BigDecimal cost;
    private String description;
    private List<RentDetailsDTO> rentDetails;
}
