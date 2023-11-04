package lk.ijse.spring.dto;

import lk.ijse.spring.embeddable.CarImage;
import lk.ijse.spring.embeddable.FreeMileage;
import lk.ijse.spring.embeddable.Price;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CarAllDTO {
    private String regNum;
    private String type;
    private String color;
    private String brand;
    private String Availability;
    private String transmissionType;
    private String fuelType;
    private int passengers;
    private Price price;
    private FreeMileage freeMileage;
    private BigDecimal extraKMPrice;
    private BigDecimal lostDamageCost;
    private String meterValue;
    private CarImage photos;
}
