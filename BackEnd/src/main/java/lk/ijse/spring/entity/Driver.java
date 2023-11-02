package lk.ijse.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Driver {
    @Id
    private String driverId;
    private String driverName;
    private String driverTel;
    private String driverEmail;
    private String driverPassword;
    private String driverNicId;
    private String driverLicenceId;
    private String driverLicenceImg;
    private String driverNicImg;


}
