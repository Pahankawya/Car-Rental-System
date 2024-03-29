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
public class Customer {
    @Id
    private String nic;
    private String name;
    private String license;
    private String address;
    private String contact;
    private String email;
    // CascadeType.ALL means associate-entity do same all operations
    @OneToOne(cascade = CascadeType.ALL)
    private User user;
    private String nicImage;
    private String licenseImage;
}
