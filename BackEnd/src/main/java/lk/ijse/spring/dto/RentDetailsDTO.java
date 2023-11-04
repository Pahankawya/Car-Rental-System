package lk.ijse.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class RentDetailsDTO {
    private String rentId;
    private String regNum;
    private String nic;
    private BigDecimal driverCost;
    private BigDecimal carCost;
}
