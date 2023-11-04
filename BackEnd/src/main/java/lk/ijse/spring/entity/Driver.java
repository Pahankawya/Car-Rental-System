package lk.ijse.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Driver {
    @Id
    private String nic;
    private String license;
    private String name;
    private String address;
    private String contact;
    private String email;
    private String availabilityStatus;
    @OneToOne(cascade = CascadeType.ALL)
    private User user;
    private String licenseImage;
}
