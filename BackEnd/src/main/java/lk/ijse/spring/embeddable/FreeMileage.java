package lk.ijse.spring.embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Embeddable;
import java.math.BigDecimal;


@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class FreeMileage {
    private BigDecimal dailyRate;
    private BigDecimal monthlyRate;
}
