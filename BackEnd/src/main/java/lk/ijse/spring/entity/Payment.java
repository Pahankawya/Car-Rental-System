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
public class Payment {
    @Id
    private String paymentId;
    private BigDecimal timeCost;
    private BigDecimal extraKM;
    private BigDecimal damage;
    private BigDecimal total;

}
