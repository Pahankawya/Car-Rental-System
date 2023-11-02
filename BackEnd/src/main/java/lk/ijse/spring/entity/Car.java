package lk.ijse.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Car {
    @Id
    private String regId;
    private String brand;
    private String type;

    private int passengers;
    private String transmission;
    private String fuelType;
    private String color;
    private String img;

    private BigDecimal dailyRate;
    private BigDecimal freeKMForDay;
    private BigDecimal monthlyRate;
    private BigDecimal freeKmForMonth;
    private BigDecimal pricePerExtraKM;


}
