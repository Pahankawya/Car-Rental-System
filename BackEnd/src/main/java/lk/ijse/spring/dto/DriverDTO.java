package lk.ijse.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class DriverDTO {
    private String nic;
    private String license;
    private String name;
    private String address;
    private String contact;
    private String email;
    private String availabilityStatus;
    private UserDTO user;
    private MultipartFile licenseImage;
}
