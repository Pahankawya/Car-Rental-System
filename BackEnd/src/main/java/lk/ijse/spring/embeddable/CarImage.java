package lk.ijse.spring.embeddable;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Embeddable;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CarImage {
    private String front;
    private String back;
    private String side;
    private String interior;
}
