package lk.ijse.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CustomerDTO {
    private String nic;
    private String name;
    private String license;
    private String address;
    private String contact;
    private String email;
    private UserDTO user;
    private String nicImage;
    private String licenseImage;
}
